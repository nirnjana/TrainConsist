import java.util.ArrayList;
import java.util.List;

/**
 * UC20 - Exception Handling During Search Operations
 *
 * Goal: Prevent search operations on an empty train by throwing an exception early.
 *
 * Key Concepts:
 *  - IllegalStateException : Built-in Java exception used when the system is in an
 *                            invalid or inconsistent state for the requested operation
 *  - Guard Clause          : Check preconditions at the start of a method and throw early
 *  - Fail Fast Principle   : Detect and report errors as early as possible
 *  - try-catch             : Caller wraps the search in exception handling
 *  - Meaningful Messages   : Exception message clearly tells the user WHY it failed
 *
 * Flow:
 *  1. User triggers a search operation
 *  2. System checks whether the bogie collection is empty
 *  3. If no bogies available → IllegalStateException thrown
 *  4. Operation stops immediately
 *  5. User receives a meaningful error message
 */
public class UseCase20ExceptionOnEmptySearch {

    // -----------------------------------------------------------------------
    // Bogie class
    // -----------------------------------------------------------------------
    static class Bogie {
        String bogieId;
        String type;

        Bogie(String bogieId, String type) {
            this.bogieId = bogieId;
            this.type    = type;
        }

        @Override
        public String toString() {
            return "[" + bogieId + "] " + type;
        }
    }

    // -----------------------------------------------------------------------
    // TrainConsist class — manages bogies and protects search operations
    // -----------------------------------------------------------------------
    static class TrainConsist {
        private List<Bogie> bogies = new ArrayList<>();

        public void addBogie(String id, String type) {
            bogies.add(new Bogie(id, type));
            System.out.println("  Added: " + bogies.get(bogies.size() - 1));
        }

        public int size() {
            return bogies.size();
        }

        /**
         * Searches for a bogie by ID.
         * Throws IllegalStateException if the consist is empty.
         *
         * @param bogieId ID to search for
         * @return The Bogie object if found, null if not found
         * @throws IllegalStateException if the train consist is empty
         */
        public Bogie search(String bogieId) {
            // Guard clause: fail fast on empty consist
            if (bogies.isEmpty()) {
                throw new IllegalStateException(
                        "Cannot perform search: Train consist is empty. "
                        + "Please add bogies before searching.");
            }

            // Perform linear search
            for (Bogie b : bogies) {
                if (b.bogieId.equals(bogieId)) {
                    return b;
                }
            }
            return null; // Not found, but no exception (consist was not empty)
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC20 - Exception Handling During Search Operations\n");

        // --- Scenario 1: Search on empty consist → exception ---
        System.out.println("--- Scenario 1: Searching on empty consist ---");
        TrainConsist emptyTrain = new TrainConsist();
        try {
            emptyTrain.search("B001");
        } catch (IllegalStateException e) {
            System.out.println("✘ Exception caught: " + e.getMessage());
        }

        // --- Scenario 2: Search after adding bogies → works ---
        System.out.println("\n--- Scenario 2: Searching on populated consist ---");
        TrainConsist train = new TrainConsist();
        train.addBogie("B001", "Locomotive");
        train.addBogie("B002", "AC Sleeper");
        train.addBogie("B003", "Guard Van");

        try {
            Bogie found = train.search("B002");
            if (found != null) {
                System.out.println("✔ Found: " + found);
            } else {
                System.out.println("✘ Bogie not in consist.");
            }
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // --- Scenario 3: Bogie not in consist (no exception) ---
        System.out.println("\n--- Scenario 3: Searching for non-existent bogie ---");
        try {
            Bogie result = train.search("B099");
            System.out.println(result != null ? "✔ Found: " + result
                    : "✘ B099 not found (no exception — consist has bogies).");
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("\nProgram continues safely...");
    }
}
