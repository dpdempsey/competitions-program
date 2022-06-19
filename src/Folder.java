/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

import java.io.Serializable;
import java.util.ArrayList;

public class Folder implements Serializable{
    private Competition competition;
    private ArrayList<Competition> archive;
    private String fileName;

    public Folder(){
    }

    public Folder(Competition competition, ArrayList<Competition> archive, String fileName){
        this.competition = competition;
        this.archive = archive;
        this.fileName = fileName;
    }
    public String getFileName(){
        return this.fileName;
    }

    public Competition getComp(){
        return this.competition;
    }

    public ArrayList<Competition> getArchive(){
        return this.archive;
    }
}
