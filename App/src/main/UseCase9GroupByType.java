import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * UC9 - Group Bogies by Type
 *
 * Goal: Group bogies into categories using Stream collectors.
 *
 * Key Concepts:
 *  - Collectors.groupingBy() : Classifies elements by a key function into a Map
 *  - Stream Pipeline         : Sequence of operations: list → stream → collect
 *  - Map<String, List<Bogie>>: Key = group name, Value = list of bogies in that group
 *  - Lambda Classification   : Defines HOW bogies are categorized
 *  - Data Aggregation        : Clusters flat data into logical groups
 *
 * Flow:
 *  1. User creates a list of bogies
 *  2. System converts list into a stream
 *  3. groupingBy() collector is applied
 *  4. Bogies are grouped into a Map
 *  5. Grouped result is displayed
 *  6. Program continues
 */
public class UseCase9GroupByType {

    // -----------------------------------------------------------------------
    // Bogie class
    // -----------------------------------------------------------------------
    static class Bogie {
        String name;
        String type;   // Category: "Passenger", "NonPassenger", "Goods"
        int capacity;

        Bogie(String name, String type, int capacity) {
            this.name = name;
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " (capacity=" + capacity + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC9 - Group Bogies by Type\n");

        // Step 1: Create a list of Bogie objects
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper-1",   "Passenger",    72));
        bogies.add(new Bogie("Sleeper-2",   "Passenger",    72));
        bogies.add(new Bogie("AC Chair-1",  "Passenger",    64));
        bogies.add(new Bogie("First Class", "Passenger",    18));
        bogies.add(new Bogie("Engine",      "NonPassenger",  0));
        bogies.add(new Bogie("Pantry Car",  "NonPassenger",  0));
        bogies.add(new Bogie("Guard Van",   "NonPassenger",  8));
        bogies.add(new Bogie("Coal Wagon",  "Goods",         0));
        bogies.add(new Bogie("Oil Tanker",  "Goods",         0));

        // Step 2 & 3: Convert to stream and apply Collectors.groupingBy()
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(bogie -> bogie.type));

        // Step 4 & 5: Display grouped results
        System.out.println("Bogies grouped by type:");
        System.out.println("=".repeat(40));
        for (Map.Entry<String, List<Bogie>> entry : grouped.entrySet()) {
            System.out.println("\n[" + entry.getKey() + "] — "
                    + entry.getValue().size() + " bogie(s):");
            for (Bogie b : entry.getValue()) {
                System.out.println("    -> " + b);
            }
        }

        System.out.println("\n" + "=".repeat(40));
        System.out.println("Total groups: " + grouped.size());
        System.out.println("Total bogies: " + bogies.size());

        // Bonus: Count per group using Collectors.counting()
        System.out.println("\nCount per group:");
        Map<String, Long> countPerGroup = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.type, Collectors.counting()));
        countPerGroup.forEach((type, count) ->
                System.out.println("  " + type + ": " + count));

        System.out.println("\nProgram continues...");
    }
}
