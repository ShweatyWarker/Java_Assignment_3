package EX1407;

import java.util.Scanner;

public class Answer14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user
        System.out.print("Enter an English sentence (no punctuation): ");
        String sentence = input.nextLine();

        // Split the sentence into words
        String[] words = sentence.split(" ");

        // Process each word and print Pig Latin
        System.out.println("\nPig Latin Translation:");

        for (String word : words) {
            printLatinWord(word);
            System.out.print(" ");
        }

        System.out.println(); // for newline
        input.close();
    }

    // Method to print a single word converted to Pig Latin
    public static void printLatinWord(String word) {
        String pigLatin = word.substring(1) + word.charAt(0) + "ay";
        System.out.print(pigLatin);
    }
}