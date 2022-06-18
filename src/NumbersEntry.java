/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

import java.util.Arrays;

public class NumbersEntry extends Entry {
    private int[] numbers;

    public NumbersEntry() {
        super();
    }

    public void manualEntries() {
        System.out.println("Please enter 7 different numbers (from the range 1 to 35) separated by whitespace.");
        String line = SimpleCompetitions.kb.nextLine();
        String parts[] = line.split(" ");
        int[] intArray = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            intArray[i] = Integer.parseInt(parts[i]);
        }
        if (intArray.length < 7) {
            System.out.println("Invalid input! Fewer than 7 numbers are provided. Please try again!");
        } else if (intArray.length > 7) {
            System.out.println("Invalid input! More than 7 numbers are provided. Please try again!");
        } else if (!this.checkMax(intArray)) {
            System.out.println("Invalid input! All numbers must be in the range from 1 to 35!");
        } else if (!this.checkDuplicate(intArray)) {
            System.out.println("Invalid input! All numbers must be different!");
        } else {
            Arrays.sort(intArray);
            this.numbers = intArray;
        }
    }

    public boolean checkMax(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > 35) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDuplicate(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[i] == intArray[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[] getNumbers() {
        return this.numbers;
    }

}
