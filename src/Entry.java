/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

import java.io.Serializable;

/**
 * Entry class used to create entry objects
 * 
 * @author Declan Dempsey
 */
public class Entry implements Serializable, Comparable<Entry> {
    private int entryId;
    private String billId;
    private String memberId;
    private int[] luckyNumbers;
    private int prize;
    private boolean manualEntry;
    private int match;
    private static int counter = 1;

    /**
     * Default constructor
     */
    public Entry() {
    }

    /**
     * Used for entry objects for RandomPick
     * 
     * @param memberId the member's Id number
     */
    public Entry(String memberId) {
        this.entryId = counter++;
        this.memberId = memberId;
    }

    /**
     * Used for entry objects of LuckyNumbers
     * 
     * @param memberId    member Id number
     * @param numEnt      the 7 lucky numbers
     * @param manualEntry whether it is a manual or auto entry
     */
    public Entry(String memberId, int[] numEnt, boolean manualEntry) {
        this.entryId = counter++;
        this.memberId = memberId;
        this.luckyNumbers = numEnt;
        this.manualEntry = manualEntry;
    }

    /**
     * Used in formatting and printing the entry ID and lucky numbers of an entry
     */
    public void printNumbersInfo() {
        System.out.print(formatEntryId() + " Numbers:");
        for (int i = 0; i < luckyNumbers.length; i++) {
            System.out.printf("%3d", luckyNumbers[i]);
        }

        if (!isManualEntry()) {
            System.out.println(" [Auto]");
        } else {
            System.out.println();
        }
    }

    /**
     * Formats the entry ID for printing
     * 
     * @return a formatted entry ID
     */
    public String formatEntryId() {
        String s = Integer.toString(getEntryId());
        s = String.format("Entry ID: %-6s", s);
        return s;
    }

    /**
     * Printing the numbers from luckyNumbers array
     */
    public void printNums() {
        for (int i = 0; i < luckyNumbers.length; i++) {
            System.out.printf("%2d", luckyNumbers[i]);
        }
    }

    public int compareTo(Entry entry) {
        return this.entryId - entry.getEntryId();
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return this.prize;
    }

    public int getEntryId() {
        return this.entryId;
    }

    public int[] getNumbers() {
        return this.luckyNumbers;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public void printInfo() {
        System.out.print(formatEntryId());
    }

    public boolean isManualEntry() {
        return this.manualEntry;
    }

    public void resetCounter() {
        counter = 1;
    }

    public void setMatch(int match) {
        this.match = match;
    }

    public int getMatch() {
        return this.match;
    }

    public void setCounter(int count) {
        counter = count;
    }
}
