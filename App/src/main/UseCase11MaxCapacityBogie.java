import java.util.ArrayList;
import java.util.List;

/**
 * UC11 - Find Bogie with Maximum Capacity
 * Goal: Identify and display the bogie with the highest passenger capacity.
 */
public class UseCase11MaxCapacityBogie {

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
     * Finds and returns the bogie with the maximum capacity.
     * Returns null if the consist is empty.
     *
     * @return Bogie with highest capacity, or null
     */
    public Bogie findMaxCapacityBogie() {
        if (consist.isEmpty()) return null;
        Bogie maxBogie = consist.get(0);
        for (Bogie b : consist) {
            if (b.capacity > maxBogie.capacity) {
                maxBogie = b;
            }
        }
        return maxBogie;
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC11 - Find Bogie with Maximum Capacity\n");

        UseCase11MaxCapacityBogie mgmt = new UseCase11MaxCapacityBogie();
        mgmt.addBogie("B001", "Locomotive", 0);
        mgmt.addBogie("B002", "AC Sleeper", 72);
        mgmt.addBogie("B003", "General", 90);
        mgmt.addBogie("B004", "First Class", 54);
        mgmt.addBogie("B005", "Guard Van", 8);

        Bogie maxBogie = mgmt.findMaxCapacityBogie();
        if (maxBogie != null) {
            System.out.println("Bogie with Maximum Capacity: " + maxBogie);
        } else {
            System.out.println("Consist is empty.");
        }
    }
}
