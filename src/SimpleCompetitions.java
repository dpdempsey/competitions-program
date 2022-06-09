/*
 * Student name: XXX
 * Student ID: YYY
 * LMS username: ZZZ
 */

import java.util.Scanner;

public class SimpleCompetitions {

    private static boolean testMode;
    public static Scanner kb = new Scanner(System.in);

    public Competition addNewCompetition(String choice) {
        if(choice.equals("L")){
            RandomPickCompetition ranComp = new RandomPickCompetition();
        }
        if(choice.equals("R")){
            LuckyNumbersCompetition luckComp = new LuckyNumbersCompetition();
        }
        return null;
    }

    public void report() {
    	
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
                System.out.println("Type of competition (L: LuckyNumbers, R: RandomPick)?:");
                String comp = kb.nextLine();
                if(comp.equals("L") || comp.equals("R")){
                    sc.addNewCompetition(comp);
                } else {
                    System.out.println("Unsupported option. Please try again!");
                }
                System.out.println("Competition name: ");
                String name = kb.nextLine();
                
                    break;
                case "2":
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