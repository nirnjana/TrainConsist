/**
 * UC16 - Sort Passenger Bogies by Capacity (Bubble Sort)
 *
 * Goal: Sort passenger bogie capacities using Bubble Sort (manual algorithm).
 *
 * Key Concepts:
 *  - Bubble Sort      : Compares adjacent elements and swaps if out of order
 *  - Outer Loop       : Passes (n-1 passes needed for n elements)
 *  - Inner Loop       : Each pass compares pairs and bubbles the largest to the end
 *  - Swap             : Uses a temp variable to exchange two values
 *  - In-place Sort    : Modifies the original array without extra space
 *  - Time Complexity  : O(n²) — suitable for small datasets
 *
 * Flow:
 *  1. User provides passenger bogie capacities (int array)
 *  2. System iterates through the array
 *  3. Adjacent values are compared
 *  4. If out of order, values are swapped
 *  5. Multiple passes until sorted
 *  6. Sorted result is displayed
 */
public class UseCase16BubbleSort {

    /**
     * Sorts an int array in ascending order using Bubble Sort.
     *
     * @param arr The array to sort (modified in-place)
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // Outer loop: n-1 passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop: compare adjacent pairs
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp  = arr[j];
                    arr[j]    = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Prints the contents of an int array.
     */
    public static void printArray(String label, int[] arr) {
        System.out.print(label + ": [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC16 - Sort Passenger Bogies by Capacity (Bubble Sort)\n");

        // Step 1: Passenger bogie capacities
        int[] capacities = {72, 18, 90, 64, 8, 54, 72};

        printArray("Before sort", capacities);

        // Step 2–5: Apply bubble sort
        bubbleSort(capacities);

        // Step 6: Display sorted result
        printArray("After sort ", capacities);

        System.out.println("\nBogie capacities sorted in ascending order:");
        for (int i = 0; i < capacities.length; i++) {
            System.out.println("  Rank " + (i + 1) + ": " + capacities[i] + " seats");
        }

        System.out.println("\nProgram continues...");
    }
}
