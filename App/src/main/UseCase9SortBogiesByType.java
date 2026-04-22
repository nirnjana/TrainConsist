import java.util.ArrayList;
import java.util.List;

/**
 * UC9 - Sort Bogies by Type
 * Goal: Sort and display the bogies in the consist alphabetically by type.
 */
public class UseCase9SortBogiesByType {

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
     * Sorts the consist alphabetically by bogie type (ascending).
     */
    public void sortByType() {
        consist.sort((a, b) -> a.type.compareToIgnoreCase(b.type));
        System.out.println("Bogies sorted by type.");
    }

    public List<Bogie> getConsist() {
        return consist;
    }

    public void displayConsist() {
        System.out.println("\n=== Sorted Train Consist (by Type) ===");
        for (int i = 0; i < consist.size(); i++) {
            System.out.println((i + 1) + ". " + consist.get(i));
        }
        System.out.println("Total Bogies: " + consist.size());
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC9 - Sort Bogies by Type\n");

        UseCase9SortBogiesByType mgmt = new UseCase9SortBogiesByType();
        mgmt.addBogie("B001", "General", 90);
        mgmt.addBogie("B002", "Locomotive", 0);
        mgmt.addBogie("B003", "AC Sleeper", 72);
        mgmt.addBogie("B004", "Guard Van", 8);
        mgmt.addBogie("B005", "First Class", 54);

        System.out.println("Before Sorting:");
        mgmt.displayConsist();

        mgmt.sortByType();

        System.out.println("After Sorting:");
        mgmt.displayConsist();
    }
}
