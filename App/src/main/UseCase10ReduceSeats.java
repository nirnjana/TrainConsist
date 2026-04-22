import java.util.ArrayList;
import java.util.List;

/**
 * UC10 - Count Total Seats in Train (reduce)
 *
 * Goal: Aggregate seating capacities into a single total value using Stream reduction.
 *
 * Key Concepts:
 *  - Stream.reduce()  : Combines stream elements into a single result using an accumulator
 *  - map()            : Transforms each Bogie into its int capacity value
 *  - mapToInt()       : Specialized stream for primitive int, gives access to sum()
 *  - Identity Value   : Starting value for reduce (0 for sum)
 *  - BinaryOperator   : Lambda (a, b) -> a + b that accumulates values
 *  - Method Reference : Integer::sum shorthand for the accumulator
 *
 * Flow:
 *  1. User creates a list of bogies
 *  2. System converts list into a stream
 *  3. map() extracts capacity values
 *  4. reduce() sums the capacities
 *  5. Total seating capacity is displayed
 *  6. Program continues
 */
public class UseCase10ReduceSeats {

    // -----------------------------------------------------------------------
    // Bogie class
    // -----------------------------------------------------------------------
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " (" + capacity + " seats)";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC10 - Count Total Seats in Train Using reduce()\n");

        // Step 1: Create a list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Engine",      0));
        bogies.add(new Bogie("Sleeper-1",  72));
        bogies.add(new Bogie("Sleeper-2",  72));
        bogies.add(new Bogie("AC Chair",   64));
        bogies.add(new Bogie("First Class",18));
        bogies.add(new Bogie("General",    90));
        bogies.add(new Bogie("Pantry Car",  0));
        bogies.add(new Bogie("Guard Van",   8));

        System.out.println("All bogies:");
        bogies.forEach(b -> System.out.println("  " + b));

        // Step 2–4a: Using map() + reduce() with a BinaryOperator
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("\nMethod 1 — map() + reduce(0, Integer::sum):");
        System.out.println("  Total Seating Capacity: " + totalSeats + " seats");

        // Step 4b: Alternative — mapToInt() + sum()
        int totalSeats2 = bogies.stream()
                .mapToInt(b -> b.capacity)
                .sum();

        System.out.println("\nMethod 2 — mapToInt() + sum():");
        System.out.println("  Total Seating Capacity: " + totalSeats2 + " seats");

        // Step 4c: Lambda BinaryOperator version
        int totalSeats3 = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, (acc, cap) -> acc + cap);

        System.out.println("\nMethod 3 — reduce() with lambda accumulator:");
        System.out.println("  Total Seating Capacity: " + totalSeats3 + " seats");

        System.out.println("\nProgram continues...");
    }
}
