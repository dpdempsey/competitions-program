/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

import java.util.Random;
import java.util.ArrayList;

public class RandomPickCompetition extends Competition {
    private final int FIRST_PRIZE = 50000;
    private final int SECOND_PRIZE = 5000;
    private final int THIRD_PRIZE = 1000;
    private final int[] prizes = { FIRST_PRIZE, SECOND_PRIZE, THIRD_PRIZE };
    private final int MAX_WINNING_ENTRIES = 3;
    private ArrayList<Entry> entries = new ArrayList<Entry>();
    private ArrayList<Entry> tempEnt = new ArrayList<Entry>();
    private ArrayList<Entry> winners = new ArrayList<Entry>();
    private int countEntries;
    private boolean testingMode;

    public RandomPickCompetition(String compName, boolean testingMode, ArrayList<Member> members) {
        super(members);
        setName(compName);
        setID(Competition.compCount++);
        this.testingMode = testingMode;
    }

    public void drawWinners(ArrayList<Member> members) {
        ArrayList<String> winMemberId = new ArrayList<String>();
        Random randomGenerator = null;
        if (this.getIsTestingMode()) {
            randomGenerator = new Random(this.getID());
        } else {
            randomGenerator = new Random();
        }

        int totalPrize = 0;
        int winningEntryCount = 0;
        while (winningEntryCount < MAX_WINNING_ENTRIES) {
            int winningEntryIndex = randomGenerator.nextInt(entries.size());
            
            Entry winningEntry = entries.get(winningEntryIndex);
            String memberId = winningEntry.getMemberId();
            if (winningEntry.getPrize() == 0 && !winMemberId.contains(memberId)) {
                int currentPrize = prizes[winningEntryCount];
                winningEntry.setPrize(currentPrize);
                winMemberId.add(memberId);
                winners.add(winningEntry);
                winningEntryCount++;
            }
            if(countEntries == winningEntryCount){
                break;
            }
            totalPrize += winningEntry.getPrize();
        }

        System.out.println(info());
        System.out.println("Winning entries:");
        for(Entry entry : winners){
            int entryPrize = entry.getPrize();
            String s = Integer.toString(entryPrize);
            s = String.format("%-5s", s);
            System.out.println("Member ID: " + entry.getMemberId() + ", Member Name: " + getMemberName(entry.getMemberId()) + ", Entry ID: " + entry.getEntryId() + ", Prize: " + s);
        }
        int winEnt = winners.size();
        setReportInfo(totalPrize, entries.size(), winEnt);
    }

    public void addEntries(Bill bill) {
        int numOfEntries = bill.getEntries();
        String memberId = bill.getMemberId();
        for (int i = 0; i < numOfEntries; i++) {
            Entry entry = new Entry(memberId);
            entries.add(entry);
            tempEnt.add(entry);
        }

        System.out.println("The following entries have been automatically generated:");
        for (Entry entry : tempEnt) {
            entry.printInfo();
            System.out.print("\n");
        }
        countEntries++;
        tempEnt.clear();
    }

    public boolean getIsTestingMode() {
        return this.testingMode;
    }

    public String info() {
        return "Competition ID: " + getID() + ", Competition Name: " + getName() + ", Type: RandomPickCompetition";
    }

    public boolean hasEntries() {
        if (entries.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getEntrySize(){
        return entries.size();
    }
}
