/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

import java.util.ArrayList;

public class Member {
    private String memberID;
    private String memberName;

    public String getMemberID() {
        return this.memberID;
    }

    public String getMemberName() {
        return this.memberName;
    }

    private String memberAddress;
    private ArrayList<Member> members = new ArrayList<Member>();

    public Member(String memberID, String memberName, String memberAddres) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.memberAddress = memberAddres;
    }

    public void add(Member member) {
        members.add(member);
    }

}
