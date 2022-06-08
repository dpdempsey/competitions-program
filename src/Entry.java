/*
 * Student name: XXX
 * Student ID: YYY
 * LMS username: ZZZ
 */

public class Entry {
    private int entryId;
    private String billId;
    private String memberID;
    private int prize;
    
    public Entry(){
        //default
    }

    public Entry(int entryID, String billID, String memberID){
        this.entryId = entryID;
        this.billId = billID;
        this.memberID = memberID;

    }




    public void setPrize(int prize){
        this.prize = prize;
    }

    public int getPrize(){
        return this.prize;
    }
}
