/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.Collections;

/**
 * Create LuckyNumbers competitions
 * 
 * @author Declan Dempsey
 */
public class LuckyNumbersCompetition extends Competition {
    private final int FIRST_PRIZE = 50000;
    private final int SECOND_PRIZE = 5000;
    private final int THIRD_PRIZE = 1000;
    private final int FOURTH_PRIZE = 500;
    private final int FIFTH_PRIZE = 100;
    private final int SIXTH_PRIZE = 50;
    private final int[] prizes = { FIRST_PRIZE, SECOND_PRIZE, THIRD_PRIZE, FOURTH_PRIZE, FIFTH_PRIZE, SIXTH_PRIZE };
    private ArrayList<Entry> entries = new ArrayList<Entry>();
    private ArrayList<Entry> tempEnt = new ArrayList<Entry>();
    private HashMap<String, Entry> winners = new HashMap<String, Entry>();
    private boolean testingMode;

    /**
     * Create a competition with given parameters
     * 
     * @param compName    the name of the competition
     * @param testingMode whether it is testing mode
     * @param members     the list of members
     */
    public LuckyNumbersCompetition(String compName, boolean testingMode, ArrayList<Member> members) {
        super(members);
        setName(compName);
        setID(Competition.compCount++);
        this.testingMode = testingMode;
    }

    /**
     * Add entries to a LuckyNumbers competition
     */
    public void addEntries(Bill bill) {
        int numOfEntries = bill.getEntries();
        String memberId = bill.getMemberId();
        int manualEntries = bill.getManualEntries();
        Random randomGenerator = new Random();
        int[] luckyNumbers = null;
        NumbersEntry numEnt = new NumbersEntry();
        AutoNumbersEntry autoNumEnt = new AutoNumbersEntry();
        if (entries.size() > 0) {
            Entry entry = new Entry();
            entry.setCounter(entries.size() + 1);
        }

        if (manualEntries > 0) {
            for (int i = 0; i < manualEntries; i++) {
                numEnt.manualEntries();
                luckyNumbers = numEnt.getNumbers();
                Entry entry = new Entry(memberId, luckyNumbers, true);
                entries.add(entry);
                tempEnt.add(entry);
            }
        }

        int diff = numOfEntries - manualEntries;
        for (int i = 0; i < diff; i++) {
            if (getIsTestingMode()) {
                luckyNumbers = autoNumEnt.createNumbers(entries.size());
            } else {
                luckyNumbers = autoNumEnt.createNumbers(randomGenerator.nextInt());
            }
            Entry entry = new Entry(memberId, luckyNumbers, false);
            entries.add(entry);
            tempEnt.add(entry);
        }

        System.out.println("The following entries have been added:");
        for (Entry entry : tempEnt) {
            entry.printNumbersInfo();
        }
        tempEnt.clear();

    }

    /**
     * Draw winners from a LuckyNumbers competition
     */
    public void drawWinners(ArrayList<Member> members) {
        System.out.println(info());
        Random randomGenerator = new Random();
        AutoNumbersEntry autoNum = new AutoNumbersEntry();
        int[] winNum;
        if (getIsTestingMode()) {
            winNum = autoNum.createNumbers(this.getID());
        } else {
            winNum = autoNum.createNumbers(randomGenerator.nextInt());
        }

        System.out.print("Lucky Numbers:");
        for (int i = 0; i < winNum.length; i++) {
            System.out.printf("%3d", winNum[i]);
        }
        System.out.println(" [Auto]");
        int match;

        for (Entry entry : entries) {
            int entryNum[] = entry.getNumbers();
            match = checkEntries(winNum, entryNum);
            if (match >= 2) {
                String memberId = entry.getMemberId();
                int prize = prizes[entryNum.length - match];
                entry.setPrize(prize);
                if (!winners.containsKey(memberId)) {
                    winners.put(memberId, entry);
                } else {
                    int lastPrize = winners.get(memberId).getPrize();
                    if (prize > lastPrize) {
                        winners.put(memberId, entry);
                    }
                }
            }
        }
        ArrayList<Entry> listOfWinners = new ArrayList<>(winners.values());
        Collections.sort(listOfWinners);
        System.out.println("Winning entries:");
        int totalPrize = 0;
        for (Entry entry : listOfWinners) {
            int entryPrize = entry.getPrize();
            String s = Integer.toString(entryPrize);
            s = String.format("%-5s", s);
            System.out.println("Member ID: " + entry.getMemberId() + ", Member Name: "
                    + getMemberName(entry.getMemberId()) + ", Prize: " + s);
            System.out.print("--> Entry ID: " + entry.getEntryId() + ", Numbers:");
            int[] temp = entry.getNumbers();
            for (int i = 0; i < temp.length; i++) {
                System.out.printf("%3d", temp[i]);
            }
            if (!entry.isManualEntry()) {
                System.out.println(" [Auto]");
            } else {
                System.out.println();
            }
            totalPrize += entry.getPrize();
        }
        int winEnt = winners.size();
        setReportInfo(totalPrize, entries.size(), winEnt);
        winners.clear();
        entries.clear();
    }

    /**
     * To check whether the competition has entries
     * 
     * @return false if there is no entries
     */
    public boolean hasEntries() {
        if (entries.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks the members entries with the winning lucky numbers
     * 
     * @param winNum   the winning numbers
     * @param entryNum the entry's numbers
     * @return a value denoting the number of matches
     */
    public int checkEntries(int[] winNum, int[] entryNum) {
        int count = 0;
        for (int i = 0; i < winNum.length; i++) {
            for (int j = 0; j < winNum.length; j++) {
                if (winNum[i] == entryNum[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Prints out competition information
     */
    public String info() {
        return "Competition ID: " + getID() + ", Competition Name: " + getName() + ", Type: LuckyNumbersCompetition";
    }

    public boolean getIsTestingMode() {
        return this.testingMode;
    }

    public int getEntrySize() {
        return entries.size();
    }

    public void setCount(int count) {
        setID(count);
    }
}
