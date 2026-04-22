import java.util.LinkedList;

/**
 * UC4 - Maintain Ordered Bogie Consist (LinkedList)
 *
 * Goal: Maintain the physical sequence of train bogies using a LinkedList,
 *       supporting efficient insertion and deletion at any position.
 *
 * Key Concepts:
 *  - LinkedList        : A doubly linked list implementation of the List interface;
 *                        elements are connected using node references (not array indexes)
 *  - Node Structure    : Each element holds data + links to previous and next nodes
 *  - addFirst()        : Attaches a bogie at the beginning of the train (head)
 *  - addLast()         : Attaches a bogie at the end of the train (tail)
 *  - add(index, elem)  : Inserts a bogie in the middle of the consist
 *  - removeFirst()     : Detaches the head bogie
 *  - removeLast()      : Detaches the tail bogie
 *  - Order Preservation: Maintains the physical sequence of the train
 *
 * Flow:
 *  1. Create a LinkedList<String> for the consist
 *  2. Add bogies: Engine, Sleeper, AC, Cargo, Guard
 *  3. Insert a Pantry Car at position 2 (between Engine and Sleeper)
 *  4. Remove the first bogie (Engine) and the last bogie (Guard)
 *  5. Display the final ordered train consist
 */
public class UseCase4LinkedListConsist {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC4 - Maintain Ordered Bogie Consist Using LinkedList\n");

        // Step 1: Create a LinkedList<String> for the consist
        LinkedList<String> consist = new LinkedList<>();

        // Step 2: Add bogies using addFirst() and addLast()
        consist.addLast("Engine");   // Head of the train
        consist.addLast("Sleeper");
        consist.addLast("AC");
        consist.addLast("Cargo");
        consist.addLast("Guard");    // Tail of the train

        System.out.println("Initial consist:");
        System.out.println(consist);

        // Step 3: Insert 'Pantry Car' at index 2 (between Engine and Sleeper)
        consist.add(2, "Pantry Car");
        System.out.println("\nAfter inserting 'Pantry Car' at position 2:");
        System.out.println(consist);

        // Step 4a: Remove the first bogie using removeFirst()
        String removedFirst = consist.removeFirst();
        System.out.println("\nRemoved first bogie: " + removedFirst);

        // Step 4b: Remove the last bogie using removeLast()
        String removedLast = consist.removeLast();
        System.out.println("Removed last bogie : " + removedLast);

        // Step 5: Display final ordered train consist
        System.out.println("\nFinal ordered train consist:");
        for (int i = 0; i < consist.size(); i++) {
            System.out.println("  Position " + (i + 1) + ": " + consist.get(i));
        }
        System.out.println("Total bogies: " + consist.size());

        System.out.println("\nProgram continues...");
    }
}
