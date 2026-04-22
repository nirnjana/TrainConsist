import java.util.ArrayList;
import java.util.List;

/**
 * UC10 - Filter Bogies by Type
 * Goal: Filter and display only bogies of a specific type from the consist.
 */
public class UseCase10FilterBogiesByType {

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
     * Filters bogies by a given type and returns the matching list.
     *
     * @param filterType The type to filter by
     * @return List of matching Bogie objects
     */
    public List<Bogie> filterByType(String filterType) {
        List<Bogie> filtered = new ArrayList<>();
        for (Bogie b : consist) {
            if (b.type.equalsIgnoreCase(filterType)) {
                filtered.add(b);
            }
        }
        return filtered;
    }

    public void displayFiltered(String filterType) {
        List<Bogie> filtered = filterByType(filterType);
        System.out.println("\n=== Bogies of Type: " + filterType + " ===");
        if (filtered.isEmpty()) {
            System.out.println("No bogies found for type: " + filterType);
        } else {
            for (int i = 0; i < filtered.size(); i++) {
                System.out.println((i + 1) + ". " + filtered.get(i));
            }
        }
        System.out.println("Count: " + filtered.size());
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC10 - Filter Bogies by Type\n");

        UseCase10FilterBogiesByType mgmt = new UseCase10FilterBogiesByType();
        mgmt.addBogie("B001", "AC Sleeper", 72);
        mgmt.addBogie("B002", "AC Sleeper", 72);
        mgmt.addBogie("B003", "General", 90);
        mgmt.addBogie("B004", "Locomotive", 0);
        mgmt.addBogie("B005", "General", 90);

        mgmt.displayFiltered("AC Sleeper");
        mgmt.displayFiltered("General");
        mgmt.displayFiltered("Pantry Car");
    }
}
