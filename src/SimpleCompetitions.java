/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.Serializable;

/**
 * SimpleCompetitions class that holds the main program
 * @author Declan Dempsey
 */
public class SimpleCompetitions implements Serializable {
    private boolean isCompActive;
    private boolean testingMode;
    private Competition competition;
    private ArrayList<Bill> bills = new ArrayList<Bill>();
    private ArrayList<Competition> archive = new ArrayList<Competition>();
    public static Scanner kb = new Scanner(System.in);

    // Creates a SimpleCompetitions object and sets isCompActive to be false
    public SimpleCompetitions() {
        isCompActive = false;
    }

    /**
     * Main program that uses the main SimpleCompetitions class
     * @author Declan Dempsey
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
        boolean key = false;
        // Loop to control whether to open competitions from file
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
                    key = true;
                    break;
                case "N":
                    loadFile = true;
                    mode = true;
                    break;
                default:
                    System.out.println("Unsupported option. Please try again!");
            }
        }
        // If you do not open from file, ask which mode the program should run in
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
        /* 
        * Create a new DataProvider object and read from the member file and bill file.
        * Additionally, read from a .dat file if that option was selected.
        */
        DataProvider dp = new DataProvider(memberFile, billFile);
        Competition competition = null;
        if(key){
            Folder folder = dp.readFromFile(fileName);
            competition = folder.getComp();
            sc.setArchive(folder.getArchive());
            sc.setCompActive(competition.getActive());
        }
        // Pull the list of bills and members from the DataProvider class
        ArrayList<Bill> bills = dp.readBillFile(billFile);
        sc.setBills(bills);
        ArrayList<Member> members = dp.readMemberFile(memberFile);

