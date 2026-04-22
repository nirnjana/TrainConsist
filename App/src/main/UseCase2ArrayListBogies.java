import java.util.ArrayList;

/**
 * UC2 - Manage Passenger Bogies Using ArrayList
 *
 * Goal: Allow dynamic insertion and removal of passenger bogies using ArrayList.
 *
 * Key Concepts:
 *  - ArrayList  : Resizable collection allowing insertion and deletion at runtime
 *  - add()      : Inserts elements into the list
 *  - remove()   : Deletes elements from the list
 *  - contains() : Checks whether a given element exists in the list
 *  - Insertion Order Preservation : ArrayList maintains the order elements are added
 *  - CRUD Operations : Create, Read, Update, Delete on collections
 *
 * Flow:
 *  1. User runs program
 *  2. Passenger bogies are added
 *  3. Bogies are displayed
 *  4. A bogie is removed
 *  5. Existence is checked
 *  6. Program continues
 */
public class UseCase2ArrayListBogies {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC2 - Manage Passenger Bogies Using ArrayList\n");

        // Step 1: Create an ArrayList<String> for passenger bogies
        ArrayList<String> bogies = new ArrayList<>();

        // Step 2: Add bogies using add()
        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("First Class");

        // Step 3: Print the list after insertion
        System.out.println("Bogies after insertion:");
        System.out.println(bogies);
        System.out.println("Total bogies: " + bogies.size());

        // Step 4: Remove one bogie using remove()
        System.out.println("\nRemoving 'AC Chair'...");
        bogies.remove("AC Chair");

        System.out.println("Bogies after removal:");
        System.out.println(bogies);

        // Step 5: Use contains() to check for a specific bogie
        System.out.println("\nChecking existence:");
        System.out.println("Contains 'Sleeper'   : " + bogies.contains("Sleeper"));
        System.out.println("Contains 'AC Chair'  : " + bogies.contains("AC Chair"));
        System.out.println("Contains 'First Class': " + bogies.contains("First Class"));

        // Step 6: Program continues
        System.out.println("\nProgram continues...");
    }
}
