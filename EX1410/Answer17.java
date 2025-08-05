package EX1410;

import java.util.Scanner;

public class Answer17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input a line of text
        System.out.print("Enter a line of text: ");
        String input = scanner.nextLine();

        // Display in uppercase
        System.out.println("Uppercase: " + input.toUpperCase());

        // Display in lowercase
        System.out.println("Lowercase: " + input.toLowerCase());

        scanner.close();
    }
}