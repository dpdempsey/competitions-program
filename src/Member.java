/*
 * Student name: XXX
 * Student ID: YYY
 * LMS username: ZZZ
 */

import java.util.ArrayList;

public class Member {
    private String memberID;
    private String memberName;
    private String memberAddress;
    private ArrayList<Member> members = new ArrayList<Member>();

    public Member(String memberID, String memberName, String memberAddres){
        this.memberID = memberID;
        this.memberName = memberName;
        this.memberAddress = memberAddres;
    }

    public void add(Member member){
        members.add(member);
    }
}
