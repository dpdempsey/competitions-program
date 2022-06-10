/*
 * Student name: XXX
 * Student ID: YYY
 * LMS username: ZZZ
 */

import java.util.ArrayList;

public class Bill {
    private ArrayList<Bill> bills = new ArrayList<Bill>();
    private String billId;
    private String memberID;
    private double billAmount;
    private boolean used;

    public Bill(String billID, String memberID, Double billAmount, boolean used) {
        this.memberID = memberID;
        this.billId = billID;
        this.billAmount = billAmount;
        this.used = used;
    }

    public void add(Bill bill) {
        bills.add(bill);
    }
}
