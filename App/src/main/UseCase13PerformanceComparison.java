import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UC13 - Performance Comparison (Loops vs Streams)
 *
 * Goal: Compare performance of loop-based logic versus stream-based logic
 *       using time measurement.
 *
 * Key Concepts:
 *  - System.nanoTime()    : High-resolution timer for measuring elapsed nanoseconds
 *  - For-loop filter      : Traditional imperative approach using an if-statement
 *  - Stream filter        : Declarative approach using the Stream API
 *  - Elapsed Time         : endTime - startTime in nanoseconds → convert to ms
 *  - Performance Analysis : Understanding trade-offs between readability and speed
 *
 * Flow:
 *  1. User prepares a collection of bogies
 *  2. System records start time using System.nanoTime()
 *  3. Filtering is performed using a loop or stream
 *  4. System records end time
 *  5. Elapsed time is calculated
 *  6. Execution time is displayed
 *  7. Program continues
 */
public class UseCase13PerformanceComparison {

    // -----------------------------------------------------------------------
    // Bogie class
    // -----------------------------------------------------------------------
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    /**
     * Filters bogies with capacity > threshold using a traditional for-loop.
     *
     * @param bogies    Input list
     * @param threshold Minimum capacity
     * @return Filtered list
     */
    public static List<Bogie> filterWithLoop(List<Bogie> bogies, int threshold) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > threshold) {
                result.add(b);
            }
        }
        return result;
    }

    /**
     * Filters bogies with capacity > threshold using Stream API.
     *
     * @param bogies    Input list
     * @param threshold Minimum capacity
     * @return Filtered list
     */
    public static List<Bogie> filterWithStream(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC13 - Performance Comparison: Loops vs Streams\n");

        // Step 1: Prepare a large collection of bogies
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 1; i <= 100_000; i++) {
            bogies.add(new Bogie("Bogie-" + i, i % 100)); // capacities 0–99
        }
        System.out.println("Dataset size: " + bogies.size() + " bogies");
        int threshold = 50;
        System.out.println("Filter condition: capacity > " + threshold + "\n");

        // --- Loop-based filtering ---
        long loopStart = System.nanoTime();
        List<Bogie> loopResult = filterWithLoop(bogies, threshold);
        long loopEnd = System.nanoTime();
        long loopTime = loopEnd - loopStart;

        System.out.println("For-Loop Method:");
        System.out.println("  Result count  : " + loopResult.size());
        System.out.println("  Time taken    : " + loopTime + " ns ("
                + (loopTime / 1_000_000.0) + " ms)");

        // --- Stream-based filtering ---
        long streamStart = System.nanoTime();
        List<Bogie> streamResult = filterWithStream(bogies, threshold);
        long streamEnd = System.nanoTime();
        long streamTime = streamEnd - streamStart;

        System.out.println("\nStream API Method:");
        System.out.println("  Result count  : " + streamResult.size());
        System.out.println("  Time taken    : " + streamTime + " ns ("
                + (streamTime / 1_000_000.0) + " ms)");

        // --- Comparison Summary ---
        System.out.println("\n--- Comparison Summary ---");
        System.out.println("Both methods produced the same result: "
                + (loopResult.size() == streamResult.size()));
        System.out.println("Loop  time: " + loopTime   + " ns");
        System.out.println("Stream time: " + streamTime + " ns");

        System.out.println("\nProgram continues...");
    }
}
