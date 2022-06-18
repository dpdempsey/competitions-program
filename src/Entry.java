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
    private boolean manualEntry;
    private static int counter = 1;

    public Entry() {
    }

    public Entry(String memberId) {
        this.entryId = counter++;
        this.memberId = memberId;
    }

    public Entry(String memberId, int[] numEnt, boolean manualEntry) {
        this.entryId = counter++;
        this.memberId = memberId;
        this.luckyNumbers = numEnt;
        this.manualEntry = manualEntry;
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

    public String formatEntryId(){
        String s =  Integer.toString(getEntryId());
        s = String.format("Entry ID: %-6s", s );
        return s;
    }

    public int[] getNumbers() {
        return this.luckyNumbers;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public void printNumbersInfo() {
        System.out.print(formatEntryId() + "Numbers: ");
        for (int i = 0; i < luckyNumbers.length; i++) {
            System.out.printf("%3d", luckyNumbers[i]);
        }

        if(!isManualEntry()){
            System.out.println(" [Auto]");
        } else{
            System.out.println();
        }
    }

    public void printInfo() {
        System.out.print(formatEntryId());
    }

    public void printNums() {
        for (int i = 0; i < luckyNumbers.length; i++) {
            System.out.printf("%2d", luckyNumbers[i]);
        }
    }

    public boolean isManualEntry(){
        return this.manualEntry;
    }
}
