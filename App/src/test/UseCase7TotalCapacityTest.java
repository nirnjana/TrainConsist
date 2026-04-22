import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC7 - Calculate Total Passenger Capacity
 */
public class UseCase7TotalCapacityTest {

    @BeforeEach
    void setUp() {
        UseCase7TotalCapacity.bogies.clear();
        UseCase7TotalCapacity.addBogie("Engine-1", "Locomotive", 0);
        UseCase7TotalCapacity.addBogie("Coach-A", "AC Sleeper", 72);
        UseCase7TotalCapacity.addBogie("Coach-B", "General", 90);
    }

    @Test
    @DisplayName("TC01 - Total capacity should be sum of all bogies")
    void testTotalCapacity() {
        assertEquals(162, UseCase7TotalCapacity.calculateTotalCapacity(),
                "0 + 72 + 90 = 162");
    }

    @Test
    @DisplayName("TC02 - Empty consist capacity is 0")
    void testEmptyCapacity() {
        UseCase7TotalCapacity.bogies.clear();
        assertEquals(0, UseCase7TotalCapacity.calculateTotalCapacity());
    }
}
