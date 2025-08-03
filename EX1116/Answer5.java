package EX1116;

// ExceptionA is the superclass
class ExceptionA extends Exception {
    public ExceptionA(String message) {
        super(message);
    }
}

// ExceptionB inherits from ExceptionA
class ExceptionB extends ExceptionA {
    public ExceptionB(String message) {
        super(message);
    }
}

// ExceptionC inherits from ExceptionB
class ExceptionC extends ExceptionB {
    public ExceptionC(String message) {
        super(message);
    }
}

// Main class for testing the exception hierarchy
public class Answer5 {
    public static void main(String[] args) {
        try {
            // You can change this to new ExceptionB(...) or new ExceptionA(...) to test
            throw new ExceptionC("ExceptionC was thrown");
        } catch (ExceptionA e) {
            System.out.println("Caught ExceptionA: " + e.getMessage());
        }
    }
}