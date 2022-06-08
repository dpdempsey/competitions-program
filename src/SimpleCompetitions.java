/*
 * Student name: XXX
 * Student ID: YYY
 * LMS username: ZZZ
 */

import java.util.Scanner;

public class SimpleCompetitions {
    private static boolean testMode;

    public static Scanner kb = new Scanner(System.in);

    //public Competition addNewCompetition() {
        
    //}

    public void report() {
    	
    }

    /**
    * Main program that uses the main SimpleCompetitions class
    * @param args main program arguments
    */
    public static void main(String[] args) {
    	
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
                    //sc.loadFile();
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
            input.toUpperCase();

            switch(input) {
                case "T":
                    System.out.println("Member file:");
                    memberFile = kb.nextLine();
                    System.out.println("Bill file:");
                    billFile = kb.nextLine();
                    loadFile = false;
                    testMode = true;
                    //something
                    break;
                case "N":
                    System.out.println("Member file:");
                    memberFile = kb.nextLine();
                    System.out.println("Bill file:");
                    billFile = kb.nextLine();
                    testMode = false;
                    loadFile = false;
                    //something
                    break;
                default:
                    //something
            }
            DataProvider dp = new DataProvider(memberFile, billFile);
        }

        boolean thing = true;

        while(thing){
            sc.mainMenu();
            String option = kb.nextLine();
    
            switch(option){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
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