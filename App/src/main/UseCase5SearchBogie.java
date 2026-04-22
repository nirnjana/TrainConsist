import java.util.ArrayList;
import java.util.List;

/**
 * UC5 - Search for a Bogie in the Consist
 * Goal: Search for a specific bogie by name and display its details.
 */
public class UseCase5SearchBogie {

    static class Bogie {
        String name;
        String type;
        int capacity;

        Bogie(String name, String type, int capacity) {
            this.name = name;
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return "Name: " + name + " | Type: " + type + " | Capacity: " + capacity;
        }
    }

    static List<Bogie> bogies = new ArrayList<>();

    public static void addBogie(String name, String type, int capacity) {
        bogies.add(new Bogie(name, type, capacity));
    }

    public static boolean searchBogie(String name) {
        for (Bogie b : bogies) {
            if (b.name.equalsIgnoreCase(name)) {
                System.out.println("Bogie Found: " + b);
                return true;
            }
        }
        System.out.println("Bogie not found: " + name);
        return false;
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC5 - Search for a Bogie");

        addBogie("Engine-1", "Locomotive", 0);
        addBogie("Coach-A", "AC Sleeper", 72);
        addBogie("Coach-B", "General", 90);
        addBogie("Guard-Van", "Guard", 8);

        System.out.println("\nSearching for Coach-A...");
        searchBogie("Coach-A");

        System.out.println("\nSearching for Dining-Car...");
        searchBogie("Dining-Car");
    }
}
