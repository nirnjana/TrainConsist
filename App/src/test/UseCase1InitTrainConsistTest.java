import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Test class for UC1 - Initialize Train and Display Consist Summary
 */
public class UseCase1InitTrainConsistTest {

    @Test
    @DisplayName("TC01 - Initial bogie list should be empty")
    void testInitialListIsEmpty() {
        List<String> bogies = new ArrayList<>();
        assertTrue(bogies.isEmpty(), "Bogies list should be empty at initialization.");
    }

    @Test
    @DisplayName("TC02 - Initial bogie count should be 0")
    void testInitialBogieCount() {
        List<String> bogies = new ArrayList<>();
        assertEquals(0, bogies.size(), "Initial bogie count should be 0.");
    }
}
