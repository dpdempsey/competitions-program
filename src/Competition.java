/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Competition abstract. Used in creating LuckyNumbersCompetitions and
 * RandomPickCompetitions
 * 
 * @author Declan Dempsey
 */
public abstract class Competition implements Serializable {
    private String name; // competition name
    private int id; // competition identifier
    private int totalPrize;
    private int totalEntries;
    private int winEnt;
    private boolean active;
    static int compCount = 1;
    private ArrayList<Member> members = new ArrayList<Member>();

    /**
     * Sets active to true and uses the list of members
     * 
     * @param members the list of members
     */
    public Competition(ArrayList<Member> members) {
        this.members = members;
        this.active = true;
    }

    /**
     * Add entries to a competition
     * 
     * @param bill the bill used to add entries
     */
    public abstract void addEntries(Bill bill);

    /**
     * Draw the winners for each competition
     * 
     * @param members the members list to find the winners name
     */
    public abstract void drawWinners(ArrayList<Member> members);

    /**
     * Short information about the competition
     * 
     * @return A short setence about the competition
     */
    public abstract String info();

    /**
     * To check whether a competition has entries
     * 
     * @return true if a competition has entries currently in it
     */
    public abstract boolean hasEntries();

    /**
     * Return the amount of current curents
     * 
     * @return the number of current entries
     */
    public abstract int getEntrySize();

    /**
     * Returns true if it is in testing mode
     * 
     * @return whether the competition is in testing mode or not
     */
    public abstract boolean getIsTestingMode();

    /**
     * Returns the member name based on the memberId
     * 
     * @param memberId the member's ID
     * @return the member's name
     */
    public String getMemberName(String memberId) {
        String memberName = null;
        for (Member member : members) {
            if (member.getMemberID().equals(memberId)) {
                memberName = member.getMemberName();
                break;
            }
        }
        return memberName;
    }

    /**
     * Sets information to be used in the report method
     * 
     * @param totalPrize   total prize one
     * @param totalEntries total entries in the comp
     * @param winEnt       the number of winning entries
     */
    public void setReportInfo(int totalPrize, int totalEntries, int winEnt) {
        this.totalPrize = totalPrize;
        this.totalEntries = totalEntries;
        this.winEnt = winEnt;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setTotalEntries(int totalEntries) {
        this.totalEntries = totalEntries;
    }

    public int getTotalEntries() {
        return this.totalEntries;
    }

    public void setTotalPrize(int totalPrize) {
        this.totalPrize = totalPrize;
    }

    public int getTotalPrize() {
        return this.totalPrize;
    }

    public void setWinningEntries(int winEnt) {
        this.winEnt = winEnt;
    }

    public int getWinningEntries() {
        return this.winEnt;
    }

    public boolean getActive() {
        return this.active;
    }

    public void setCount(int count) {
        compCount = count;
    }
}