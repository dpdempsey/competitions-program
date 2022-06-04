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
        String fileName;
        String memberFile;
        String billFile;

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
                    //sc.noFileTesting();
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
        }
        
        
    }

    public void welcome(){
        String text = "----WELCOME TO SIMPLE COMPETITIONS APP----";
        System.out.println(text);
    }

/*     public void loadFile(){
        System.out.println("File name:");
        String fileName = kb.nextLine();
        this.fileName = fileName;

        System.out.println("Member file:");
        String memberFile = kb.nextLine();
        this.memberFile = memberFile;

        System.out.println("Bill file:");
        String billFile = kb.nextLine();
        this.billFile = billFile;
    }

    public void noFileTesting(){
        System.out.println("Member file:");
        String memberFile = kb.nextLine();
        this.memberFile = memberFile;

        System.out.println("Bill file:");
        String billFile = kb.nextLine();
        this.billFile = billFile;
    }

    public String getFileName(){
        return this.fileName;
    } */

}