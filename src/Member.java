/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

import java.io.Serializable;

/**
 * Member class used in creating member objects
 */
public class Member implements Serializable {
    private String memberID;
    private String memberName;
    private String memberAddress;

    /**
     * Create a member with given parameters
     * 
     * @param memberID     the memberID
     * @param memberName   the member's name
     * @param memberAddres the member's email address
     */
    public Member(String memberID, String memberName, String memberAddres) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.memberAddress = memberAddres;
    }

    public String getMemberID() {
        return this.memberID;
    }

    public String getMemberName() {
        return this.memberName;
    }

}
