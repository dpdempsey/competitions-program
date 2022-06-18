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
    private static int compCount = 1;
    private static int count = 1;
    private boolean testingMode;

    public RandomPickCompetition(String compName, boolean testingMode, ArrayList<Member> members) {
        super(members);
        setName(compName);
        setID(compCount++);
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

        int winningEntryCount = 0;
        while (winningEntryCount < MAX_WINNING_ENTRIES) {
            int winningEntryIndex = randomGenerator.nextInt(entries.size());

            Entry winningEntry = entries.get(winningEntryIndex);
            String memberId = winningEntry.getMemberId();
            if (winningEntry.getPrize() == 0 && !winMemberId.contains(memberId)) {
                int currentPrize = prizes[winningEntryCount];
                winningEntry.setPrize(currentPrize);
                winMemberId.add(memberId);
                winningEntryCount++;
            }
        }

        /*
         * Ensure that once an entry has been selected,
         * it will not be selected again.
         */
        /*
         * Note that the above piece of code does not ensure that
         * one customer gets at most one winning entry. Add your code
         * to complete the logic.
         */
    }

    public void addEntries(Bill bill) {
        int numOfEntries = bill.getEntries();
        String memberId = bill.getMemberId();
        for (int i = 0; i < numOfEntries; i++) {
            Entry entry = new Entry(memberId, count++);
            entries.add(entry);
            tempEnt.add(entry);
        }

        System.out.println("The following entries have been automatically generated:");
        for (Entry entry : tempEnt) {
            System.out.println("Entry ID: " + entry.getEntryId());
        }
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
}
