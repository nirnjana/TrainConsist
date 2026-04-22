import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC3 - Remove Bogie from Train Consist
 */
public class UseCase3RemoveBogieTest {

    @BeforeEach
    void setUp() {
        UseCase3RemoveBogie.bogies.clear();
        UseCase3RemoveBogie.addBogie("Engine-1");
        UseCase3RemoveBogie.addBogie("Coach-A");
    }

    @Test
    @DisplayName("TC01 - Removing existing bogie reduces count")
    void testRemoveExisting() {
        UseCase3RemoveBogie.removeBogie("Coach-A");
        assertEquals(1, UseCase3RemoveBogie.bogies.size(), "Count should be 1 after removal.");
    }

    @Test
    @DisplayName("TC02 - Removing non-existent bogie keeps count unchanged")
    void testRemoveNonExistent() {
        UseCase3RemoveBogie.removeBogie("Guard-Van");
        assertEquals(2, UseCase3RemoveBogie.bogies.size(), "Count should remain 2.");
    }
}
