import java.util.HashSet;
import java.util.Set;

/**
 * UC3 - Track Unique Bogie IDs (Set – HashSet)
 *
 * Goal: Ensure no duplicate bogie IDs are added to the train.
 *
 * Key Concepts:
 *  - HashSet              : Stores unique elements; no duplicates allowed
 *  - Set Interface        : Collection type that does not allow duplicate elements
 *  - add()                : Inserts value into the set (ignored if duplicate)
 *  - Automatic Dedup      : HashSet ensures uniqueness without manual checks
 *  - Unordered Storage    : Elements are NOT stored in index-based order
 *
 * Flow:
 *  1. User adds bogie IDs (including duplicates)
 *  2. System inserts into HashSet
 *  3. Duplicates are ignored automatically
 *  4. Unique IDs are displayed
 */
public class UseCase3HashSetBogieIDs {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC3 - Track Unique Bogie IDs Using HashSet\n");

        // Step 1: Create a HashSet<String> to store unique bogie IDs
        Set<String> bogieIDs = new HashSet<>();

        // Step 2: Add bogie IDs — including intentional duplicates
        bogieIDs.add("B001");
        bogieIDs.add("B002");
        bogieIDs.add("B003");
        bogieIDs.add("B001");  // Duplicate — will be ignored automatically
        bogieIDs.add("B002");  // Duplicate — will be ignored automatically
        bogieIDs.add("B004");

        // Step 3: Display unique IDs
        System.out.println("Unique Bogie IDs in the consist:");
        for (String id : bogieIDs) {
            System.out.println("  -> " + id);
        }

        // Step 4: Show total unique count
        System.out.println("\nTotal unique bogies: " + bogieIDs.size());

        // Step 5: Demonstrate add() return value
        boolean added    = bogieIDs.add("B005");  // New ID
        boolean notAdded = bogieIDs.add("B001");  // Duplicate

        System.out.println("\nadd(\"B005\") returned: " + added    + " (new element)");
        System.out.println("add(\"B001\") returned: " + notAdded + " (duplicate — rejected)");

        System.out.println("\nProgram continues...");
    }
}
