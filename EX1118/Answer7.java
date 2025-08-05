// File: Answer7.java
// Package: EX1118

package EX1118;

public class Answer7 {
    public static void main(String[] args) {
        try {
            // You can change this to test other exceptions
            throw new ArithmeticException("This is an ArithmeticException");
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}