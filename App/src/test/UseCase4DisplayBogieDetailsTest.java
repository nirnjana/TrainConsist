import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC4 - Display Bogie Details
 */
public class UseCase4DisplayBogieDetailsTest {

    @BeforeEach
    void setUp() {
        UseCase4DisplayBogieDetails.bogies.clear();
    }

    @Test
    @DisplayName("TC01 - Added bogie should exist in list")
    void testAddBogie() {
        UseCase4DisplayBogieDetails.addBogie("Engine-1", "Locomotive", 0);
        assertEquals(1, UseCase4DisplayBogieDetails.bogies.size());
    }

    @Test
    @DisplayName("TC02 - Bogie capacity should match")
    void testBogieCapacity() {
        UseCase4DisplayBogieDetails.addBogie("Coach-A", "AC Sleeper", 72);
        assertEquals(72, UseCase4DisplayBogieDetails.bogies.get(0).capacity);
    }
}
