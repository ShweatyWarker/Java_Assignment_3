package EX1405;

import java.util.Random;

public class Answer13 {
    public static void main(String[] args) {
        String[] article = {"the", "a", "one", "some", "any"};
        String[] noun = {"boy", "girl", "dog", "town", "car"};
        String[] verb = {"drove", "jumped", "ran", "walked", "skipped"};
        String[] preposition = {"to", "from", "over", "under", "on"};

        Random rand = new Random();

        for (int i = 0; i < 20; i++) {
            String sentence =
                    article[rand.nextInt(article.length)] + " " +
                    noun[rand.nextInt(noun.length)] + " " +
                    verb[rand.nextInt(verb.length)] + " " +
                    preposition[rand.nextInt(preposition.length)] + " " +
                    article[rand.nextInt(article.length)] + " " +
                    noun[rand.nextInt(noun.length)];

            // Capitalize first letter
            sentence = sentence.substring(0, 1).toUpperCase() + sentence.substring(1);

            // Add period at the end
            sentence += ".";

            System.out.println((i + 1) + ": " + sentence);
        }
    }
}