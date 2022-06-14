/*
 * Student name: XXX
 * Student ID: YYY
 * LMS username: ZZZ
 */

import java.util.Random;
import java.util.ArrayList;

public class RandomPickCompetition extends Competition {
    private final int FIRST_PRIZE = 50000;
    private final int SECOND_PRIZE = 5000;
    private final int THIRD_PRIZE = 1000;
    private final int[] prizes = { FIRST_PRIZE, SECOND_PRIZE, THIRD_PRIZE };
    private ArrayList<Entry> entries = new ArrayList<Entry>();
    private final int MAX_WINNING_ENTRIES = 3;

    public RandomPickCompetition(String compName) {
        setName(compName);
        setID(counter++);
    }

    public void drawWinners() {
        Random randomGenerator = null;
        if (this.getIsTestingMode()) {
            randomGenerator = new Random(this.getId());
        } else {
            randomGenerator = new Random();
        }

        int winningEntryCount = 0;
        while (winningEntryCount < MAX_WINNING_ENTRIES) {
            int winningEntryIndex = randomGenerator.nextInt(entries.size());

            Entry winningEntry = entries.get(winningEntryIndex);

            /*
             * Ensure that once an entry has been selected,
             * it will not be selected again.
             */
            if (winningEntry.getPrize() == 0) {
                int currentPrize = prizes[winningEntryCount];
                winningEntry.setPrize(currentPrize);
                winningEntryCount++;
            }
        }

        /*
         * Note that the above piece of code does not ensure that
         * one customer gets at most one winning entry. Add your code
         * to complete the logic.
         */
    }

    public void addEntries() {
        
    }

    public void addEntries(int billEntries) {
        for(int i=0; i<billEntries; i++){
            Entry entry = new Entry();
            entries.add(entry);
        }
    }

    public boolean getIsTestingMode() {
        return false;
    }

    public int getId() {
        return 12345;
    }

    public String info() {
        return "Competition ID: " + getID() + ", Competition Name: " + getName() + ", Type: RandomPickCompetition";
    }
}
