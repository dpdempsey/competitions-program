/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class used to read Bill and Member files, as well as overwrite bill file and
 * read in .dat saved files
 * 
 * @author Declan Dempsey
 */
public class DataProvider {
    private String fileName;
    private String memberFile;
    private String billFile;

    /**
     * Used when there is no .dat file input
     * 
     * @param memberFile A path to the member file (e.g., members.csv)
     * @param billFile   A path to the bill file (e.g., bills.csv)
     * @throws DataAccessException If a file cannot be opened/read
     * @throws DataFormatException If the format of the the content is incorrect
     */
    public DataProvider(String memberFile, String billFile) throws DataAccessException, DataFormatException {
        this.memberFile = memberFile;
        this.billFile = billFile;
        readBillFile(billFile);
        readMemberFile(memberFile);
    }

    /**
     * Reads and returns a list of bills from the .csv file
     * 
     * @param billFile name of the .csv file
     * @return the list of bills
     * @throws DataAccessException If a file cannot be opened/read
     * @throws DataFormatException If the format of the the content is incorrect
     */
    public ArrayList<Bill> readBillFile(String billFile) throws DataAccessException, DataFormatException {
        Scanner inputStream = null;
        String billID = null;
        String memberID = null;
        double billAmount = 0;
        boolean used = false;
        ArrayList<Bill> bills = new ArrayList<Bill>();

        try {
            inputStream = new Scanner(new FileInputStream(billFile));
        } catch (FileNotFoundException e) {
            throw new DataAccessException("Bill file not found!");
        }
        try {
            while (inputStream.hasNextLine()) {
                String line = inputStream.nextLine();
                String[] info = line.split(",");

                for (int i = 0; i < info.length; i++) {
                    if (i == 0) {
                        billID = info[i];
                    }
                    if (i == 1) {
                        memberID = info[i];
                    }
                    if (i == 2) {
                        billAmount = Double.parseDouble(info[i]);
                    }
                    if (i == 3) {
                        used = Boolean.parseBoolean(info[i]);
                    }
                }
                Bill bill = new Bill(billID, memberID, billAmount, used);
                bills.add(bill);
            }
        } catch (NumberFormatException e) {
            throw new DataFormatException("Bill file has a format error!");
        }
        inputStream.close();
        return bills;
    }

    /**
     * Reads and returns a list of bills from the members.csv file
     * 
     * @param memberfile the name of the .csv file
     * @return the list of members
     * @throws DataAccessException If a file cannot be opened/read
     * @throws DataFormatException If the format of the the content is incorrect
     */
    public ArrayList<Member> readMemberFile(String memberfile) throws DataAccessException, DataFormatException {
        Scanner inputStream = null;
        String memID = null;
        String memName = null;
        String memAddress = null;
        ArrayList<Member> members = new ArrayList<Member>();

        try {
            inputStream = new Scanner(new FileInputStream(memberFile));
        } catch (FileNotFoundException e) {
            throw new DataAccessException("Member file not found!");
        }
        try {
            while (inputStream.hasNextLine()) {
                String line = inputStream.nextLine();
                String[] info = line.split(",");
                for (int i = 0; i < info.length; i++) {
                    if (i == 0) {
                        memID = info[i];
                    }
                    if (i == 1) {
                        memName = info[i];
                    }
                    if (i == 2) {
                        memAddress = info[i];
                    }
                }
                Member member = new Member(memID, memName, memAddress);
                members.add(member);
            }
        } catch (NumberFormatException e) {
            throw new DataFormatException("Member file has a format error!");
        }
        inputStream.close();
        return members;
    }

    /**
     * Returns a Folder object from a .dat file
     * 
     * @param fileName the filename to read from
     * @return a Folder object which contains competition information
     * @throws DataAccessException if a file cannot be opened or read
     * @throws DataFormatException if the file being read from isn't formatted correctly
     */
    public Folder readFromFile(String fileName) throws DataAccessException, DataFormatException {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            Folder folder = (Folder) in.readObject();
            in.close();
            return folder;
        } catch (FileNotFoundException e) {
            throw new DataAccessException("The saved file could not be found!");
        } catch (ClassNotFoundException e) {
            throw new DataAccessException("The saved file has a format error!");
        } catch (IOException e) {
            throw new DataFormatException("The saved file has a format error!");
        }
    }

    /**
     * Writes information to a file to be opened later
     * 
     * @param folder Folder object to be written
     * @throws DataFormatException
     */
    public void writeToFile(Folder folder) throws DataFormatException {
        String fileName = folder.getFileName();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(folder);
            out.close();
        } catch (IOException e) {
            throw new DataFormatException("Error in saving the file!");
        }
    }

    /**
     * Used to overwrite the bill file when closing the program
     * 
     * @param billFile the name of the bill file
     * @param bills    the list of updated bills
     * @throws DataAccessException if the file is not found
     */
    public void updateBillFile(String billFile, ArrayList<Bill> bills) throws DataAccessException {
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileOutputStream(billFile));
        } catch (FileNotFoundException e) {
            throw new DataAccessException("Bill File could not be found!");
        }

        for (Bill bill : bills) {
            String billID = bill.getBillId();
            String memberID = bill.getMemberId();
            double billAmount = bill.getBillAmount();
            boolean used = bill.getUsed();
            outputStream.println(billID + "," + memberID + "," + billAmount + "," + used);
        }
        outputStream.close();
    }
}