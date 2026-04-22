import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC6 - Update Bogie Information
 */
public class UseCase6UpdateBogieTest {

    @BeforeEach
    void setUp() {
        UseCase6UpdateBogie.bogies.clear();
        UseCase6UpdateBogie.addBogie("Coach-A", "General", 90);
    }

    @Test
    @DisplayName("TC01 - Updating existing bogie returns true")
    void testUpdateExisting() {
        assertTrue(UseCase6UpdateBogie.updateBogie("Coach-A", "First Class", 54));
    }

    @Test
    @DisplayName("TC02 - Updating non-existent bogie returns false")
    void testUpdateNonExistent() {
        assertFalse(UseCase6UpdateBogie.updateBogie("Guard-Van", "Guard", 8));
    }

    @Test
    @DisplayName("TC03 - Updated bogie reflects new values")
    void testUpdatedValues() {
        UseCase6UpdateBogie.updateBogie("Coach-A", "First Class", 54);
        UseCase6UpdateBogie.Bogie b = UseCase6UpdateBogie.bogies.get(0);
        assertEquals("First Class", b.type);
        assertEquals(54, b.capacity);
    }
}
