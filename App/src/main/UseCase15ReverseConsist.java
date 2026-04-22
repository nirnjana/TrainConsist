import java.util.ArrayList;
import java.util.List;

/**
 * UC15 - Display Consist in Reverse Order
 * Goal: Display the bogies in the consist in reverse order using a loop.
 */
public class UseCase15ReverseConsist {

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
     * Displays the consist in reverse order (last added first).
     */
    public void displayReverse() {
        System.out.println("\n=== Train Consist (Reverse Order) ===");
        for (int i = consist.size() - 1; i >= 0; i--) {
            System.out.println((consist.size() - i) + ". " + consist.get(i));
        }
        System.out.println("Total Bogies: " + consist.size());
    }

    public int getBogieCount() {
        return consist.size();
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC15 - Display Consist in Reverse Order\n");

        UseCase15ReverseConsist mgmt = new UseCase15ReverseConsist();
        mgmt.addBogie("B001", "Locomotive", 0);
        mgmt.addBogie("B002", "AC Sleeper", 72);
        mgmt.addBogie("B003", "General", 90);
        mgmt.addBogie("B004", "Guard Van", 8);

        mgmt.displayReverse();
    }
}
