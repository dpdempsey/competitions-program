/*
 * Student name: XXX
 * Student ID: YYY
 * LMS username: ZZZ
 */

public class Entry {
    private int entryId;
    private static int counter = 0;
    private String billId;
    private String memberID;
    private int[] luckyNumbers;
    private int prize;

    public Entry(){
        
    }

    public Entry(int[] numbers) {
        this.entryId = counter++;
    }

    public Entry(int entryID, String billID, String memberID) {
        this.entryId = entryID;
        this.billId = billID;
        this.memberID = memberID;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return this.prize;
    }
}
