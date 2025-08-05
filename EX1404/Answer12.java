package EX1404;

import java.util.Scanner;

public class Answer12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //first string
        System.out.print("Eenie: ");
        String first = input.nextLine();

        //second string
        System.out.print("Meenie: ");
        String second = input.nextLine();

        // starting index for comparison
        System.out.print("0: ");
        int startIndex = input.nextInt();

        // number of characters to compare
        System.out.print("5: ");
        int length = input.nextInt();

        // case-insensitive region comparison
        boolean result = first.regionMatches(true, startIndex, second, startIndex, length);

        if (result) {
            System.out.println("The specified portions of the strings are equal (ignoring case).");
        } else {
            System.out.println("The specified portions of the strings are NOT equal.");
        }

        input.close();
    }
}