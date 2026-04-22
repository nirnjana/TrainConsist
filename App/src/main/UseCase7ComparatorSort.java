import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * UC7 - Sort Passenger Bogies by Capacity (Comparator)
 *
 * Goal: Sort passenger bogies based on their seating capacity using a custom Comparator.
 *
 * Key Concepts:
 *  - Comparator Interface  : Functional interface to define custom comparison logic
 *  - Custom Objects        : Bogie modeled as a Java object with name and capacity
 *  - List Collection       : Stores multiple Bogie objects for sorting and iteration
 *  - sort()                : Applies Comparator logic to rearrange list elements
 *  - Lambda Expressions    : Concise way to express comparison logic
 *  - Comparator.comparingInt() : Convenience method for int-based sorting
 *  - Separation of Concerns: Data (Bogie) is independent from sorting (Comparator)
 *
 * Flow:
 *  1. User creates passenger bogie objects
 *  2. Bogies are stored in a List
 *  3. System applies a Comparator to sort by capacity
 *  4. Sorted bogies are displayed in order
 *  5. Program continues
 */
public class UseCase7ComparatorSort {

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
        System.out.println("UC7 - Sort Bogies by Capacity Using Comparator\n");

        // Step 1: Create a List<Bogie> to store passenger bogies
        List<Bogie> bogies = new ArrayList<>();

        // Step 2: Add bogies with name and capacity
        bogies.add(new Bogie("Sleeper",     72));
        bogies.add(new Bogie("AC Chair",    64));
        bogies.add(new Bogie("First Class", 18));
        bogies.add(new Bogie("General",     90));
        bogies.add(new Bogie("Guard Van",    8));

        // Display before sorting
        System.out.println("Before sorting:");
        for (Bogie b : bogies) {
            System.out.println("  " + b);
        }

        // Step 3: Sort using Comparator.comparingInt() — ascending by capacity
        bogies.sort(Comparator.comparingInt(bogie -> bogie.capacity));

        // Step 4: Display sorted bogies
        System.out.println("\nAfter sorting (ascending by capacity):");
        for (int i = 0; i < bogies.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + bogies.get(i));
        }

        // Bonus: Sort descending using reversed()
        bogies.sort(Comparator.comparingInt((Bogie bogie) -> bogie.capacity).reversed());
        System.out.println("\nSorted descending by capacity:");
        for (int i = 0; i < bogies.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + bogies.get(i));
        }

        System.out.println("\nProgram continues...");
    }
}
