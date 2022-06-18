/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

import java.util.ArrayList;
import java.util.Arrays;

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
    private ArrayList<Entry> winners = new ArrayList<Entry>();
    private boolean testingMode;

    public LuckyNumbersCompetition(String compName, boolean testingMode, ArrayList<Member> members) {
        super(members);
        setName(compName);
        setID(Competition.compCount++);
        this.testingMode = testingMode;
    }

    public void addEntries(Bill bill) {
        int numOfEntries = bill.getEntries();
        String memberId = bill.getMemberId();
        int manualEntries = bill.getManualEntries();
        int[] luckyNumbers = null;
        NumbersEntry numEnt = new NumbersEntry();
        AutoNumbersEntry autoNumEnt = new AutoNumbersEntry();

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
            luckyNumbers = autoNumEnt.createNumbers(entries.size());
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

    public void drawWinners(ArrayList<Member> members) {
        System.out.println(info());
        AutoNumbersEntry autoNum = new AutoNumbersEntry();
        int[] winNum = autoNum.createNumbers(getID());

        System.out.print("Lucky Numbers:");
        for (int i = 0; i < winNum.length; i++) {
            System.out.printf("%3d", winNum[i]);
        }
        System.out.println(" [Auto]");

        ArrayList<String> winMemberId = new ArrayList<String>();
        for (Entry entry : entries) {
            int entryNum[] = entry.getNumbers();
            int match = checkEntries(winNum, entryNum);
            if (match > 2) {
                String memberId = entry.getMemberId();
                if (!winMemberId.contains(memberId)) {
                    String memberName = getMemberName(memberId);
                    int prize = prizes[entryNum.length - match];
                    entry.setPrize(prize);
                    winners.add(entry);
                    winMemberId.add(memberId);
                }
            }
        }

        System.out.println("Winning Entries:");
        int totalPrize = 0;
        for(Entry entry : winners){
            System.out.println("Member ID: " + entry.getMemberId() + ", Member Name: " + getMemberName(entry.getMemberId()) + ", Prize: " + entry.getPrize());
            System.out.print("--> Entry ID: " + entry.getEntryId() +", Numbers:");
            int[] temp = entry.getNumbers();
            for(int i=0; i<temp.length; i++){
                System.out.printf("%3d", temp[i]);
            }
            if(!entry.isManualEntry()){
                System.out.println(" [Auto]");
            } else{
                System.out.println();
            }
            totalPrize += entry.getPrize();       
        }
        int winEnt = winners.size();
        setReportInfo(totalPrize, entries.size(), winEnt);
    }

    public boolean hasEntries() {
        if (entries.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public String info() {
        return "Competition ID: " + getID() + ", Competition Name: " + getName() + ", Type: LuckyNumbersCompetition";
    }

    public boolean checkMax(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > 35) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDuplicate(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[i] == intArray[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printNums(Entry entry) {
        int[] nums = entry.getNumbers();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

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
}
