import java.util.ArrayList;
import java.util.List;

/**
 * UC8 - Train Consist Management
 *
 * Goal: Provide a complete train consist management system that supports:
 *  - Adding bogies to the consist
 *  - Removing bogies from the consist
 *  - Searching for a bogie by name
 *  - Updating bogie information
 *  - Displaying the full consist with total passenger capacity
 *
 * Key Concepts Used:
 * - ArrayList and List interface for dynamic data storage
 * - Methods with return types and parameters
 * - Enhanced for-loop for iteration
 * - Object-Oriented encapsulation using inner class
 * - Boolean return type for search/removal success indication
 * - Accumulator pattern for calculating total capacity
 */
public class UseCase8TrainConsistMgmt {

    // -----------------------------------------------------------------------
    // Inner class: Bogie
    // Represents a single bogie (rail car) in the train consist.
    // -----------------------------------------------------------------------
    static class Bogie {
        String bogieId;   // Unique identifier e.g. "B001"
        String type;      // Type e.g. "AC Sleeper", "General", "Locomotive"
        int capacity;     // Passenger capacity (0 for non-passenger cars)

        /**
         * Constructor to initialize a Bogie object.
         *
         * @param bogieId  Unique bogie identifier
         * @param type     Type of bogie
         * @param capacity Passenger capacity
         */
        Bogie(String bogieId, String type, int capacity) {
            this.bogieId = bogieId;
            this.type = type;
            this.capacity = capacity;
        }

        /**
         * Returns a formatted string representation of the bogie.
         */
        @Override
        public String toString() {
            return "[" + bogieId + "] Type: " + type + " | Capacity: " + capacity;
        }
    }

    // -----------------------------------------------------------------------
    // Train Consist — the main list of bogies
    // -----------------------------------------------------------------------
    private List<Bogie> consist;

    /**
     * Constructor — initializes the consist as an empty ArrayList.
     */
    public UseCase8TrainConsistMgmt() {
        this.consist = new ArrayList<>();
    }

    // -----------------------------------------------------------------------
    // Method: addBogie
    // Adds a new bogie to the train consist.
    // -----------------------------------------------------------------------

    /**
     * Adds a bogie to the train consist.
     *
     * @param bogieId  Unique bogie identifier
     * @param type     Type of bogie
     * @param capacity Passenger capacity
     */
    public void addBogie(String bogieId, String type, int capacity) {
        Bogie newBogie = new Bogie(bogieId, type, capacity);
        consist.add(newBogie);
        System.out.println("✔ Bogie added: " + newBogie);
    }

    // -----------------------------------------------------------------------
    // Method: removeBogie
    // Removes a bogie from the consist by bogieId.
    // Returns true if removed, false if not found.
    // -----------------------------------------------------------------------

    /**
     * Removes a bogie from the consist by its ID.
     *
     * @param bogieId The ID of the bogie to remove
     * @return true if removed successfully, false if not found
     */
    public boolean removeBogie(String bogieId) {
        for (Bogie b : consist) {
            if (b.bogieId.equalsIgnoreCase(bogieId)) {
                consist.remove(b);
                System.out.println("✔ Bogie removed: " + bogieId);
                return true;
            }
        }
        System.out.println("✘ Bogie not found: " + bogieId);
        return false;
    }

    // -----------------------------------------------------------------------
    // Method: searchBogie
    // Searches for a bogie by ID and returns it (or null if not found).
    // -----------------------------------------------------------------------

    /**
     * Searches for a bogie by its ID.
     *
     * @param bogieId The ID of the bogie to search for
     * @return The Bogie object if found, null otherwise
     */
    public Bogie searchBogie(String bogieId) {
        for (Bogie b : consist) {
            if (b.bogieId.equalsIgnoreCase(bogieId)) {
                System.out.println("✔ Bogie found: " + b);
                return b;
            }
        }
        System.out.println("✘ Bogie not found: " + bogieId);
        return null;
    }

