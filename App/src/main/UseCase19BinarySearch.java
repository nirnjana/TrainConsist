/**
 * UC19 - Binary Search for Bogie ID (Optimised Searching)
 *
 * Goal: Find a bogie ID efficiently using binary search on sorted data.
 *
 * Key Concepts:
 *  - Binary Search    : Divides the search space in half each iteration
 *  - Precondition     : Data MUST be sorted before binary search is applied
 *  - low / high index : Pointers that define current search range
 *  - mid index        : (low + high) / 2 — midpoint of current range
 *  - Comparison       : If key == mid → found; key < mid → go left; key > mid → go right
 *  - Time Complexity  : O(log n) — much faster than linear search for large datasets
 *  - compareTo()      : Used for String lexicographic comparison
 *
 * Flow:
 *  1. User provides sorted bogie IDs
 *  2. User provides a search key
 *  3. System initialises low and high indexes
 *  4. System finds the middle index
 *  5. Key is compared with middle value
 *  6. Search range is halved
 *  7. Repeats until found or exhausted
 *  8. Result is displayed
 */
public class UseCase19BinarySearch {

    /**
     * Performs binary search on a SORTED String array.
     * Requires the array to be sorted in ascending order.
     *
     * @param bogieIDs  Sorted array of bogie IDs
     * @param searchKey The bogie ID to find
     * @return Index of the match (0-based), or -1 if not found
     */
    public static int binarySearch(String[] bogieIDs, String searchKey) {
        int low  = 0;
        int high = bogieIDs.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;          // Step 4: Find midpoint
            int cmp = bogieIDs[mid].compareTo(searchKey); // Step 5: Compare

            if (cmp == 0) {
                return mid;       // Exact match found
            } else if (cmp < 0) {
                low = mid + 1;    // Search key is greater → go RIGHT
            } else {
                high = mid - 1;   // Search key is smaller → go LEFT
            }
        }
        return -1; // Not found
    }

    /**
     * Displays the search trace for teaching purposes.
     */
    public static int binarySearchWithTrace(String[] bogieIDs, String searchKey) {
        int low  = 0;
        int high = bogieIDs.length - 1;
        int step = 1;

        System.out.println("  Search trace for '" + searchKey + "':");
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = bogieIDs[mid].compareTo(searchKey);

            System.out.println("    Step " + step + ": low=" + low
                    + " high=" + high + " mid=" + mid
                    + " → checking '" + bogieIDs[mid] + "'");

            if (cmp == 0)        { return mid; }
            else if (cmp < 0)    { low  = mid + 1; }
            else                 { high = mid - 1; }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC19 - Binary Search for Bogie ID\n");

        // Step 1: SORTED bogie IDs (binary search requires sorted input)
        String[] bogieIDs = {"B001", "B002", "B003", "B004", "B005",
                             "B006", "B007", "B008", "B009", "B010"};

        System.out.println("Sorted bogie IDs:");
        for (int i = 0; i < bogieIDs.length; i++) {
            System.out.print("  [" + i + "]" + bogieIDs[i]);
        }
        System.out.println();

        // Search with trace
        System.out.println();
        int idx1 = binarySearchWithTrace(bogieIDs, "B007");
        System.out.println("  Result: " + (idx1 != -1
                ? "✔ Found at index " + idx1 : "✘ Not found") + "\n");

        int idx2 = binarySearchWithTrace(bogieIDs, "B003");
        System.out.println("  Result: " + (idx2 != -1
                ? "✔ Found at index " + idx2 : "✘ Not found") + "\n");

        int idx3 = binarySearchWithTrace(bogieIDs, "B011");
        System.out.println("  Result: " + (idx3 != -1
                ? "✔ Found at index " + idx3 : "✘ Not found"));

        System.out.println("\nProgram continues...");
    }
}
