/*
 * Student name: XXX
 * Student ID: YYY
 * LMS username: ZZZ
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileInputStream;

public class DataProvider {
    private String fileName;
    private String memberFile;
    private String billFile;
    private ArrayList<Entry> entries = new ArrayList<Entry>();

    /**
     * 
     * @param memberFile A path to the member file (e.g., members.csv)
     * @param billFile   A path to the bill file (e.g., bills.csv)
     * @param fileName   A path to an already saved file
     * @throws DataAccessException If a file cannot be opened/read
     * @throws DataFormatException If the format of the the content is incorrect
     */
    public DataProvider(String memberFile, String billFile) { // throws DataAccessException, DataFormatException {
        this.memberFile = memberFile;
        this.billFile = billFile;
    }

    public DataProvider(String fileName) {

    }

    public void readBillFile(String billFile) {
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new FileInputStream(memberFile));
        } catch (Exception e) {
            // TODO fix exception
        }
    }

    public void readMemberFile(String memberfile) {

    }
}