/*
 * Student name: XXX
 * Student ID: YYY
 * LMS username: ZZZ
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DataProvider {
    private String fileName;
    private String memberFile;
    private String billFile;
    private ArrayList<Entry> entries = new ArrayList<Entry>();
    private ArrayList<Bill> bills = new ArrayList<Bill>();
    private ArrayList<Member> members = new ArrayList<Member>();

    /**
     * 
     * @param memberFile A path to the member file (e.g., members.csv)
     * @param billFile   A path to the bill file (e.g., bills.csv)
     * @param fileName   A path to an already saved file
     * @throws DataAccessException If a file cannot be opened/read
     * @throws DataFormatException If the format of the the content is incorrect
     */
    public DataProvider(String memberFile, String billFile) throws DataAccessException, DataFormatException {
        this.memberFile = memberFile;
        this.billFile = billFile;

        readBillFile(billFile);
        readMemberFile(memberFile);
    }

    public DataProvider(String fileName, String memberFile, String billFile) {

    }

    public void readBillFile(String billFile) throws DataAccessException, DataFormatException {
        Scanner inputStream = null;
        String billID = null;
        String memberID = null;
        double billAmount = 0;
        boolean used = false;

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
                this.bills.add(bill);
            }
        } catch (NumberFormatException e) {
            throw new DataFormatException("Bill file has a format error!");
        }
        inputStream.close();
    }

    public void readMemberFile(String memberfile) throws DataAccessException, DataFormatException {
        Scanner inputStream = null;
        String memID = null;
        String memName = null;
        String memAddress = null;

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
                this.members.add(member);
            }
        } catch (NumberFormatException e) {
            throw new DataFormatException("Member file has a format error!");
        }
        inputStream.close();
    }

    public int checkBill(String billID) {
        boolean thing = true;
        while (thing) {
            if (billID.matches("[0-9]+") && billID.length() == 6) {
                for (Bill b : bills) {
                    if ((b.getBillId()).equals(billID)) {
                        if ((b.getMemberId()).equals(" ")) {
                            System.out.println("This bill has no member id. Please try again.");
                        } else {
                            System.out.print("This bill ($" + b.getBillAmount() + ") is eligible for " + b.getEntries() + " entries.");
                            thing = false;
                            return b.getEntries();
                        }
                    }
                }
            } else {
                System.out.println("Invalid bill id! It must be a 6-digit number. Please try again.");
            }
        }
        return 0;
    }
}