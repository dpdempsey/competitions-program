/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Bill class used to create bill objects
 * 
 * @author Declan Dempsey
 */
public class Bill implements Serializable {
    private ArrayList<Bill> bills = new ArrayList<Bill>();
    private String billId;
    private String memberID;
    private double billAmount;
    private int numOfEntries;
    private int manualEntries;
    private boolean used;

    /**
     * Create a bill object from a .csv file
     * 
     * @param billID     the billID
     * @param memberID   the memberID of the bill
     * @param billAmount the bill amount
     * @param used       whether the bill has been used in a previous comp
     */
    public Bill(String billID, String memberID, Double billAmount, boolean used) {
        this.memberID = memberID;
        this.billId = billID;
        this.billAmount = billAmount;
        this.used = used;
    }

    /**
     * Calculates the amount of entries a bill can have
     * 
     * @return the number of entries permitted
     */
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