package EX1408;

import java.util.Scanner;

public class Answer15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter phone number in the format (555) 555-5555: ");
        String input = scanner.nextLine();

        // First split: separate area code from rest
        String[] firstSplit = input.split("\\) ");
        String areaCodeWithParen = firstSplit[0];
        String restOfNumber = firstSplit[1];
        
        // Extract area code (remove opening parenthesis)
        String areaCode = areaCodeWithParen.substring(1);
        
        // Second split: separate the two parts of phone number
        String[] phoneParts = restOfNumber.split("-");
        String firstThree = phoneParts[0];
        String lastFour = phoneParts[1];
        
        // Concatenate the seven digits
        String phoneNumber = firstThree + lastFour;

        // Output
        System.out.println("Area code: " + areaCode);
        System.out.println("Phone number: " + phoneNumber);

        scanner.close();
    }
}