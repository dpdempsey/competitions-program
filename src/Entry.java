/*
 * Student name: XXX
 * Student ID: YYY
 * LMS username: ZZZ
 */

import java.util.ArrayList;

public class Entry {
    private int entryId;
    private String billId;
    private String memberID;
    private double billAmount;
    private boolean used;
    private ArrayList<Entry> entries = new ArrayList<Entry>();
    private int prize;

    public Entry() {
        // default
    }

    public Entry(int entryID, String billID, String memberID) {
        this.entryId = entryID;
        this.billId = billID;
        this.memberID = memberID;

    }

    public Entry(String billID, String memberID, Double billAmount, boolean used) {
        this.memberID = memberID;
        this.billId = billID;
        this.billAmount = billAmount;
        this.used = used;

    }

    public void add(Entry entry) {
        entries.add(entry);
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return this.prize;
    }
}
