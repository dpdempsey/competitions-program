/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

import java.util.ArrayList;
import java.util.Arrays;

public class LuckyNumbersCompetition extends Competition {
    private ArrayList<Entry> entries = new ArrayList<Entry>();
    private ArrayList<Entry> tempEnt = new ArrayList<Entry>();
    private ArrayList<Entry> winners = new ArrayList<Entry>();
    private boolean testingMode;
    private static int compCount = 1;
    private static int count = 1;

    public LuckyNumbersCompetition(String compName, boolean testingMode) {
        setName(compName);
        setID(compCount++);
        this.testingMode = testingMode;
    }

    public void addEntries(Bill bill) {
        int numOfEntries = bill.getEntries();
        String memberId = bill.getMemberId();
        int manualEntries = bill.getManualEntries();
        int[] luckyNumbers = null;
        NumbersEntry numEnt = new NumbersEntry();
        AutoNumbersEntry autoNumEnt = new AutoNumbersEntry();

        if (manualEntries > 0) {
            System.out.println("The following entries have been added:");
            for (int i = 0; i < manualEntries; i++) {
                numEnt.manualEntries();
                luckyNumbers = numEnt.getNumbers();
                Entry entry = new Entry(memberId, count++, luckyNumbers);
                entries.add(entry);
                tempEnt.add(entry);
                System.out.println(entry.printInfo());
            }

            for (Entry entry : tempEnt) {
                System.out.println(entry.printInfo());
            }

            int diff = numOfEntries - manualEntries;
            for (int i = 0; i < diff; i++) {
                luckyNumbers = autoNumEnt.createNumbers(entries.size());
                Entry entry = new Entry(memberId, count++, luckyNumbers);
                entries.add(entry);
                System.out.println(entry.printInfo() + " [Auto]");
            }
            tempEnt.clear();

        } else if (manualEntries == 0) {
            for (int i = 0; i < numOfEntries; i++) {
                luckyNumbers = autoNumEnt.createNumbers(entries.size());
                Entry entry = new Entry(memberId, count++, luckyNumbers);
                entries.add(entry);
                tempEnt.add(entry);
                System.out.println(entry.printInfo() + " [Auto]");
            }

            System.out.println("The following entries have been added:");
            for (Entry entry : tempEnt) {
                System.out.println(entry.printInfo() + " [Auto]");
            }

            tempEnt.clear();
        }
    }

    public void drawWinners() {
        System.out.println(info());
        AutoNumbersEntry autoNum = new AutoNumbersEntry();
        int[] winNum = autoNum.createNumbers(getID());

        System.out.println("Lucky Numbers: ");
        for (int i = 0; i < winNum.length; i++) {
            System.out.printf("%2d", winNum[i]);
        }

        System.out.println("Winning Entries:");
        for (Entry entry : entries) {
            int entryNum[] = entry.getNumbers();
            int match = checkEntries(winNum, entryNum);
            if (match > 2) {
                winners.add(entry);
            }
        }

    }

    public boolean hasEntries(){
        if(entries.size() > 0){
            return true;
        } else {
            return false;
        }
    }

    public String info() {
        return "Competition ID: " + getID() + ", Competition Name: " + getName() + ", Type: LuckyNumbersCompetition";
    }

    public boolean checkMax(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > 35) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDuplicate(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[i] == intArray[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printNums(Entry entry) {
        int[] nums = entry.getNumbers();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public int checkEntries(int[] winNum, int[] entryNum) {
        int count = 0;
        for (int i = 0; i < winNum.length; i++) {
            for (int j = 0; j < winNum.length; j++) {
                if (winNum[i] == entryNum[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
