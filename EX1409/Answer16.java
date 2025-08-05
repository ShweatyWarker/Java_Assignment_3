package EX1409;

import java.util.Scanner;

public class Answer16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask the user for input
        System.out.print("Enter a line of text: ");
        String sentence = input.nextLine();

        // Split the sentence into words using space as a delimiter
        String[] words = sentence.split(" ");

        // Print the words in reverse order
        System.out.println("Reversed sentence:");
        for (int i = words.length - 1; i >= 0; i--) {
            System.out.print(words[i] + " ");
        }

        input.close();
    }
}