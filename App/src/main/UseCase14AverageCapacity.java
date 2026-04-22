import java.util.ArrayList;
import java.util.List;

/**
 * UC14 - Calculate Average Capacity
 * Goal: Calculate and display the average passenger capacity across all passenger bogies.
 */
public class UseCase14AverageCapacity {

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
     * Calculates average capacity of all passenger bogies (capacity > 0).
     *
     * @return Average capacity as a double, or 0.0 if no passenger bogies
     */
    public double calculateAverageCapacity() {
        int total = 0;
        int count = 0;
        for (Bogie b : consist) {
            if (b.capacity > 0) {
                total += b.capacity;
                count++;
            }
        }
        if (count == 0) return 0.0;
        return (double) total / count;
    }

    public int getBogieCount() {
        return consist.size();
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC14 - Calculate Average Capacity\n");

        UseCase14AverageCapacity mgmt = new UseCase14AverageCapacity();
        mgmt.addBogie("B001", "Locomotive", 0);
        mgmt.addBogie("B002", "AC Sleeper", 72);
        mgmt.addBogie("B003", "General", 90);
        mgmt.addBogie("B004", "First Class", 54);
        mgmt.addBogie("B005", "Guard Van", 8);

        System.out.println("Average Passenger Capacity (excl. non-passenger): "
                + mgmt.calculateAverageCapacity());
    }
}
