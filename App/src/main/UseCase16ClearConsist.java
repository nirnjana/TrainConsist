import java.util.ArrayList;
import java.util.List;

/**
 * UC16 - Clear the Entire Train Consist
 * Goal: Remove all bogies from the consist and reset the train.
 */
public class UseCase16ClearConsist {

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
     * Clears all bogies from the consist.
     */
    public void clearConsist() {
        consist.clear();
        System.out.println("All bogies removed. Consist is now empty.");
    }

    public boolean isEmpty() {
        return consist.isEmpty();
    }

    public int getBogieCount() {
        return consist.size();
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC16 - Clear the Entire Train Consist\n");

        UseCase16ClearConsist mgmt = new UseCase16ClearConsist();
        mgmt.addBogie("B001", "Locomotive", 0);
        mgmt.addBogie("B002", "AC Sleeper", 72);
        mgmt.addBogie("B003", "General", 90);

        System.out.println("Before clear - Bogie Count: " + mgmt.getBogieCount());
        mgmt.clearConsist();
        System.out.println("After clear  - Bogie Count: " + mgmt.getBogieCount());
    }
}
