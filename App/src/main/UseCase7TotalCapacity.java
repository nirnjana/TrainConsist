import java.util.ArrayList;
import java.util.List;

/**
 * UC7 - Calculate Total Passenger Capacity
 * Goal: Calculate and display the total passenger capacity of all bogies in the consist.
 */
public class UseCase7TotalCapacity {

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

    public static int calculateTotalCapacity() {
        int total = 0;
        for (Bogie b : bogies) {
            total += b.capacity;
        }
        return total;
    }

    public static void displayAll() {
        System.out.println("\n=== Train Consist ===");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
        System.out.println("Total Passenger Capacity: " + calculateTotalCapacity());
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC7 - Calculate Total Passenger Capacity");

        addBogie("Engine-1", "Locomotive", 0);
        addBogie("Coach-A", "AC Sleeper", 72);
        addBogie("Coach-B", "AC Sleeper", 72);
        addBogie("Coach-C", "General", 90);
        addBogie("Pantry-Car", "Pantry", 0);
        addBogie("Guard-Van", "Guard", 8);

        displayAll();
    }
}
