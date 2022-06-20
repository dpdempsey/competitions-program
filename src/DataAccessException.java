/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

/**
 * Custom exception class for handling file access exceptions
 * 
 * @author Declan Dempsey
 */
public class DataAccessException extends Exception {
    /**
     * Default constructor referencing parent class Exception
     */
    public DataAccessException() {
        super();
    }

    /**
     * Constrcutor with error message
     * 
     * @param message the error message
     */
    public DataAccessException(String message) {
        super(message);
        System.out.println(message);
        System.exit(0);
    }

}