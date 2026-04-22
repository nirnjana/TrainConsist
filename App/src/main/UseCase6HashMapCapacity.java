import java.util.HashMap;
import java.util.Map;

/**
 * UC6 - Map Bogie to Capacity (HashMap)
 *
 * Goal: Associate each bogie with its seating or load capacity using a key–value mapping.
 *
 * Key Concepts:
 *  - HashMap          : Hash table based Map implementation; stores key–value pairs
 *  - Map Interface    : Represents key→value mappings with unique keys
 *  - put()            : Inserts a key–value pair (bogie name → capacity)
 *  - Key–Value Assoc  : Binds e.g. "Sleeper" to 72 seats
 *  - entrySet()       : View of entire map for iterating keys and values together
 *  - Fast Key Lookup  : Constant-time retrieval using get(key)
 *
 * Flow:
 *  1. User creates a bogie-capacity mapping
 *  2. System stores bogie names as keys and capacities as values
 *  3. Entries are inserted into a HashMap
 *  4. System iterates through the map
 *  5. Capacity details are displayed for each bogie
 *  6. Program continues
 */
public class UseCase6HashMapCapacity {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC6 - Map Bogie to Capacity Using HashMap\n");

        // Step 1: Create a HashMap<String, Integer> — bogie name → capacity
        Map<String, Integer> bogieCapacity = new HashMap<>();

        // Step 2 & 3: Insert entries using put()
        bogieCapacity.put("Engine",      0);   // No passenger capacity
        bogieCapacity.put("Sleeper",     72);  // 72 berths
        bogieCapacity.put("AC Chair",    64);  // 64 seats
        bogieCapacity.put("First Class", 18);  // 18 coupe berths
        bogieCapacity.put("Pantry Car",  0);   // No passenger capacity
        bogieCapacity.put("Guard Van",   8);   // 8 guard seats

        // Step 4 & 5: Iterate using entrySet() and display capacity details
        System.out.println("Bogie Capacity Details:");
        System.out.println("------------------------------------------");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.printf("  %-15s -> %d seats%n",
                    entry.getKey(), entry.getValue());
        }
        System.out.println("------------------------------------------");
        System.out.println("Total bogie types mapped: " + bogieCapacity.size());

        // Demonstrate fast key lookup using get()
        System.out.println("\nFast lookup:");
        System.out.println("Capacity of 'Sleeper'    : "
                + bogieCapacity.get("Sleeper"));
        System.out.println("Capacity of 'First Class': "
                + bogieCapacity.get("First Class"));
        System.out.println("Capacity of 'Guard Van'  : "
                + bogieCapacity.get("Guard Van"));

        // containsKey() check
        System.out.println("\nContains key 'AC Chair': "
                + bogieCapacity.containsKey("AC Chair"));
        System.out.println("Contains key 'Dining Car': "
                + bogieCapacity.containsKey("Dining Car"));

        System.out.println("\nProgram continues...");
    }
}
