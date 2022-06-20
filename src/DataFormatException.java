/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

/**
 * Custom exception class handling format errors
 * 
 * @author Declan Dempsey
 */
public class DataFormatException extends Exception {
    /*
     * Default constructor calling parent Exception class
     */
    public DataFormatException() {
        super();
    }

    /**
     * Constructor with error message
     * 
     * @param message the error message
     */
    public DataFormatException(String message) {
        super(message);
        System.out.println(message);
        System.exit(0);
    }
}
