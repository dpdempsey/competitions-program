/*
 * Student name: XXX
 * Student ID: YYY
 * LMS username: ZZZ
 */

public class Entry {
    private int entryId;
    //private static int counter = 1;
    private String billId;
    private String memberId;
    private int[] luckyNumbers;
    private int prize;

    public Entry(){
    }

    public Entry(String memberId, int counter){
        this.entryId = counter;
        this.memberId = memberId;
    }

    public Entry(String memberId, int counter, int[] numEnt){
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

    public int getEntryId(){
        return this.entryId;
    }

    public int[] getNumbers(){
        return this.luckyNumbers;
    }
}
