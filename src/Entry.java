/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

import java.util.Arrays;

public class Entry {
    private int entryId;
    private String billId;
    private String memberId;
    private int[] luckyNumbers;
    private int prize;

    public Entry() {
    }

    public Entry(String memberId, int counter) {
        this.entryId = counter;
        this.memberId = memberId;
    }

    public Entry(String memberId, int counter, int[] numEnt) {
        this.entryId = counter;
        this.memberId = memberId;
        this.luckyNumbers = numEnt;
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

    public String printInfo() {
        return "Entry ID: " + getEntryId() + "    Numbers: " + printNums();
    }

    public String printNums() {
        String strOfInts = Arrays.toString(this.luckyNumbers).replaceAll("\\[|\\]|,", "");
        return strOfInts;
    }
}
