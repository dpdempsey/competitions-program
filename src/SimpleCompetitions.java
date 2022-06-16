/*
 * Student name: XXX
 * Student ID: YYY
 * LMS username: ZZZ
 */

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class SimpleCompetitions {
    private ArrayList<Bill> bills = new ArrayList<Bill>();
    private ArrayList<Member> members = new ArrayList<Member>();
    private boolean isCompActive;
    Competition competition;
    LuckyNumbersCompetition luckComp;
    RandomPickCompetition ranComp;
    private static boolean testMode;
    public static Scanner kb = new Scanner(System.in);

    public SimpleCompetitions(){
        isCompActive = false;
    }

    public Competition addNewCompetition(String choice, String compName) {

        if (choice.equals("R")) {
            RandomPickCompetition ranComp = new RandomPickCompetition(compName);
            this.competition = ranComp;
            System.out.println("A new competition has been created!");
            System.out.println(ranComp.info());
            return ranComp;
        } else if (choice.equals("L")) {
            LuckyNumbersCompetition luckComp = new LuckyNumbersCompetition(compName);
            System.out.println("A new competition has been created!");
            System.out.println(luckComp.info());
            this.competition = luckComp;
            return luckComp;
        } else {
            return null;
        }
    }

    public void report() {
    }

    /**
     * Main program that uses the main SimpleCompetitions class
     * 
     * @param args main program arguments
     * @throws DataFormatException
     * @throws DataAccessException
     */
    public static void main(String[] args) throws DataAccessException, DataFormatException {

        // Create an object of the SimpleCompetitions class
        SimpleCompetitions sc = new SimpleCompetitions();
        String input = null;
        String fileName = null;
        String memberFile = null;
        String billFile = null;

        sc.welcome();
        boolean loadFile = false;
        boolean loop = false;

        while (!loop) {
            System.out.println("Load competitions from file? (Y/N)?");
            input = kb.nextLine();
            input = input.toUpperCase();
            switch (input) {
                case "Y":
                    System.out.println("File name:");
                    fileName = kb.nextLine();
                    System.out.println("Member file:");
                    memberFile = kb.nextLine();
                    System.out.println("Bill file:");
                    billFile = kb.nextLine();
                    loop = true;
                    break;
                case "N":
                    // something
                    loadFile = true;
                    loop = true;
                    break;
                default:
                    System.out.println("Unsupported option. Please try again!");
            }
        }

        while (loadFile) {
            System.out.println("Which mode would you like to run? (Type T for Testing, and N for Normal mode):");
            input = kb.nextLine();
            input = input.toUpperCase();

            switch (input) {
                case "T":
                    System.out.println("Member file:");
                    memberFile = kb.nextLine();
                    System.out.println("Bill file:");
                    billFile = kb.nextLine();
                    loadFile = false;
                    testMode = true;
                    // Testmode
                    break;
                case "N":
                    System.out.println("Member file:");
                    memberFile = kb.nextLine();
                    System.out.println("Bill file:");
                    billFile = kb.nextLine();
                    testMode = false;
                    loadFile = false;
                    // Normal mode
                    break;
                default:
                    System.out.println("Unsupported option. Please try again!");
            }
        }

        DataProvider dp = new DataProvider(memberFile, billFile);
        sc.bills = dp.getBills();
        sc.members = dp.getMembers();
        Competition competition = null;

        boolean menu = true;
        while (menu) {
            sc.mainMenu();
            String option = kb.nextLine();
            switch (option) {
                case "1":
                    if (!sc.isCompActive()) {
                        System.out.println("Type of competition (L: LuckyNumbers, R: RandomPick)?:");
                        option = kb.nextLine();
                        if (option.equals("L") || option.equals("R")) {
                            System.out.println("Competition name: ");
                            String compName = kb.nextLine();
                            sc.addNewCompetition(option, compName);
                            competition = sc.getComp();
                        } else {
                            System.out.println("Unsupported option. Please try again!");
                        }
                    } else {
                        System.out.println(
                                "There is an active competition. SimpleCompetitions does not support concurrent competitions!");
                    }
                    break;
                case "2":
                    if (!sc.isCompActive()) {
                        boolean thing = true;
                        while (thing) {
                            Bill bill = sc.checkBill();
                            if(competition instanceof LuckyNumbersCompetition){
                                boolean temp = true;
                                while (temp) {
                                    System.out.println("How many manual entries did the customer fill up?:");
                                    String manual = kb.nextLine();
                                    int entries = Integer.parseInt(manual);
                                    if (entries > 0 && (entries < bill.getEntries())) {
                                        int numOfEntries = bill.getEntries();
                                        String memberId = bill.getMemberId();
                                        competition.addEntries(numOfEntries, memberId);
                                    } else {
                                        System.out.println("The number must be in the range 0 to " + bill.getEntries()
                                                    + ". Please try again");
                                    }
                                }
                            } else {
                                int numOfEntries = bill.getEntries();
                                String memberId = bill.getMemberId();
                                competition.addEntries(numOfEntries, memberId);
                                boolean cond = true;
                                while(cond){
                                    System.out.println("Add more entries (Y/N)?");
                                    option = kb.nextLine();
                                    option = option.toUpperCase();
                                    if(option.equals("Y")){
                                        cond = false;
                                        continue;
                                    } else if(option.equals("N")){
                                        cond = false;
                                        thing = false;
                                    } else {
                                        continue;
                                    }
                                }
                                //System.out.println("This bill has already been used for a competition. Please try again.");
                            }
                        }
                    } else {
                        System.out.println("There is no active competition. Please create one!");
                    }
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    menu = false;
                    break;
                default:
                    System.out.println("A number is expected. Please try again.");
            }
        }
    }

    public void welcome() {
        String text = "----WELCOME TO SIMPLE COMPETITIONS APP----";
        System.out.println(text);
    }

    public void mainMenu() {
        String text = "Please select an option. Type 5 to exit.\n"
                + "1. Create a new competition\n"
                + "2. Add new entries\n"
                + "3. Draw winners\n"
                + "4. Get a summary report\n"
                + "5. Exit";
        System.out.println(text);
    }

    public Competition getComp() {
        return this.competition;
    }

    public boolean compExists() {
        if (this.competition == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isCompActive(){
        return isCompActive;
    }

    public boolean checkLuckComp() {
        if (this.competition instanceof LuckyNumbersCompetition) {
            return true;
        } else {
            return false;
        }
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

    public void setBills(ArrayList<Bill> bills){
        this.bills = bills;
    }

    public Bill checkBill(){
        boolean thing = true;
        while (thing) {
            System.out.println("Bill ID:");
            String billID = SimpleCompetitions.kb.nextLine();
            if (billID.matches("[0-9]+") && billID.length() == 6) {
                for (Bill bill : bills) {
                    if ((bill.getBillId()).equals(billID)) {
                        if ((bill.getMemberId()).equals(" ")) {
                            System.out.println("This bill has no member id. Please try again.");
                        } else if(bill.getUsed() == true){
                            System.out.println("This bill has already been used for a competition. Please try again.");
                        } else {
                            System.out.print("This bill ($" + bill.getBillAmount() + ") is eligible for " + bill.getEntries() + " entries.");
                            bill.usedBill();
                            thing = false;
                            return bill;
                        }
                    } else {
                        //System.out.println("This bill does not exist. Please try again");
                    }
                }
            } else {
                System.out.println("Invalid bill id! It must be a 6-digit number. Please try again.");
            }
        }
        return null;
    }

    public int[] manualEntries(){
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

    public void setUsed(String billID){
        for (Bill bill : bills) {
            if ((bill.getBillId()).equals(billID)) {
                bill.usedBill();
            }
        }
    }

/*     public Competition addNewCompetition(String choice, String compName) {

        if (choice.equals("R")) {
            RandomPickCompetition ranComp = new RandomPickCompetition(compName);
            this.competition = ranComp;
            System.out.println("A new competition has been created!");
            System.out.println(ranComp.info());
            return ranComp;
        } else if (choice.equals("L")) {
            LuckyNumbersCompetition luckComp = new LuckyNumbersCompetition(compName);
            System.out.println("A new competition has been created!");
            System.out.println(luckComp.info());
            this.competition = luckComp;
            return luckComp;
        } else {
            return null;
        }
    } */
}