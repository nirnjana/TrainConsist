import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC2 - Add Bogies to Train Consist
 */
public class UseCase2AddBogiesTest {

    @Test
    @DisplayName("TC01 - Adding a bogie increases count by 1")
    void testAddBogie() {
        UseCase2AddBogies.bogies.clear();
        UseCase2AddBogies.addBogie("Engine-1");
        assertEquals(1, UseCase2AddBogies.bogies.size(), "Count should be 1 after adding one bogie.");
    }

    @Test
    @DisplayName("TC02 - Added bogie name should match")
    void testBogieName() {
        UseCase2AddBogies.bogies.clear();
        UseCase2AddBogies.addBogie("Coach-A");
        assertEquals("Coach-A", UseCase2AddBogies.bogies.get(0), "Bogie name should match.");
    }
}
