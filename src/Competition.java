/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Competition {
    private String name; // competition name
    private int id; // competition identifier
    private ArrayList<Member> members = new ArrayList<Member>();

    public Competition(ArrayList<Member> members) {
        this.members = members;
    }

    public abstract void addEntries(Bill bill);

    public abstract void drawWinners(ArrayList<Member> members);

    public abstract String info();

    public abstract boolean hasEntries();

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

    public void report() {
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
}