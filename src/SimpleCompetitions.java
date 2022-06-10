/*
 * Student name: XXX
 * Student ID: YYY
 * LMS username: ZZZ
 */

import java.util.Random;
import java.util.Scanner;

public class SimpleCompetitions {

    Competition competition;
    private static boolean testMode;
    public static Scanner kb = new Scanner(System.in);

    public Competition addNewCompetition(String choice, String compName) {
        
        if(choice.equals("R")){
            RandomPickCompetition ranComp = new RandomPickCompetition(compName);
            this.competition = ranComp;
            System.out.println("A new competition has been created!");
            System.out.println(ranComp.info());
            return ranComp;
        } else if(choice.equals("L")){
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

    public boolean compExists(){
        if(this.competition == null){
            return false;
        } else {
            return true;
        }
    }

    /**
    * Main program that uses the main SimpleCompetitions class
    * @param args main program arguments
     * @throws DataFormatException
     * @throws DataAccessException
    */
    public static void main(String[] args) throws DataAccessException, DataFormatException {
    	
    	//Create an object of the SimpleCompetitions class
        SimpleCompetitions sc = new SimpleCompetitions();
        String input = null;
        String fileName = null;
        String memberFile = null;
        String billFile = null;

        sc.welcome();
        boolean loadFile = false;
        boolean loop = false;

        while(!loop){
            System.out.println("Load competitions from file? (Y/N)?");
            input = kb.nextLine();
            input = input.toUpperCase();
            switch(input) {
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
                    //something
                    loadFile = true;
                    loop = true;
                    break;
                default:
                    System.out.println("Unsupported option. Please try again!");
            }
        }

        while(loadFile){
            System.out.println("Which mode would you like to run? (Type T for Testing, and N for Normal mode):");
            input = kb.nextLine();
            input = input.toUpperCase();

            switch(input) {
                case "T":
                    System.out.println("Member file:");
                    memberFile = kb.nextLine();
                    System.out.println("Bill file:");
                    billFile = kb.nextLine();
                    loadFile = false;
                    testMode = true;
                    //Testmode
                    break;
                case "N":
                    System.out.println("Member file:");
                    memberFile = kb.nextLine();
                    System.out.println("Bill file:");
                    billFile = kb.nextLine();
                    testMode = false;
                    loadFile = false;
                    //Normal mode
                    break;
                default:
                    System.out.println("Unsupported option. Please try again!");
            }
            DataProvider dp = new DataProvider(memberFile, billFile);
        }

        boolean menu = true;

        while(menu){
            sc.mainMenu();
            String option = kb.nextLine();
    
            switch(option){
                case "1":
                if(!sc.compExists()){
                    System.out.println("Type of competition (L: LuckyNumbers, R: RandomPick)?:");
                    String comp = kb.nextLine();
                    if(comp.equals("L") || comp.equals("R")){
                        System.out.println("Competition name: ");
                        String compName = kb.nextLine();
                        sc.addNewCompetition(comp, compName);
                    } else {
                        System.out.println("Unsupported option. Please try again!");
                    }
                } else {
                    System.out.println("There is an active competition. SimpleCompetitions does not support concurrent competitions!");
                }
                    break;
                case "2":
                    if(sc.compExists()){
                        System.out.println("Bill ID:");
                        String billID = kb.nextLine();
                        if(billID.matches("[0-9]+") && billID.length() == 6){
                            //
                        } else {
                            System.out.println("Invalid bill id! It must be a 6-digit number. Please try again.");
                        }
                    } else {
                        System.out.println("There is an active competition. Please create one!");
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

    public void welcome(){
        String text = "----WELCOME TO SIMPLE COMPETITIONS APP----";
        System.out.println(text);
    }

    public void mainMenu(){
        String text = "Please select an option. Type 5 to exit.\n"
         + "1. Create a new competition\n"
        + "2. Add new entries\n"
        + "3. Draw winners\n"
        + "4. Get a summary report\n"
        + "5. Exit";
        System.out.println(text);
    }

}