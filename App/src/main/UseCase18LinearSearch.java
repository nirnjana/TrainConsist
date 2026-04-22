/**
 * UC18 - Linear Search for Bogie ID (Array-Based Searching)
 *
 * Goal: Search and identify a specific bogie ID from an unsorted list
 *       using Linear Search.
 *
 * Key Concepts:
 *  - Linear Search    : Sequential scan of every element until a match is found
 *  - Time Complexity  : O(n) — may scan the entire array in the worst case
 *  - Works on Unsorted Data : No preprocessing required
 *  - return index     : Returns position (0-based) if found, -1 if not found
 *  - String.equals()  : Used for String comparison (not ==)
 *
 * Flow:
 *  1. User provides a list of bogie IDs (String array)
 *  2. User provides a search key
 *  3. System traverses the array sequentially
 *  4. Each element is compared with the search key
 *  5. If match found, search stops
 *  6. Result is displayed
 *  7. Program continues
 */
public class UseCase18LinearSearch {

    /**
     * Performs linear search on a String array.
     *
     * @param bogieIDs  Array of bogie IDs to search through
     * @param searchKey The bogie ID to find
     * @return Index of the match (0-based) or -1 if not found
     */
    public static int linearSearch(String[] bogieIDs, String searchKey) {
        for (int i = 0; i < bogieIDs.length; i++) {
            if (bogieIDs[i].equals(searchKey)) {
                return i; // Match found — stop and return index
            }
        }
        return -1; // Not found
    }

    /**
     * Displays the search result in a readable format.
     */
    private static void displayResult(String searchKey, int index) {
        if (index != -1) {
            System.out.println("  ✔ '" + searchKey + "' found at index " + index
                    + " (position " + (index + 1) + " in the list)");
        } else {
            System.out.println("  ✘ '" + searchKey + "' not found in the consist.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC18 - Linear Search for Bogie ID\n");

        // Step 1: Bogie ID array (unsorted — linear search works on any order)
        String[] bogieIDs = {"B005", "B002", "B008", "B001", "B006", "B003", "B007", "B004"};

        System.out.println("Bogie IDs in consist:");
        for (int i = 0; i < bogieIDs.length; i++) {
            System.out.println("  [" + i + "] " + bogieIDs[i]);
        }

        // Step 2–6: Search for various bogie IDs
        System.out.println("\nSearch Results:");
        displayResult("B003", linearSearch(bogieIDs, "B003")); // Found
        displayResult("B001", linearSearch(bogieIDs, "B001")); // Found
        displayResult("B010", linearSearch(bogieIDs, "B010")); // Not found
        displayResult("B007", linearSearch(bogieIDs, "B007")); // Found

        System.out.println("\nProgram continues...");
    }
}