    // -----------------------------------------------------------------------
    // Method: updateBogie
    // Updates the type and capacity of an existing bogie by ID.
    // Returns true if updated, false if not found.
    // -----------------------------------------------------------------------

    /**
     * Updates an existing bogie's type and capacity.
     *
     * @param bogieId     The ID of the bogie to update
     * @param newType     New type to assign
     * @param newCapacity New passenger capacity
     * @return true if updated, false if not found
     */
    public boolean updateBogie(String bogieId, String newType, int newCapacity) {
        for (Bogie b : consist) {
            if (b.bogieId.equalsIgnoreCase(bogieId)) {
                b.type = newType;
                b.capacity = newCapacity;
                System.out.println("✔ Bogie updated: " + b);
                return true;
            }
        }
        System.out.println("✘ Bogie not found for update: " + bogieId);
        return false;
    }

    // -----------------------------------------------------------------------
    // Method: getTotalCapacity
    // Calculates and returns the total passenger capacity of the consist.
    // -----------------------------------------------------------------------

    /**
     * Calculates the total passenger capacity across all bogies.
     *
     * @return Total capacity as an integer
     */
    public int getTotalCapacity() {
        int total = 0;
        for (Bogie b : consist) {
            total += b.capacity;
        }
        return total;
    }

    // -----------------------------------------------------------------------
    // Method: getBogieCount
    // Returns the number of bogies currently in the consist.
    // -----------------------------------------------------------------------

    /**
     * Returns the number of bogies in the consist.
     *
     * @return Bogie count
     */
    public int getBogieCount() {
        return consist.size();
    }

    // -----------------------------------------------------------------------
    // Method: displayConsist
    // Prints the full consist summary to the console.
    // -----------------------------------------------------------------------

    /**
     * Displays all bogies in the consist along with the summary.
     */
    public void displayConsist() {
        System.out.println("\n========================================");
        System.out.println("       TRAIN CONSIST SUMMARY            ");
        System.out.println("========================================");
        if (consist.isEmpty()) {
            System.out.println("  No bogies in the consist.");
        } else {
            for (int i = 0; i < consist.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + consist.get(i));
            }
        }
        System.out.println("----------------------------------------");
        System.out.println("  Total Bogies   : " + getBogieCount());
        System.out.println("  Total Capacity : " + getTotalCapacity() + " passengers");
        System.out.println("========================================\n");
    }

    // -----------------------------------------------------------------------
    // main() — Entry point demonstrating all UC8 operations
    // -----------------------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC8 - Full Train Consist Management\n");

        // Create a new train consist manager
        UseCase8TrainConsistMgmt trainMgmt = new UseCase8TrainConsistMgmt();

        // --- Add Bogies ---
        System.out.println("--- Adding Bogies ---");
        trainMgmt.addBogie("B001", "Locomotive", 0);
        trainMgmt.addBogie("B002", "AC Sleeper", 72);
        trainMgmt.addBogie("B003", "AC Sleeper", 72);
        trainMgmt.addBogie("B004", "General", 90);
        trainMgmt.addBogie("B005", "General", 90);
        trainMgmt.addBogie("B006", "Pantry Car", 0);
        trainMgmt.addBogie("B007", "Guard Van", 8);

        // Display full consist
        trainMgmt.displayConsist();

        // --- Search for a Bogie ---
        System.out.println("--- Searching for Bogies ---");
        trainMgmt.searchBogie("B003");
        trainMgmt.searchBogie("B010");  // Not found

        // --- Update a Bogie ---
        System.out.println("\n--- Updating Bogie B004 ---");
        trainMgmt.updateBogie("B004", "First Class", 54);
        trainMgmt.updateBogie("B099", "Luxury", 30);  // Not found

        // --- Remove a Bogie ---
        System.out.println("\n--- Removing Bogie B006 ---");
        trainMgmt.removeBogie("B006");
        trainMgmt.removeBogie("B010");  // Not found

        // --- Final Consist Display ---
        System.out.println("--- Final Consist ---");
        trainMgmt.displayConsist();
    }
}
