import java.util.ArrayList;
import java.util.List;

/**
 * UC6 - Update Bogie Information
 * Goal: Update the details (type or capacity) of an existing bogie in the consist.
 */
public class UseCase6UpdateBogie {

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

    public static boolean updateBogie(String name, String newType, int newCapacity) {
        for (Bogie b : bogies) {
            if (b.name.equalsIgnoreCase(name)) {
                b.type = newType;
                b.capacity = newCapacity;
                System.out.println("Bogie updated: " + b);
                return true;
            }
        }
        System.out.println("Bogie not found: " + name);
        return false;
    }

    public static void displayAll() {
        System.out.println("\n=== Train Consist ===");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC6 - Update Bogie Information");

        addBogie("Engine-1", "Locomotive", 0);
        addBogie("Coach-A", "AC Sleeper", 72);
        addBogie("Coach-B", "General", 90);

        displayAll();

        System.out.println("\nUpdating Coach-A to First Class with capacity 54...");
        updateBogie("Coach-A", "First Class", 54);

        System.out.println("\nAttempting to update non-existent Dining-Car...");
        updateBogie("Dining-Car", "Pantry", 0);

        displayAll();
    }
}
