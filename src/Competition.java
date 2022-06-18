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
    private int totalPrize;
    private int totalEntries;
    private int winEnt;
    static int compCount = 1;
    private ArrayList<Member> members = new ArrayList<Member>();
    private ArrayList<Competition> archive = new ArrayList<Competition>();

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

/*     public void report(SimpleCompetitions sc) {
        this.archive = sc.getArchive();
        int active = 0;
        if(sc.getComp() != null){
            active++;
        }                    
        System.out.println("----SUMMARY REPORT----\n" 
        + "+Number of completed competitions: " + archive.size() +"\n" +
        "+Number of active competitions: " + active);
        
        if(archive.size() > 0){
            for(Competition comp : archive){
                System.out.println("Competition ID: " + comp.getID() + ", name: " + comp.getName() + ", active: no"); 
                System.out.println("Number of entries: " + totalEntries + "\n" + 
                "Number of winning entries: " + winEnt + "\n" + 
                "Total awarded prizes: " + totalPrize + "\n");
                
            }
        }
        System.out.println("Competition ID: " + getID() + ", name: " + getName() + ", active: yes\n");
    } */

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

    public void addArchive(Competition competition){
        archive.add(competition);
    }

    public int getSize(){
        return archive.size();
    }

    public void setReportInfo(int totalPrize, int totalEntries, int winEnt){
        this.totalPrize = totalPrize;
        this.totalEntries = totalEntries;
        this.winEnt = winEnt;
    }

    public void setTotalEntries(int totalEntries){
        this.totalEntries = totalEntries;
    }

    public int getTotalEntries(){
        return this.totalEntries;
    }

    public void setTotalPrize(int totalPrize){
        this.totalPrize = totalPrize;
    }

    public int getTotalPrize(){
        return this.totalPrize;
    }

    public void setWinningEntries(int winEnt){
        this.winEnt = winEnt;
    }

    public int getWinningEntries(){
        return this.winEnt;
    }
}