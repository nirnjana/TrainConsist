import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC5 - Search for a Bogie
 */
public class UseCase5SearchBogieTest {

    @BeforeEach
    void setUp() {
        UseCase5SearchBogie.bogies.clear();
        UseCase5SearchBogie.addBogie("Engine-1", "Locomotive", 0);
        UseCase5SearchBogie.addBogie("Coach-A", "AC Sleeper", 72);
    }

    @Test
    @DisplayName("TC01 - Searching for existing bogie returns true")
    void testSearchFound() {
        assertTrue(UseCase5SearchBogie.searchBogie("Coach-A"));
    }

    @Test
    @DisplayName("TC02 - Searching for missing bogie returns false")
    void testSearchNotFound() {
        assertFalse(UseCase5SearchBogie.searchBogie("Guard-Van"));
    }
}