        // Main menu loop
        boolean menu = true;
        while (menu) {
            sc.mainMenu();
            String option = kb.nextLine();
            switch (option) {
                case "1":
                    /*
                     * If there is no active competition, create either a LuckyNumers or RandomPick Competition 
                     * and add it using the addNewCompetition method
                     */
                    if (!sc.isCompActive()) {
                        boolean comp = true;
                        while (comp) {
                            System.out.println("Type of competition (L: LuckyNumbers, R: RandomPick)?:");
                            option = kb.nextLine();
                            if (option.equals("L") || option.equals("R")) {
                                System.out.println("Competition name: ");
                                String compName = kb.nextLine();
                                competition = sc.addNewCompetition(option, compName, members);
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
                    /*
                     * If competition is active, first check and return the bill the user has inputted.
                     * Then accept any manual entries if selected. Then add those entries to the competition using the addEntries method
                     */
                    if (sc.isCompActive()) {
                        boolean checkBill = true;
                        while (checkBill) {
                            Bill bill = sc.checkBill();
                            if (competition instanceof LuckyNumbersCompetition) {
                                boolean temp = true;
                                System.out.println(" How many manual entries did the customer fill up?: ");
                                while (temp) {
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
                                                System.out.println("Unsupported option. Please try again!");
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
                                                System.out.println("Unsupported option. Please try again!");
                                            }
                                        }
                                    } else {
                                        System.out.println("The number must be in the range from 0 to " + bill.getEntries()
                                                + ". Please try again.");
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
                                        System.out.println("Unsupported option. Please try again!");
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("There is no active competition. Please create one!");
                    }
                    break;
                case "3":
                    /*
                     * First check whether there is an active competition and if there are entries to it.
                     * Then draw the winners, and close the competition, moving it to archive.
                     */
                    if (sc.isCompActive() && competition.hasEntries()) {
                        competition.drawWinners(members);
                        sc.addArchive(competition);
                        sc.setCompActive(false);
                        competition = null;
                    } else {
                        if (competition == null) {
                            System.out.println("There is no active competition. Please create one!");
                        } else {
                            System.out.println("The current competition has no entries yet!");
                        }
                    }
                    break;
                case "4":
                    // Call the report method to detail a report of the closed and active competitions
                    if (sc.isCompActive()) {
                        sc.report(competition);
                    } else if((sc.getArchive()).size() != 0){
                        sc.report(competition);
                    } else {
                        System.out.println("No competition has been created yet!");
                    }
                    break;
                case "5":
                    // Close the program, and save to file if selected.
                    System.out.println("Save competitions to file? (Y/N)?");
                    option = kb.nextLine();
                    option = option.toUpperCase();
                    if (option.equals("Y")) {
                        System.out.println("File name:");
                        fileName = kb.nextLine();
                        Folder folder = new Folder(competition, sc.getArchive(), fileName);
                        dp.writeToFile(folder);
                        System.out.println("Competitions have been saved to file.");
                        dp.updateBillFile(billFile, bills);
                        System.out.println("The bill file has also been automatically updated.");
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
    /**
     * Adds a new competition
     * @param choice LuckyNumers or RandomPick
     * @param compName the name of the competition
     * @param members the list of members
     * @return the competition that has been created
     */
    public Competition addNewCompetition(String choice, String compName, ArrayList<Member> members) {
        Entry entry = new Entry();
        entry.resetCounter();
        if (choice.equals("R")) {
            RandomPickCompetition ranComp = new RandomPickCompetition(compName, getIsTestingMode(), members);
            this.competition = ranComp;
            System.out.println("A new competition has been created!");
            System.out.println(ranComp.info());
            this.isCompActive = true;
            return ranComp;
        } else if (choice.equals("L")) {
            LuckyNumbersCompetition luckComp = new LuckyNumbersCompetition(compName, getIsTestingMode(), members);
            System.out.println("A new competition has been created!");
            System.out.println(luckComp.info());
            this.competition = luckComp;
            this.isCompActive = true;
            return luckComp;
        } else {
            return null;
        }
    }
    /**
     * Takes a bill and checks whether it is eligible to be used as an entry
     * @return returns the bill if checks are passed
     */

    public Bill checkBill() {
        boolean thing = true;
        while (thing) {
            boolean key = true;
            System.out.println("Bill ID: ");
            String billID = SimpleCompetitions.kb.nextLine();
            if (billID.matches("[0-9]+") && billID.length() == 6) {
                for (Bill bill : bills) {
                    if ((bill.getBillId()).equals(billID)) {
                        if ((bill.getMemberId()).equals("")) {
                            System.out.println("This bill has no member id. Please try again.");
                            key = false;
                        } else if (bill.getUsed() == true) {
                            System.out.println("This bill has already been used for a competition. Please try again.");
                            key = false;
                        } else {
                            System.out.print("This bill ($" + bill.getBillAmount() + ") is eligible for "
                                    + bill.getEntries() + " entries.");
                            bill.usedBill();
                            thing = false;
                            return bill;
                        }
                    }
                }
                if(key){
                    System.out.println("This bill does not exist. Please try again.");
                }
                
            } else {
                System.out.println("Invalid bill id! It must be a 6-digit number. Please try again.");
            }
        }
        return null;
    }

    /**
     * Generates a report of the active and closed competitions
     * @param competition the active competition
     */
    public void report(Competition competition) {
        int active = 0;
        if(competition != null){
            active++;
        }                    
        System.out.println("----SUMMARY REPORT----\n" 
        + "+Number of completed competitions: " + archive.size() +"\n" +
        "+Number of active competitions: " + active);
        
        if(archive.size() > 0){
            for(Competition comp : archive){
                System.out.println("\nCompetition ID: " + comp.getID() + ", name: " + comp.getName() + ", active: no"); 
                System.out.println("Number of entries: " + comp.getTotalEntries() + "\n" + 
                "Number of winning entries: " + comp.getWinningEntries() + "\n" + 
                "Total awarded prizes: " + comp.getTotalPrize());
            }
        }
        if(competition != null){
            System.out.print("\nCompetition ID: " + competition.getID() + ", name: " + competition.getName() + ", active: yes\n");
            System.out.println("Number of entries: " + competition.getEntrySize());
        }
    }

    /**
     * Checking whether there is an active competition
     * @return true if a competition exists, flase if not
     */
    public boolean compExists() {
        if (this.competition == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Sets a bill to be used once used
     * @param billID the bill in question
     */
    public void setUsed(String billID) {
        for (Bill bill : bills) {
            if ((bill.getBillId()).equals(billID)) {
                bill.usedBill();
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

    public boolean isCompActive() {
        return isCompActive;
    }

    public void setCompActive(boolean compActive){
        this.isCompActive = compActive;
    }

    public void setBills(ArrayList<Bill> bills) {
        this.bills = bills;
    }

    public boolean getIsTestingMode() {
        return this.testingMode;
    }

    public void setTestingMode(boolean testMode) {
        this.testingMode = testMode;
    }

    public ArrayList<Competition> getArchive(){
        return this.archive;
    }

    public void addArchive(Competition competition){
        archive.add(competition);
    }

    public void setArchive(ArrayList<Competition> archive){
        this.archive = archive;
    }
}