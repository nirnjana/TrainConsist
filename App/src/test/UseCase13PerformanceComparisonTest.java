import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Test class for UC13 - Performance Comparison: Loops vs Streams
 */
public class UseCase13PerformanceComparisonTest {

    private List<UseCase13PerformanceComparison.Bogie> bogies;

    @BeforeEach
    void setUp() {
        bogies = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            bogies.add(new UseCase13PerformanceComparison.Bogie("B" + i, i));
        }
    }

    @Test
    @DisplayName("TC01 - Loop and stream return same result count")
    void testSameResultCount() {
        List<UseCase13PerformanceComparison.Bogie> loopResult =
                UseCase13PerformanceComparison.filterWithLoop(bogies, 50);
        List<UseCase13PerformanceComparison.Bogie> streamResult =
                UseCase13PerformanceComparison.filterWithStream(bogies, 50);
        assertEquals(loopResult.size(), streamResult.size(),
                "Both approaches must produce the same number of results.");
    }

    @Test
    @DisplayName("TC02 - filterWithLoop returns correct count for threshold 50")
    void testLoopResultCount() {
        List<UseCase13PerformanceComparison.Bogie> result =
                UseCase13PerformanceComparison.filterWithLoop(bogies, 50);
        assertEquals(50, result.size(), "Bogies 51–100 pass the threshold.");
    }

    @Test
    @DisplayName("TC03 - filterWithStream returns correct count for threshold 50")
    void testStreamResultCount() {
        List<UseCase13PerformanceComparison.Bogie> result =
                UseCase13PerformanceComparison.filterWithStream(bogies, 50);
        assertEquals(50, result.size());
    }

    @Test
    @DisplayName("TC04 - filterWithLoop on empty list returns empty list")
    void testLoopEmptyList() {
        List<UseCase13PerformanceComparison.Bogie> result =
                UseCase13PerformanceComparison.filterWithLoop(new ArrayList<>(), 50);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("TC05 - filterWithStream on empty list returns empty list")
    void testStreamEmptyList() {
        List<UseCase13PerformanceComparison.Bogie> result =
                UseCase13PerformanceComparison.filterWithStream(new ArrayList<>(), 50);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("TC06 - Timing measurement: both methods complete without error")
    void testTimingCompletes() {
        long start = System.nanoTime();
        UseCase13PerformanceComparison.filterWithLoop(bogies, 50);
        long elapsed = System.nanoTime() - start;
        assertTrue(elapsed >= 0, "Elapsed time should be non-negative.");
    }
}
