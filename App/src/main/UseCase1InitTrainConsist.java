import java.util.ArrayList;
import java.util.List;

/**
 * UC1 - Initialize Train and Display Consist Summary
 * Goal: Initialize the Train Consist Management App and display the initial state of the train.
 */
public class UseCase1InitTrainConsist {

    public static void main(String[] args) {

        // Print welcome message
        System.out.println("=== Train Consist Management App ===");
        System.out.println("Initializing train consist...");

        // Initialize an empty List using ArrayList to store bogies
        List<String> bogies = new ArrayList<>();

        // Display initial bogie count using size()
        System.out.println("Initial Bogie Count: " + bogies.size());
        System.out.println("Train consist initialized successfully.");
        System.out.println("Program continues...");
    }
}
