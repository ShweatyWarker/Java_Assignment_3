package EX1121;

public class Answer10 {

    public static void main(String[] args) {
        try {
            method1();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught exception in main: " + e);
        }
    }

    public static void method1() {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println("Number: " + numbers[1]); // valid
            System.out.println("Number: " + numbers[5]); // this will throw exception
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException in method1");
        }

        // ArrayIndexOutOfBoundsException is not caught here, so it goes to main
    }
}