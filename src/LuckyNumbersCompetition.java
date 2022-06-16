/*
 * Student name: XXX
 * Student ID: YYY
 * LMS username: ZZZ
 */

import java.util.ArrayList;
import java.util.Arrays;

public class LuckyNumbersCompetition extends Competition {
    private ArrayList<Entry> entries = new ArrayList<Entry>();

    public LuckyNumbersCompetition(String compName) {
        setName(compName);
        setID(counter++);
    }

    public void addEntries(int billEntries, String memberId) {
        NumbersEntry numEnt = new NumbersEntry();
        numEnt.manualEntries();
        int[] luckyNumbers = numEnt.getNumbers();

        for(int i=0; i<billEntries; i++){
            Entry entry = new Entry(memberId, counter++, luckyNumbers);
            entries.add(entry);
        }
        System.out.println("The following entries have been added:");
        for(Entry e : entries){
            System.out.print("Entry ID: " + e.getEntryId() + "    Numbers: ");
            //for(int i=0; i<entries.length)
        }


        AutoNumbersEntry autoNumEnt = new AutoNumbersEntry();
        autoNumEnt.createNumbers(1);
    }

    public void drawWinners() {
    }

    public String info() {
        return "Competition ID: " + getID() + ", Competition Name: " + getName() + ", Type: LuckyNumbersCompetition";
    }

    public boolean checkMax(int[] intArray){
        for(int i=0; i<intArray.length; i++){
            if(intArray[i] > 35){
                return false;
            }
        }
        return true;
    }

    public boolean checkDuplicate(int[] intArray){
        for(int i=0; i<intArray.length; i++){
            for(int j=i+1; j<intArray.length; j++){
                if(intArray[i] == intArray[j]){
                    return false;
                }
            }
        }
        return true;
    }

    public void entryList(int[] intArray){
        System.out.println("The following entries have been added:");
    }

    public void printNums(Entry e){
        int[] nums = e.getNumbers();
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]);
        }
    }


    /*                     System.out.println("Add more entries (Y/N)?");
                    line = SimpleCompetitions.kb.nextLine();
                    if(line.equals("Y")){
                        //continue;
                    } else {
                        temp = false;
                    } */

                    /*      manualEntries();
        NumbersEntry numEnt = new NumbersEntry();
        AutoNumbersEntry autoNumEnt = new AutoNumbersEntry();
        autoNumEnt.createNumbers(1); 
        
            public int[] manualEntries() {
        boolean temp2 = true;
        while(temp2){
            System.out.println("Please enter 7 different numbers (from the range 1 to 35) separated by whitespace.");
            String line = SimpleCompetitions.kb.nextLine();
            String parts[] = line.split(" ");
            int[] intArray = new int[parts.length];
            for(int i=0; i<parts.length; i++){
                intArray[i] = Integer.parseInt(parts[i]);
            }
            if(intArray.length < 7){
                System.out.println("Invalid input! Fewer than 7 numbers are provided. Please try again!");
            } else if(intArray.length > 7){
                System.out.println("Invalid input! More than 7 numbers are provided. Please try again!");
            } else if(!this.checkMax(intArray)){
                System.out.println("Invalid input! All numbers must be in the range from 1 to 35!");
            } else if(!this.checkDuplicate(intArray)){
                System.out.println("Invalid input! All numbers must be different!");
            } else {
                Arrays.sort(intArray);
                return intArray;
            }
        }
        return null;
    }
        
        */

                    
}
