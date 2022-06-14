/*
 * Student name: XXX
 * Student ID: YYY
 * LMS username: ZZZ
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Competition {
    private String name; // competition name
    private int id; // competition identifier
    static int counter = 1;

    public abstract void addEntries();

    public abstract void drawWinners();

    public abstract String info();

    public void report() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }
}