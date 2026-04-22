import java.util.ArrayList;
import java.util.List;

/**
 * UC2 - Add Bogies to Train Consist
 * Goal: Allow user to add bogies to the train consist and display the updated list.
 */
public class UseCase2AddBogies {

    // Shared bogie list across methods
    static List<String> bogies = new ArrayList<>();

    public static void addBogie(String bogieName) {
        bogies.add(bogieName);
        System.out.println("Bogie added: " + bogieName);
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
        System.out.println("UC2 - Add Bogies to Train Consist");

        addBogie("Engine-1");
        addBogie("Coach-A");
        addBogie("Coach-B");
        addBogie("Pantry-Car");
        addBogie("Guard-Van");

        displayConsist();
    }
}
