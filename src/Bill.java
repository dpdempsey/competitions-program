/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

import java.util.ArrayList;

public class Bill {
    private ArrayList<Bill> bills = new ArrayList<Bill>();
    private String billId;
    private String memberID;
    private double billAmount;
    private int numOfEntries;
    private int manualEntries;
    private boolean used;

    public Bill(String billID, String memberID, Double billAmount, boolean used) {
        this.memberID = memberID;
        this.billId = billID;
        this.billAmount = billAmount;
        this.used = used;
    }

    public Bill() {

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

    public int getEntries() {
        int temp = ((int) this.billAmount / 50);
        this.numOfEntries = temp;
        return temp;
    }

    public String getBillId() {
        return this.billId;
    }

    public String getMemberId() {
        return this.memberID;
    }

    public double getBillAmount() {
        return this.billAmount;
    }

    public ArrayList<Bill> getBills() {
        return this.bills;
    }

    public boolean getUsed() {
        return this.used;
    }

    public void usedBill() {
        this.used = true;
    }

    public void setManualEntries(int manualEntries) {
        this.manualEntries = manualEntries;
    }

    public int getManualEntries() {
        return this.manualEntries;
    }
}
