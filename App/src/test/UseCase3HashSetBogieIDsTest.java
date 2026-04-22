import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Test class for UC3 - Track Unique Bogie IDs Using HashSet
 */
public class UseCase3HashSetBogieIDsTest {

    private Set<String> bogieIDs;

    @BeforeEach
    void setUp() {
        bogieIDs = new HashSet<>();
        bogieIDs.add("B001");
        bogieIDs.add("B002");
        bogieIDs.add("B003");
    }

    @Test
    @DisplayName("TC01 - HashSet should contain 3 unique IDs after setup")
    void testInitialSize() {
        assertEquals(3, bogieIDs.size(),
                "HashSet should hold 3 unique IDs.");
    }

    @Test
    @DisplayName("TC02 - Adding a duplicate returns false and size stays same")
    void testDuplicateNotAdded() {
        boolean result = bogieIDs.add("B001");
        assertFalse(result, "Adding an existing ID should return false.");
        assertEquals(3, bogieIDs.size(), "Size should remain 3 after duplicate add.");
    }

    @Test
    @DisplayName("TC03 - Adding a new unique ID returns true and increases size")
    void testNewIDAdded() {
        boolean result = bogieIDs.add("B004");
        assertTrue(result, "Adding a new ID should return true.");
        assertEquals(4, bogieIDs.size(), "Size should be 4 after adding B004.");
    }

    @Test
    @DisplayName("TC04 - HashSet contains expected IDs")
    void testContainsIDs() {
        assertTrue(bogieIDs.contains("B001"));
        assertTrue(bogieIDs.contains("B002"));
        assertTrue(bogieIDs.contains("B003"));
    }

    @Test
    @DisplayName("TC05 - HashSet does not contain unAdded IDs")
    void testNotContainsUnaddedID() {
        assertFalse(bogieIDs.contains("B999"),
                "B999 was never added, should not be found.");
    }

    @Test
    @DisplayName("TC06 - Multiple duplicates still yield correct unique count")
    void testMultipleDuplicates() {
        bogieIDs.add("B001");
        bogieIDs.add("B002");
        bogieIDs.add("B001");
        bogieIDs.add("B003");
        // Still only 3 unique IDs
        assertEquals(3, bogieIDs.size(),
                "Repeated duplicates should not increase size beyond 3.");
    }

    @Test
    @DisplayName("TC07 - Empty HashSet has size 0")
    void testEmptyHashSet() {
        Set<String> emptySet = new HashSet<>();
        assertEquals(0, emptySet.size());
        assertTrue(emptySet.isEmpty());
    }
}
