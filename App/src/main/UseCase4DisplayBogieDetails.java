import java.util.ArrayList;
import java.util.List;

/**
 * UC4 - Display Bogie Details
 * Goal: Display detailed information about each bogie in the consist.
 */
public class UseCase4DisplayBogieDetails {

    // Inner class representing a Bogie with details
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
        System.out.println("Bogie added: " + name);
    }

    public static void displayAll() {
        System.out.println("\n=== Train Consist - Bogie Details ===");
        if (bogies.isEmpty()) {
            System.out.println("No bogies found.");
            return;
        }
        for (int i = 0; i < bogies.size(); i++) {
            System.out.println((i + 1) + ". " + bogies.get(i));
        }
        System.out.println("Total Bogies: " + bogies.size());
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC4 - Display Bogie Details");

        addBogie("Engine-1", "Locomotive", 0);
        addBogie("Coach-A", "AC Sleeper", 72);
        addBogie("Coach-B", "General", 90);
        addBogie("Pantry-Car", "Pantry", 0);
        addBogie("Guard-Van", "Guard", 8);

        displayAll();
    }
}
