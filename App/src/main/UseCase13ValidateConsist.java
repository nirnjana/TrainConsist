import java.util.ArrayList;
import java.util.List;

/**
 * UC13 - Validate Consist Rules
 * Goal: Validate that the train consist follows required rules:
 *       - Must have exactly 1 Locomotive
 *       - Must have at least 1 Guard Van
 *       - Must have at least 1 passenger coach
 */
public class UseCase13ValidateConsist {

    static class Bogie {
        String bogieId;
        String type;
        int capacity;

        Bogie(String bogieId, String type, int capacity) {
            this.bogieId = bogieId;
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return "[" + bogieId + "] Type: " + type + " | Capacity: " + capacity;
        }
    }

    private List<Bogie> consist = new ArrayList<>();

    public void addBogie(String bogieId, String type, int capacity) {
        consist.add(new Bogie(bogieId, type, capacity));
    }

    /**
     * Validates the consist based on the defined rules.
     *
     * @return true if valid, false otherwise
     */
    public boolean validateConsist() {
        int locomotiveCount = 0;
        int guardVanCount = 0;
        int passengerCount = 0;

        for (Bogie b : consist) {
            if (b.type.equalsIgnoreCase("Locomotive")) locomotiveCount++;
            if (b.type.equalsIgnoreCase("Guard Van")) guardVanCount++;
            if (b.capacity > 0) passengerCount++;
        }

        System.out.println("\n=== Consist Validation Report ===");
        System.out.println("Locomotives  : " + locomotiveCount + (locomotiveCount == 1 ? " ✔" : " ✘ (Must be exactly 1)"));
        System.out.println("Guard Vans   : " + guardVanCount + (guardVanCount >= 1 ? " ✔" : " ✘ (Must be at least 1)"));
        System.out.println("Passenger Cars: " + passengerCount + (passengerCount >= 1 ? " ✔" : " ✘ (Must be at least 1)"));

        boolean valid = (locomotiveCount == 1) && (guardVanCount >= 1) && (passengerCount >= 1);
        System.out.println("Status: " + (valid ? "VALID ✔" : "INVALID ✘"));
        return valid;
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC13 - Validate Consist Rules\n");

        UseCase13ValidateConsist validConsist = new UseCase13ValidateConsist();
        validConsist.addBogie("B001", "Locomotive", 0);
        validConsist.addBogie("B002", "AC Sleeper", 72);
        validConsist.addBogie("B003", "General", 90);
        validConsist.addBogie("B004", "Guard Van", 8);
        System.out.println("Test 1 - Valid Consist:");
        validConsist.validateConsist();

        System.out.println("\nTest 2 - Invalid Consist (no Guard Van):");
        UseCase13ValidateConsist invalidConsist = new UseCase13ValidateConsist();
        invalidConsist.addBogie("B001", "Locomotive", 0);
        invalidConsist.addBogie("B002", "AC Sleeper", 72);
        invalidConsist.validateConsist();
    }
}
