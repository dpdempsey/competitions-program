/*
 * Student name: Declan Dempsey
 * Student ID: 1336622
 * LMS username: ddempsey
 */

public class DataFormatException extends Exception {
    public DataFormatException() {
        super();
    }

    public DataFormatException(String message) {
        super(message);
        System.out.println(message);
        System.exit(0);
    }
}
