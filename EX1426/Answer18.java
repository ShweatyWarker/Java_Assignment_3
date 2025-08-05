package EX1426;

import java.util.*;

public class Answer18 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

        // Mapping of ingredients to healthier substitutions
        Map<String, String> substitutions = new LinkedHashMap<>();
        substitutions.put("1 cup sour cream", "1 cup yogurt");
        substitutions.put("1 cup milk", "1/2 cup evaporated milk and 1/2 cup water");
        substitutions.put("1 teaspoon lemon juice", "1/2 teaspoon vinegar");
        substitutions.put("1 cup sugar", "1/2 cup honey, 1 cup molasses or 1/4 cup agave nectar");
        substitutions.put("1 cup butter", "1 cup margarine or yogurt");
        substitutions.put("1 cup flour", "1 cup rye or rice flour");
        substitutions.put("1 cup mayonnaise", "1 cup cottage cheese or 1/8 cup mayonnaise and 7/8 cup yogurt");
        substitutions.put("1 egg", "2 tablespoons cornstarch, arrowroot flour or potato starch or 2 egg whites or 1/2 of a large banana (mashed)");
        substitutions.put("1 cup soy milk", "1 cup milk");
        substitutions.put("1/4 cup oil", "1/4 cup applesauce");
        substitutions.put("white bread", "whole-grain bread");

        System.out.println("Enter your recipe (type 'end' on a new line to finish):");

        List<String> recipeLines = new ArrayList<>();
        while (true) {
            String line = scanner.nextLine();
            if (line.trim().equalsIgnoreCase("end")) {
                break;
            }
            recipeLines.add(line);
        }

        System.out.println("\n--- Healthier Recipe Suggestions ---");

        boolean found = false;
        for (String line : recipeLines) {
            boolean substituted = false;
            for (String ingredient : substitutions.keySet()) {
                if (line.toLowerCase().contains(ingredient.toLowerCase())) {
                    System.out.println("Instead of: \"" + line + "\"");
                    System.out.println("Try using: \"" + substitutions.get(ingredient) + "\"\n");
                    substituted = true;
                    found = true;
                    break;
                }
            }
            if (!substituted) {
                System.out.println("Keep: \"" + line + "\"");
            }
        }

        if (!found) {
            System.out.println("No substitutions were found based on your input.");
        }

        System.out.println("\n Always consult your physician before making significant changes to your diet.");
        }
    }
}