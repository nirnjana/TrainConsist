import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Test class for UC1 - Initialize Train and Display Consist Summary
 */
public class UseCase1InitTrainConsistTest {

    private List<String> bogies;

    @BeforeEach
    void setUp() {
        // Initialize an empty ArrayList — same as the UC1 main flow
        bogies = new ArrayList<>();
    }

    @Test
    @DisplayName("TC01 - Newly initialized ArrayList should be empty")
    void testInitialListIsEmpty() {
        assertTrue(bogies.isEmpty(),
                "The bogie list should be empty right after initialization.");
    }

    @Test
    @DisplayName("TC02 - Initial size() should return 0")
    void testInitialSizeIsZero() {
        assertEquals(0, bogies.size(),
                "size() should return 0 for a newly created ArrayList.");
    }

    @Test
    @DisplayName("TC03 - ArrayList should accept String elements")
    void testListAcceptsStrings() {
        bogies.add("Sleeper");
        assertEquals(1, bogies.size(),
                "After adding one bogie, size should be 1.");
        assertEquals("Sleeper", bogies.get(0),
                "First element should be 'Sleeper'.");
    }

    @Test
    @DisplayName("TC04 - ArrayList preserves insertion order")
    void testListPreservesOrder() {
        bogies.add("Engine");
        bogies.add("Sleeper");
        bogies.add("Guard Van");
        assertEquals("Engine",    bogies.get(0), "First bogie should be Engine.");
        assertEquals("Sleeper",   bogies.get(1), "Second bogie should be Sleeper.");
        assertEquals("Guard Van", bogies.get(2), "Third bogie should be Guard Van.");
    }
}
