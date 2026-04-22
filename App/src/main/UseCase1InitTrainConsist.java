import java.util.ArrayList;
import java.util.List;

/**
 * UC1 - Initialize Train and Display Consist Summary
 *
 * Goal: Initialize the Train Consist Management App and display the initial state of the train.
 *
 * Key Concepts:
 *  - Class            : Java class as a container for program logic
 *  - main()           : Entry point of the application
 *  - Static keyword   : Allows JVM to invoke main() without creating an object
 *  - ArrayList        : Resizable list from Java Collections Framework
 *  - List Interface   : Abstraction over ArrayList and LinkedList
 *  - System.out.println() : Console output
 *  - Dynamic Init     : Empty collection created, ready to be populated later
 */
public class UseCase1InitTrainConsist {

    public static void main(String[] args) {

        // Step 1: Print welcome message
        System.out.println("=== Train Consist Management App ===");

        // Step 2: Initialize an empty List using ArrayList to store bogies
        // ArrayList is used because the train consist grows dynamically at runtime
        List<String> bogies = new ArrayList<>();

        // Step 3: Display initial bogie count using size()
        System.out.println("Train consist initialized.");
        System.out.println("Initial Bogie Count: " + bogies.size());

        // Step 4: Confirm program continues
        System.out.println("Program continues...");
    }
}
