/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
/**
 * Class used to create an array of random numbers as the
 * auto entry for LuckyNumbers competitions
 */
public class AutoNumbersEntry extends NumbersEntry {
    private final int NUMBER_COUNT = 7;
    private final int MAX_NUMBER = 35;

    public AutoNumbersEntry(){
        super();
    }

    /**
     * Creates an array of random numbers
     * @param seed to define randomness
     * @return the array of random numbers
     */
    public int[] createNumbers(int seed) {
        ArrayList<Integer> validList = new ArrayList<Integer>();
        int[] tempNumbers = new int[NUMBER_COUNT];
        for (int i = 1; i <= MAX_NUMBER; i++) {
            validList.add(i);
        }
        Collections.shuffle(validList, new Random(seed));
        for (int i = 0; i < NUMBER_COUNT; i++) {
            tempNumbers[i] = validList.get(i);
        }
        Arrays.sort(tempNumbers);
        return tempNumbers;
    }

}