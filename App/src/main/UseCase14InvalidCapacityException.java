/**
 * UC14 - Handle Invalid Bogie Capacity (Custom Exception)
 *
 * Goal: Prevent invalid passenger bogies from being added to the train
 *       by enforcing capacity rules using a custom exception.
 *
 * Key Concepts:
 *  - Custom Exception  : A user-defined class extending RuntimeException
 *  - throw             : Manually throws an exception when a rule is violated
 *  - try-catch         : Wraps risky code; catches and handles the exception
 *  - Validation Logic  : Business rule: capacity must be > 0 for passenger bogies
 *  - Defensive Coding  : Stop bad data at the point of entry, not later
 *
 * Rules:
 *  - A passenger bogie MUST have capacity > 0
 *  - If capacity ≤ 0, InvalidCapacityException is thrown
 *
 * Flow:
 *  1. User attempts to create a passenger bogie
 *  2. System validates capacity
 *  3. If capacity ≤ 0 → custom exception thrown
 *  4. If valid → bogie created successfully
 *  5. System continues safely
 */
public class UseCase14InvalidCapacityException {

    // -----------------------------------------------------------------------
    // Custom Exception: InvalidCapacityException
    // -----------------------------------------------------------------------

    /**
     * Thrown when a passenger bogie is created with a capacity ≤ 0.
     */
    static class InvalidCapacityException extends RuntimeException {
        private final int invalidCapacity;

        public InvalidCapacityException(int capacity) {
            super("Invalid capacity: " + capacity
                    + ". Passenger bogie capacity must be greater than 0.");
            this.invalidCapacity = capacity;
        }

        public int getInvalidCapacity() {
            return invalidCapacity;
        }
    }

    // -----------------------------------------------------------------------
    // PassengerBogie class — validates capacity in constructor
    // -----------------------------------------------------------------------
    static class PassengerBogie {
        String name;
        int capacity;

        /**
         * Creates a PassengerBogie. Throws InvalidCapacityException if capacity ≤ 0.
         *
         * @param name     Bogie name
         * @param capacity Seating capacity (must be > 0)
         * @throws InvalidCapacityException if capacity ≤ 0
         */
        PassengerBogie(String name, int capacity) {
            if (capacity <= 0) {
                throw new InvalidCapacityException(capacity);
            }
            this.name     = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " (" + capacity + " seats)";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC14 - Handle Invalid Bogie Capacity\n");

        // --- Test 1: Valid bogie ---
        System.out.println("Creating valid bogie (capacity=72):");
        try {
            PassengerBogie validBogie = new PassengerBogie("Sleeper", 72);
            System.out.println("  ✔ Created: " + validBogie);
        } catch (InvalidCapacityException e) {
            System.out.println("  ✘ Error: " + e.getMessage());
        }

        // --- Test 2: Invalid capacity = 0 ---
        System.out.println("\nCreating bogie with capacity=0:");
        try {
            PassengerBogie zeroBogie = new PassengerBogie("Ghost Car", 0);
            System.out.println("  ✔ Created: " + zeroBogie);
        } catch (InvalidCapacityException e) {
            System.out.println("  ✘ Error caught: " + e.getMessage());
            System.out.println("  Invalid value was: " + e.getInvalidCapacity());
        }

        // --- Test 3: Invalid capacity = negative ---
        System.out.println("\nCreating bogie with capacity=-10:");
        try {
            PassengerBogie negBogie = new PassengerBogie("Phantom", -10);
            System.out.println("  ✔ Created: " + negBogie);
        } catch (InvalidCapacityException e) {
            System.out.println("  ✘ Error caught: " + e.getMessage());
        }

        System.out.println("\nProgram continues safely after exception handling...");
    }
}
