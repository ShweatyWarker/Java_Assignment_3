package EX1403;

import java.util.Scanner;

public class Answer11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String first = input.nextLine();

        System.out.print("Enter second string: ");
        String second = input.nextLine();

        int result = first.compareTo(second);

        if (result < 0) {
            System.out.println("The first string is less than the second.");
        } else if (result == 0) {
            System.out.println("The two strings are equal.");
        } else {
            System.out.println("The first string is greater than the second.");
        }

        input.close();
    }
}