package EX1120;

public class Answer9 {
    
    public static void main(String[] args) {
        try {
            someMethod();
        } catch (Exception e) {
            System.out.println("Exception caught in main:");
            e.printStackTrace();
        }
    }

    public static void someMethod() throws Exception {
        try {
            someMethod2();
        } catch (Exception e) {
            System.out.println("Exception caught in someMethod, rethrowing...");
            throw e; // Rethrowing the same exception
        }
    }

    public static void someMethod2() throws Exception {
        throw new Exception("Exception thrown in someMethod2");
    }
}