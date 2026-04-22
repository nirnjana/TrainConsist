import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Test class for UC6 - Map Bogie to Capacity Using HashMap
 */
public class UseCase6HashMapCapacityTest {

    private Map<String, Integer> bogieCapacity;

    @BeforeEach
    void setUp() {
        bogieCapacity = new HashMap<>();
        bogieCapacity.put("Sleeper",     72);
        bogieCapacity.put("AC Chair",    64);
        bogieCapacity.put("First Class", 18);
        bogieCapacity.put("Guard Van",   8);
    }

    @Test
    @DisplayName("TC01 - Map should contain 4 entries after setup")
    void testInitialSize() {
        assertEquals(4, bogieCapacity.size(),
                "HashMap should have 4 entries.");
    }

    @Test
    @DisplayName("TC02 - get() returns correct capacity for Sleeper")
    void testGetSleeper() {
        assertEquals(72, bogieCapacity.get("Sleeper"),
                "Sleeper capacity should be 72.");
    }

    @Test
    @DisplayName("TC03 - get() returns correct capacity for First Class")
    void testGetFirstClass() {
        assertEquals(18, bogieCapacity.get("First Class"),
                "First Class capacity should be 18.");
    }

    @Test
    @DisplayName("TC04 - get() returns null for non-existent key")
    void testGetNonExistentKey() {
        assertNull(bogieCapacity.get("Dining Car"),
                "Non-existent key should return null.");
    }

    @Test
    @DisplayName("TC05 - containsKey() returns true for existing bogie")
    void testContainsKeyExisting() {
        assertTrue(bogieCapacity.containsKey("AC Chair"));
    }

    @Test
    @DisplayName("TC06 - containsKey() returns false for missing bogie")
    void testContainsKeyMissing() {
        assertFalse(bogieCapacity.containsKey("Pantry Car"));
    }

    @Test
    @DisplayName("TC07 - put() overwrites existing value for same key")
    void testPutOverwrites() {
        bogieCapacity.put("Sleeper", 80); // upgrade capacity
        assertEquals(80, bogieCapacity.get("Sleeper"),
                "put() should overwrite the existing value.");
        assertEquals(4, bogieCapacity.size(),
                "Size should not change when overwriting.");
    }

    @Test
    @DisplayName("TC08 - put() adds new entry and increases size")
    void testPutNewEntry() {
        bogieCapacity.put("Pantry Car", 0);
        assertEquals(5, bogieCapacity.size(),
                "Size should increase to 5 after adding new entry.");
        assertEquals(0, bogieCapacity.get("Pantry Car"));
    }

    @Test
    @DisplayName("TC09 - entrySet() has same size as map")
    void testEntrySetSize() {
        assertEquals(bogieCapacity.size(), bogieCapacity.entrySet().size(),
                "entrySet() should return same number of entries as size().");
    }

    @Test
    @DisplayName("TC10 - Map starts empty before any put()")
    void testEmptyMap() {
        Map<String, Integer> emptyMap = new HashMap<>();
        assertEquals(0, emptyMap.size());
        assertTrue(emptyMap.isEmpty());
    }
}
