import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * UC12 - Safety Compliance Check for Goods Bogies
 *
 * Goal: Encapsulate bogie rules using functional interfaces and apply them
 *       using lambda expressions.
 *
 * Key Concepts:
 *  - Predicate<T>        : Functional interface that takes an input and returns boolean
 *  - allMatch()          : Returns true only if ALL elements satisfy the predicate
 *  - anyMatch()          : Returns true if AT LEAST ONE element satisfies the predicate
 *  - Lambda Predicates   : Concise way to define safety rules
 *  - Functional Interface: Single-abstract-method interface enabling lambda usage
 *
 * Safety Rules for Goods Bogies:
 *  1. Weight must not exceed 50 tonnes
 *  2. Cylindrical bogies can only carry liquid cargo
 *  3. Bogie must be marked safe (isSafe = true)
 *
 * Flow:
 *  1. User prepares a list of goods bogies
 *  2. System converts list to stream
 *  3. allMatch() checks every bogie against safety rules
 *  4. Conditional logic verifies cylindrical cargo
 *  5. If all pass → train marked safe
 *  6. Result displayed
 */
public class UseCase12SafetyCompliance {

    // -----------------------------------------------------------------------
    // GoodsBogie class
    // -----------------------------------------------------------------------
    static class GoodsBogie {
        String bogieId;
        String shape;       // "Cylindrical" or "Rectangular"
        String cargoType;   // "Liquid", "Solid", "Gas"
        int weightTonnes;   // Weight in tonnes
        boolean isSafe;     // Pre-marked safety flag

        GoodsBogie(String bogieId, String shape, String cargoType,
                   int weightTonnes, boolean isSafe) {
            this.bogieId      = bogieId;
            this.shape        = shape;
            this.cargoType    = cargoType;
            this.weightTonnes = weightTonnes;
            this.isSafe       = isSafe;
        }

        @Override
        public String toString() {
            return "[" + bogieId + "] Shape=" + shape
                    + " Cargo=" + cargoType
                    + " Weight=" + weightTonnes + "T"
                    + " Safe=" + isSafe;
        }
    }

    // -----------------------------------------------------------------------
    // Safety Predicates (functional interfaces via lambdas)
    // -----------------------------------------------------------------------

    /** Rule 1: Weight must be ≤ 50 tonnes */
    static Predicate<GoodsBogie> weightSafe       = b -> b.weightTonnes <= 50;

    /** Rule 2: Cylindrical bogies must only carry Liquid cargo */
    static Predicate<GoodsBogie> cylindricalSafe  =
            b -> !b.shape.equals("Cylindrical") || b.cargoType.equals("Liquid");

    /** Rule 3: Bogie must be marked safe */
    static Predicate<GoodsBogie> markedSafe       = b -> b.isSafe;

    /** Combined rule: ALL three rules must pass */
    static Predicate<GoodsBogie> fullSafetyCheck  =
            weightSafe.and(cylindricalSafe).and(markedSafe);

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC12 - Safety Compliance Check for Goods Bogies\n");

        // Step 1: Prepare a list of goods bogies
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("G001", "Cylindrical",  "Liquid",  30, true));
        goodsBogies.add(new GoodsBogie("G002", "Rectangular",  "Solid",   45, true));
        goodsBogies.add(new GoodsBogie("G003", "Cylindrical",  "Liquid",  20, true));
        goodsBogies.add(new GoodsBogie("G004", "Rectangular",  "Solid",   50, true));

        System.out.println("Goods Bogies:");
        goodsBogies.forEach(b -> System.out.println("  " + b));

        // Step 2–4: Apply allMatch() with the combined safety predicate
        boolean allSafe = goodsBogies.stream().allMatch(fullSafetyCheck);

        System.out.println("\n--- Safety Check Results ---");
        System.out.println("Weight check (<=50T)         : "
                + goodsBogies.stream().allMatch(weightSafe));
        System.out.println("Cylindrical cargo check      : "
                + goodsBogies.stream().allMatch(cylindricalSafe));
        System.out.println("Safety marked check          : "
                + goodsBogies.stream().allMatch(markedSafe));

        System.out.println("\nFull Safety Compliance (allMatch): " + allSafe);
        System.out.println("Train Status: " + (allSafe ? "✔ SAFE TO DEPART" : "✘ UNSAFE — DO NOT DEPART"));

        // Demonstrate failure case
        System.out.println("\n--- Adding an unsafe bogie ---");
        goodsBogies.add(new GoodsBogie("G005", "Cylindrical", "Solid", 60, false)); // Violates all 3
        System.out.println("Added: " + goodsBogies.get(goodsBogies.size() - 1));

        boolean stillSafe = goodsBogies.stream().allMatch(fullSafetyCheck);
        System.out.println("Full Safety Compliance: " + stillSafe);
        System.out.println("Train Status: " + (stillSafe ? "✔ SAFE" : "✘ UNSAFE — REVIEW REQUIRED"));

        System.out.println("\nProgram continues...");
    }
}
