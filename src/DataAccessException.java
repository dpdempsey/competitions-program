/*
 * Student name: XXX
 * Student ID: YYY
 * LMS username: ZZZ
 */

import java.io.FileNotFoundException;

public class DataAccessException extends Exception {
    public DataAccessException() {
        super();
    }

    public DataAccessException(String message) {
        super(message);
        System.out.println(message);
        System.exit(0);
    }

}