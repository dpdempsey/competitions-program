/*
 * Student name: XXX
 * Student ID: YYY
 * LMS username: ZZZ
 */

public class DataFormatException extends Exception {
    public DataFormatException(){
        super();
    }

    public DataFormatException(String message){
        super(message);
        System.out.println(message);
        System.exit(0);
    }
}
