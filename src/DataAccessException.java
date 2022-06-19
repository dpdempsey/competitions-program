/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

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