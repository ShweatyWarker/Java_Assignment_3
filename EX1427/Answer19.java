package EX1427;

import java.util.Scanner;

public class Answer19 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // List of 30 spam keywords/phrases
        String[] spamKeywords = {
            "free", "money", "win", "winner", "congratulations",
            "limited time", "urgent", "act now", "click here", "risk-free",
            "guarantee", "buy now", "order now", "100% free", "exclusive deal",
            "double your", "trial", "cheap", "discount", "no cost",
            "credit card", "no obligation", "weight loss", "income", "luxury",
            "investment", "cash bonus", "instant access", "easy money", "work from home"
        };

        System.out.println("Enter your email message:");
        String email = input.useDelimiter("\\A").next().toLowerCase(); // Read full email input

        int spamScore = 0;

        // Count spam keyword matches
        for (String keyword : spamKeywords) {
            if (email.contains(keyword)) {
                spamScore++;
            }
        }

        System.out.println("\nSpam Score: " + spamScore);

        // Spam Likelihood Rating
        if (spamScore >= 20) {
            System.out.println("Spam Likelihood: HIGHLY LIKELY SPAM");
        } else if (spamScore >= 10) {
            System.out.println("Spam Likelihood: MODERATE SPAM");
        } else if (spamScore >= 5) {
            System.out.println("Spam Likelihood: POSSIBLE SPAM");
        } else {
            System.out.println("Spam Likelihood: UNLIKELY SPAM");
        }

        input.close();
    }
} // At the end of inputting information type "^D" (Ctrl+D) to signal -
// end of input
// This is necessary for the Scanner to process the input correctly in -
// some environments