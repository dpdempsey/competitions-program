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
    private int numOfEntries;
    private boolean used;

    public Bill(String billID, String memberID, Double billAmount, boolean used) {
        this.memberID = memberID;
        this.billId = billID;
        this.billAmount = billAmount;
        this.used = used;
    }

    public Bill(){

    }

    public void add(Bill bill) {
        bills.add(bill);
    }

    public Bill iterate(String billID) {
        for (Bill bill : bills) {
            if ((bill.getBillId()).equals(billID)) {
                if ((bill.getMemberId()).equals(" ")) {
                    System.out.println("This bill has no member id. Please try again.");
                } else {
                    return bill;
                }
            }
        }
        return null;
    }

    public int getEntries(){
        int temp = ((int)this.billAmount/50);
        this.numOfEntries = temp;
        return temp;
    }

    public String getBillId() {
        return this.billId;
    }

    public String getMemberId() {
        return this.memberID;
    }

    public double getBillAmount(){
        return this.billAmount;
    }

    public ArrayList<Bill> getBills(){
        return this.bills;
    }
}
