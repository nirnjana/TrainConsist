import java.util.ArrayList;
import java.util.List;

/**
 * UC3 - Remove a Bogie from Train Consist
 * Goal: Allow the user to remove a bogie by name from the consist.
 */
public class UseCase3RemoveBogie {

    static List<String> bogies = new ArrayList<>();

    public static void addBogie(String bogieName) {
        bogies.add(bogieName);
    }

    public static void removeBogie(String bogieName) {
        if (bogies.remove(bogieName)) {
            System.out.println("Bogie removed: " + bogieName);
        } else {
            System.out.println("Bogie not found: " + bogieName);
        }
    }

    public static void displayConsist() {
        System.out.println("\n=== Current Train Consist ===");
        if (bogies.isEmpty()) {
            System.out.println("No bogies in the consist.");
        } else {
            for (int i = 0; i < bogies.size(); i++) {
                System.out.println((i + 1) + ". " + bogies.get(i));
            }
        }
        System.out.println("Total Bogies: " + bogies.size());
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC3 - Remove a Bogie from Train Consist");

        addBogie("Engine-1");
        addBogie("Coach-A");
        addBogie("Coach-B");
        addBogie("Guard-Van");

        displayConsist();

        System.out.println("\nRemoving Coach-B...");
        removeBogie("Coach-B");
        removeBogie("Pantry-Car"); // Not present

        displayConsist();
    }
}
