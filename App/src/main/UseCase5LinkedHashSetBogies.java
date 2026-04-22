import java.util.LinkedHashSet;
import java.util.Set;

/**
 * UC5 - Preserve Insertion Order of Bogies (LinkedHashSet)
 *
 * Goal: Maintain insertion order while enforcing uniqueness in bogie formation.
 *
 * Key Concepts:
 *  - LinkedHashSet          : Hash table + linked list implementation of Set;
 *                             stores unique elements while maintaining insertion order
 *  - Set Interface          : Collection type that does not allow duplicate elements
 *  - add()                  : Inserts bogie; ignored if already exists
 *  - Automatic Deduplication: Duplicates removed internally without manual logic
 *  - Insertion Order        : Unlike HashSet, elements are returned in add() order
 *  - Ordered Iteration      : Bogies printed in the same order they were attached
 *
 * Flow:
 *  1. User adds bogies (including duplicates)
 *  2. LinkedHashSet stores them
 *  3. Formation is printed in original insertion order
 */
public class UseCase5LinkedHashSetBogies {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC5 - Preserve Insertion Order of Bogies Using LinkedHashSet\n");

        // Step 1: Create a LinkedHashSet<String> for the bogie formation
        Set<String> formation = new LinkedHashSet<>();

        // Step 2: Add bogies — including intentional duplicates
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("AC Chair");
        formation.add("Pantry Car");
        formation.add("Sleeper");     // Duplicate — automatically ignored
        formation.add("Guard Van");
        formation.add("Engine");      // Duplicate — automatically ignored
        formation.add("First Class");

        // Step 3: Print formation in original insertion order
        System.out.println("Train formation (insertion order preserved, duplicates removed):");
        int position = 1;
        for (String bogie : formation) {
            System.out.println("  " + position++ + ". " + bogie);
        }

        System.out.println("\nTotal unique bogies in formation: " + formation.size());

        // Demonstrate add() return values
        boolean added    = formation.add("Dining Car");  // New
        boolean notAdded = formation.add("Engine");      // Duplicate

        System.out.println("\nadd(\"Dining Car\") returned: " + added
                + " (new — added at end)");
        System.out.println("add(\"Engine\")     returned: " + notAdded
                + " (duplicate — not added)");

        System.out.println("\nProgram continues...");
    }
}
