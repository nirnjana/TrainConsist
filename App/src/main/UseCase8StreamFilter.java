import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UC8 - Filter Passenger Bogies Using Streams
 *
 * Goal: Filter passenger bogies using Stream pipelines based on seating capacity.
 *
 * Key Concepts:
 *  - Stream API          : Modern Java feature for declarative collection processing
 *  - stream()            : Converts a List into a stream pipeline
 *  - filter()            : Selects elements that satisfy a given condition (predicate)
 *  - Lambda Expressions  : Concise behavior for filtering logic (no manual loops)
 *  - collect(Collectors.toList()) : Converts processed stream back into a List
 *  - Declarative Style   : Focuses on WHAT to do, not HOW to loop
 *
 * Flow:
 *  1. User creates a list of bogies
 *  2. System converts the list into a stream
 *  3. filter() is applied with a condition (capacity > threshold)
 *  4. Matching bogies are collected into a new list
 *  5. Filtered bogies are displayed
 *  6. Program continues
 */
public class UseCase8StreamFilter {

    // -----------------------------------------------------------------------
    // Bogie class — custom object with name and capacity fields
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
        System.out.println("UC8 - Filter Passenger Bogies Using Streams\n");

        // Step 1: Create a list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Engine",      0));
        bogies.add(new Bogie("Sleeper",    72));
        bogies.add(new Bogie("AC Chair",   64));
        bogies.add(new Bogie("First Class",18));
        bogies.add(new Bogie("General",    90));
        bogies.add(new Bogie("Guard Van",   8));
        bogies.add(new Bogie("Pantry Car",  0));

        System.out.println("All bogies:");
        bogies.forEach(b -> System.out.println("  " + b));

        // Step 2–4: Convert to stream → filter() → collect()
        // Filter: bogies with capacity GREATER THAN 50
        int threshold = 50;
        List<Bogie> highCapacity = bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());

        // Step 5: Display filtered bogies
        System.out.println("\nBogies with capacity > " + threshold + ":");
        if (highCapacity.isEmpty()) {
            System.out.println("  No bogies match the filter.");
        } else {
            highCapacity.forEach(b -> System.out.println("  -> " + b));
        }
        System.out.println("Count: " + highCapacity.size());

        // Bonus: Filter bogies with capacity == 0 (non-passenger cars)
        List<Bogie> nonPassenger = bogies.stream()
                .filter(b -> b.capacity == 0)
                .collect(Collectors.toList());

        System.out.println("\nNon-passenger bogies (capacity = 0):");
        nonPassenger.forEach(b -> System.out.println("  -> " + b));
        System.out.println("Count: " + nonPassenger.size());

        System.out.println("\nProgram continues...");
    }
}
