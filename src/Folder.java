/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Folder class used to wrap the active and archived competitions, so it can be
 * written and read to/from file
 * 
 * @author Declan Dempsey
 */
public class Folder implements Serializable {
    private Competition competition;
    private ArrayList<Competition> archive;
    private String fileName;
    private boolean testingMode;

    /**
     * Default constructor
     */
    public Folder() {
    }

    /**
     * Create a folder object with given parameters
     * 
     * @param competition the active competition
     * @param archive     the list of archived competitions
     * @param fileName    the filename to write to
     * @param testingMode whether it is testing mode or not
     */
    public Folder(Competition competition, ArrayList<Competition> archive, String fileName, boolean testingMode) {
        this.competition = competition;
        this.archive = archive;
        this.fileName = fileName;
        this.testingMode = testingMode;
    }

    public String getFileName() {
        return this.fileName;
    }

    public Competition getComp() {
        return this.competition;
    }

    public ArrayList<Competition> getArchive() {
        return this.archive;
    }

    public boolean getTestingMode() {
        return this.testingMode;
    }
}
