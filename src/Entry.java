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
    private static int counter = 1;

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

    public Entry(String memberId, int[] numEnt) {
        this.entryId = counter++;
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

    public String getMemberId() {
        return this.memberId;
    }

    public void printInfo() {
        System.out.print("Entry ID: " + getEntryId() + "      Numbers: ");
        for (int i = 0; i < luckyNumbers.length; i++) {
            System.out.printf("%3d", luckyNumbers[i]);
        }
    }

    public void printNums() {
        for (int i = 0; i < luckyNumbers.length; i++) {
            System.out.printf("%2d", luckyNumbers[i]);
        }
    }
}
