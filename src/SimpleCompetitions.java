/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
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
    private boolean testingMode;
    public static Scanner kb = new Scanner(System.in);

    public SimpleCompetitions() {
        isCompActive = false;
    }

    public Competition addNewCompetition(String choice, String compName) {

        if (choice.equals("R")) {
            RandomPickCompetition ranComp = new RandomPickCompetition(compName, getIsTestingMode());
            this.competition = ranComp;
            System.out.println("A new competition has been created!");
            System.out.println(ranComp.info());
            this.isCompActive = true;
            return ranComp;
        } else if (choice.equals("L")) {
            LuckyNumbersCompetition luckComp = new LuckyNumbersCompetition(compName, getIsTestingMode());
            System.out.println("A new competition has been created!");
            System.out.println(luckComp.info());
            this.competition = luckComp;
            this.isCompActive = true;
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
        String input, fileName, memberFile, billFile;
        input = fileName = memberFile = billFile = null;

        sc.welcome();
        boolean loadFile = false;
        boolean mode = false;
        while (!loadFile) {
            System.out.println("Load competitions from file? (Y/N)?");
            input = kb.nextLine();
            input = input.toUpperCase();
            switch (input) {
                case "Y":
                    System.out.println("File name: ");
                    fileName = kb.nextLine();
                    System.out.println("Member file: ");
                    memberFile = kb.nextLine();
                    System.out.println("Bill file: ");
                    billFile = kb.nextLine();
                    loadFile = true;
                    break;
                case "N":
                    loadFile = true;
                    mode = true;
                    break;
                default:
                    System.out.println("Unsupported option. Please try again!");
            }
        }
        while (mode) {
            System.out.println("Which mode would you like to run? (Type T for Testing, and N for Normal mode):");
            input = kb.nextLine();
            input = input.toUpperCase();
            switch (input) {
                case "T":
                    System.out.println("Member file: ");
                    memberFile = kb.nextLine();
                    System.out.println("Bill file: ");
                    billFile = kb.nextLine();
                    mode = false;
                    sc.setTestingMode(true);
                    break;
                case "N":
                    System.out.println("Member file: ");
                    memberFile = kb.nextLine();
                    System.out.println("Bill file: ");
                    billFile = kb.nextLine();
                    mode = false;
                    sc.setTestingMode(false);
                    break;
                default:
                    System.out.println("Invalid mode! Please choose again.");
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
                        boolean comp = true;
                        while (comp) {
                            System.out.println("Type of competition (L: LuckyNumbers, R: RandomPick)?:");
                            option = kb.nextLine();
                            if (option.equals("L") || option.equals("R")) {
                                System.out.println("Competition name: ");
                                String compName = kb.nextLine();
                                sc.addNewCompetition(option, compName);
                                competition = sc.getComp();
                                comp = false;
                            } else {
                                System.out.println("Invalid competition type! Please choose again.");
                            }
                        }
                    } else {
                        System.out.println(
                                "There is an active competition. SimpleCompetitions does not support concurrent competitions!");
                    }
                    break;
                case "2":
                    if (sc.isCompActive()) {
                        boolean checkBill = true;
                        while (checkBill) {
                            Bill bill = sc.checkBill();
                            if (competition instanceof LuckyNumbersCompetition) {
                                boolean temp = true;
                                while (temp) {
                                    System.out.println(" How many manual entries did the customer fill up?:");
                                    String manual = kb.nextLine();
                                    int entries = Integer.parseInt(manual);
                                    if (entries > 0 && (entries < bill.getEntries())) {
                                        bill.setManualEntries(entries);
                                        competition.addEntries(bill);
                                        boolean cond = true;
                                        while (cond) {
                                            System.out.println("Add more entries (Y/N)?");
                                            option = kb.nextLine();
                                            option = option.toUpperCase();
                                            if (option.equals("Y")) {
                                                cond = false;
                                                temp = false;
                                            } else if (option.equals("N")) {
                                                cond = false;
                                                temp = false;
                                                checkBill = false;
                                            } else {
                                                continue;
                                            }
                                        }
                                    } else if (entries == 0) {
                                        bill.setManualEntries(entries);
                                        competition.addEntries(bill);
                                        boolean cond = true;
                                        while (cond) {
                                            System.out.println("Add more entries (Y/N)?");
                                            option = kb.nextLine();
                                            option = option.toUpperCase();
                                            if (option.equals("Y")) {
                                                cond = false;
                                                temp = false;
                                            } else if (option.equals("N")) {
                                                cond = false;
                                                temp = false;
                                                checkBill = false;
                                            } else {
                                                continue;
                                            }
                                        }
                                    } else {
                                        System.out.println("The number must be in the range 0 to " + bill.getEntries()
                                                + ". Please try again");
                                    }
                                }
                            } else {
                                competition.addEntries(bill);
                                boolean cond = true;
                                while (cond) {
                                    System.out.println("Add more entries (Y/N)?");
                                    option = kb.nextLine();
                                    option = option.toUpperCase();
                                    if (option.equals("Y")) {
                                        cond = false;
                                        continue;
                                    } else if (option.equals("N")) {
                                        cond = false;
                                        checkBill = false;
                                    } else {
                                        continue;
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("There is no active competition. Please create one!");
                    }
                    break;
                case "3":
                    if (sc.isCompActive() && sc.getComp().hasEntries()) {
                        System.out.println((sc.getComp()).info());
                        if (competition instanceof LuckyNumbersCompetition) {
                            (sc.getComp()).drawWinners();
                        }
                    } else {
                        if (!sc.getComp().hasEntries()) {
                            System.out.println("The current competition has no entries yet!");
                        } else {
                            System.out.println("There is no active competition. Please create one!");
                        }
                    }

                    break;
                case "4":
                    // Get a summary report
                    if (sc.isCompActive()) {
                    } else {
                        System.out.println("No competition has been created yet!");
                    }
                    break;
                case "5":
                    System.out.println("Save competitions to file? (Y/N)?");
                    option = kb.nextLine();
                    option = option.toUpperCase();
                    if (option.equals("Y")) {
                        // Save to file
                        menu = false;
                    } else if (option.equals("N"))
                        menu = false;
                    System.out.println("Goodbye!");
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

    public boolean isCompActive() {
        return isCompActive;
    }

    public boolean checkLuckComp() {
        if (this.competition instanceof LuckyNumbersCompetition) {
            return true;
        } else {
            return false;
        }
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

    public void setBills(ArrayList<Bill> bills) {
        this.bills = bills;
    }

    public Bill checkBill() {
        boolean thing = true;
        while (thing) {
            System.out.println("Bill ID:");
            String billID = SimpleCompetitions.kb.nextLine();
            if (billID.matches("[0-9]+") && billID.length() == 6) {
                for (Bill bill : bills) {
                    if ((bill.getBillId()).equals(billID)) {
                        if ((bill.getMemberId()).equals(" ")) {
                            System.out.println("This bill has no member id. Please try again.");
                        } else if (bill.getUsed() == true) {
                            System.out.println("This bill has already been used for a competition. Please try again.");
                        } else {
                            System.out.print("This bill ($" + bill.getBillAmount() + ") is eligible for "
                                    + bill.getEntries() + " entries.");
                            bill.usedBill();
                            thing = false;
                            return bill;
                        }
                    } else {
                        // System.out.println("This bill does not exist. Please try again");
                    }
                }
            } else {
                System.out.println("Invalid bill id! It must be a 6-digit number. Please try again.");
            }
        }
        return null;
    }

    public void setUsed(String billID) {
        for (Bill bill : bills) {
            if ((bill.getBillId()).equals(billID)) {
                bill.usedBill();
            }
        }
    }

    public boolean getIsTestingMode() {
        return this.testingMode;
    }

    public void setTestingMode(boolean testMode) {
        this.testingMode = testMode;
    }
}