package EX1117;

import java.io.IOException;

// Custom ExceptionA class extending Exception
class ExceptionA extends Exception {
    public ExceptionA(String message) {
        super(message);
    }
}

// Custom ExceptionB class extending ExceptionA
class ExceptionB extends ExceptionA {
    public ExceptionB(String message) {
        super(message);
    }
}

public class Answer6 {
    public static void main(String[] args) {
        // Test ExceptionA
        try {
            throw new ExceptionA("This is ExceptionA");
        } catch (Exception e) {
            System.out.println("Caught: " + e.getClass().getSimpleName() + " – " + e.getMessage());
        }

        // Test ExceptionB
        try {
            throw new ExceptionB("This is ExceptionB");
        } catch (Exception e) {
            System.out.println("Caught: " + e.getClass().getSimpleName() + " – " + e.getMessage());
        }

        // Test NullPointerException
        try {
            throw new NullPointerException("This is a NullPointerException");
        } catch (Exception e) {
            System.out.println("Caught: " + e.getClass().getSimpleName() + " – " + e.getMessage());
        }

        // Test IOException
        try {
            throw new IOException("This is an IOException");
        } catch (Exception e) {
            System.out.println("Caught: " + e.getClass().getSimpleName() + " – " + e.getMessage());
        }
    }
}