import java.util.ArrayList;
import java.util.List;

/**
 * UC12 - Count Bogies by Type
 * Goal: Count how many bogies of each type exist in the consist using a Map.
 */
public class UseCase12CountBogiesByType {

    static class Bogie {
        String bogieId;
        String type;
        int capacity;

        Bogie(String bogieId, String type, int capacity) {
            this.bogieId = bogieId;
            this.type = type;
            this.capacity = capacity;
        }
    }

    private List<Bogie> consist = new ArrayList<>();

    public void addBogie(String bogieId, String type, int capacity) {
        consist.add(new Bogie(bogieId, type, capacity));
    }

    /**
     * Counts how many bogies exist for a given type.
     *
     * @param type The bogie type to count
     * @return Count of bogies matching that type
     */
    public int countByType(String type) {
        int count = 0;
        for (Bogie b : consist) {
            if (b.type.equalsIgnoreCase(type)) {
                count++;
            }
        }
        return count;
    }

    public void displayTypeCounts() {
        System.out.println("\n=== Bogie Count by Type ===");
        List<String> counted = new ArrayList<>();
        for (Bogie b : consist) {
            if (!counted.contains(b.type)) {
                System.out.println("Type: " + b.type + " | Count: " + countByType(b.type));
                counted.add(b.type);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC12 - Count Bogies by Type\n");

        UseCase12CountBogiesByType mgmt = new UseCase12CountBogiesByType();
        mgmt.addBogie("B001", "AC Sleeper", 72);
        mgmt.addBogie("B002", "AC Sleeper", 72);
        mgmt.addBogie("B003", "General", 90);
        mgmt.addBogie("B004", "General", 90);
        mgmt.addBogie("B005", "General", 90);
        mgmt.addBogie("B006", "Locomotive", 0);
        mgmt.addBogie("B007", "Guard Van", 8);

        mgmt.displayTypeCounts();
    }
}
