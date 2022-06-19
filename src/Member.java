/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

import java.io.Serializable;
import java.util.ArrayList;

public class Member implements Serializable{
    private String memberID;
    private String memberName;
    private String memberAddress;

    public String getMemberID() {
        return this.memberID;
    }

    public String getMemberName() {
        return this.memberName;
    }

    public Member(String memberID, String memberName, String memberAddres) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.memberAddress = memberAddres;
    }

}
