/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

import java.util.ArrayList;
import java.util.Arrays;

public class LuckyNumbersCompetition extends Competition {
    private final int FIRST_PRIZE = 50000;
    private final int SECOND_PRIZE = 5000;
    private final int THIRD_PRIZE = 1000;
    private final int FOURTH_PRIZE = 500;
    private final int FIFTH_PRIZE = 100;
    private final int SIXTH_PRIZE = 50;
    private final int[] prizes = { FIRST_PRIZE, SECOND_PRIZE, THIRD_PRIZE, FOURTH_PRIZE, FIFTH_PRIZE, SIXTH_PRIZE };
    private ArrayList<Entry> entries = new ArrayList<Entry>();
    private ArrayList<Entry> tempEnt = new ArrayList<Entry>();
    private ArrayList<Winner> winners = new ArrayList<Winner>();
    private boolean testingMode;
    private static int compCount = 1;
    private static int count = 1;

    public LuckyNumbersCompetition(String compName, boolean testingMode, ArrayList<Member> members) {
        super(members);
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
            for (int i = 0; i < manualEntries; i++) {
                numEnt.manualEntries();
                luckyNumbers = numEnt.getNumbers();
                Entry entry = new Entry(memberId, luckyNumbers);
                entries.add(entry);
                tempEnt.add(entry);
            }

            System.out.println("The following entries have been added:");
            for (Entry entry : tempEnt) {
                entry.printInfo();
            }
            System.out.print("\n");

            int diff = numOfEntries - manualEntries;
            for (int i = 0; i < diff; i++) {
                luckyNumbers = autoNumEnt.createNumbers(entries.size());
                Entry entry = new Entry(memberId, count++, luckyNumbers);
                entries.add(entry);
                entry.printInfo();
                System.out.print(" [Auto]\n");
            }
            tempEnt.clear();

        } else if (manualEntries == 0) {
            for (int i = 0; i < numOfEntries; i++) {
                luckyNumbers = autoNumEnt.createNumbers(entries.size());
                Entry entry = new Entry(memberId, count++, luckyNumbers);
                entries.add(entry);
                tempEnt.add(entry);
            }

            System.out.println("The following entries have been added:");
            for (Entry entry : tempEnt) {
                entry.printInfo();
                System.out.print(" [Auto]\n");
            }

            tempEnt.clear();
        } else {
            // something
        }
    }

    public void drawWinners(ArrayList<Member> members) {
        System.out.println(info());
        AutoNumbersEntry autoNum = new AutoNumbersEntry();
        int[] winNum = autoNum.createNumbers(getID());

        System.out.println("Lucky Numbers: ");
        for (int i = 0; i < winNum.length; i++) {
            System.out.printf("%2d", winNum[i]);
        }

        System.out.println("Winning Entries:");
        ArrayList<String> winMemberId = new ArrayList<String>();
        for (Entry entry : entries) {
            int entryNum[] = entry.getNumbers();
            int match = checkEntries(winNum, entryNum);
            if (match > 2) {
                String memberId = entry.getMemberId();
                if (!winMemberId.contains(memberId)) {
                    String memberName = getMemberName(memberId);
                    int prize = prizes[entryNum.length - match];
                    Winner winner = new Winner(entry, memberName, prize);
                    winners.add(winner);
                    winMemberId.add(memberId);
                }
            }
        }
    }

    public boolean hasEntries() {
        if (entries.size() > 0) {
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
