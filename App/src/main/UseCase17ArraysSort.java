import java.util.Arrays;

/**
 * UC17 - Sort Bogie Names Using Arrays.sort()
 *
 * Goal: Sort bogie type names alphabetically using Java's built-in Arrays.sort().
 *
 * Key Concepts:
 *  - Arrays.sort()     : Built-in Java method for sorting arrays efficiently
 *  - String[] array    : Array of bogie type name strings
 *  - Natural Ordering  : Strings are sorted lexicographically (A-Z)
 *  - In-place Sort     : Arrays.sort() modifies the original array
 *  - Arrays.toString() : Converts array to readable string for printing
 *
 * Flow:
 *  1. User provides bogie type names (String array)
 *  2. System calls Arrays.sort() on the array
 *  3. Java internally sorts the values
 *  4. Sorted bogie names are displayed
 *  5. Program continues
 */
public class UseCase17ArraysSort {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC17 - Sort Bogie Names Using Arrays.sort()\n");

        // Step 1: Array of bogie type names
        String[] bogieTypes = {
            "Sleeper", "Guard Van", "AC Chair", "Engine",
            "First Class", "General", "Pantry Car"
        };

        System.out.println("Before sort:");
        System.out.println("  " + Arrays.toString(bogieTypes));

        // Step 2: Sort alphabetically using Arrays.sort()
        Arrays.sort(bogieTypes);

        // Step 4: Display sorted names
        System.out.println("\nAfter sort (alphabetical):");
        System.out.println("  " + Arrays.toString(bogieTypes));

        System.out.println("\nSorted bogie names (enumerated):");
        for (int i = 0; i < bogieTypes.length; i++) {
            System.out.println("  " + (i + 1) + ". " + bogieTypes[i]);
        }

        // Bonus: Sort a copy without modifying the original using Arrays.copyOf()
        String[] original = {"Sleeper", "Engine", "Guard Van", "AC Chair"};
        String[] sortedCopy = Arrays.copyOf(original, original.length);
        Arrays.sort(sortedCopy);

        System.out.println("\nOriginal (unchanged): " + Arrays.toString(original));
        System.out.println("Sorted copy         : " + Arrays.toString(sortedCopy));

        System.out.println("\nProgram continues...");
    }
}
