package EX1119;

class SomeClass {
    public SomeClass() throws Exception {
        // Simulate a constructor failure
        throw new Exception("Constructor failed in SomeClass");
    }
}

public class Answer8 {
    public static void main(String[] args) {
        try {
            SomeClass obj = new SomeClass();
            System.out.println("Created object: " + obj);
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}