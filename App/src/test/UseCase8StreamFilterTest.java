import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Test class for UC8 - Filter Passenger Bogies Using Streams
 *
 * Tests:
 *  - stream().filter() correctly selects elements by condition
 *  - collect() returns a proper List
 *  - Edge cases: no match, all match, empty list
 */
public class UseCase8StreamFilterTest {

    private List<UseCase8StreamFilter.Bogie> bogies;

    @BeforeEach
    void setUp() {
        bogies = new ArrayList<>();
        bogies.add(new UseCase8StreamFilter.Bogie("Engine",      0));
        bogies.add(new UseCase8StreamFilter.Bogie("Sleeper",    72));
        bogies.add(new UseCase8StreamFilter.Bogie("AC Chair",   64));
        bogies.add(new UseCase8StreamFilter.Bogie("First Class",18));
        bogies.add(new UseCase8StreamFilter.Bogie("General",    90));
        bogies.add(new UseCase8StreamFilter.Bogie("Guard Van",   8));
        bogies.add(new UseCase8StreamFilter.Bogie("Pantry Car",  0));
    }

    @Test
    @DisplayName("TC01 - Setup list should have 7 bogies")
    void testInitialListSize() {
        assertEquals(7, bogies.size());
    }

    @Test
    @DisplayName("TC02 - filter(capacity > 50) returns 3 bogies")
    void testFilterCapacityGreaterThan50() {
        List<UseCase8StreamFilter.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 50)
                .collect(Collectors.toList());
        assertEquals(3, result.size(),
                "Sleeper(72), AC Chair(64), General(90) should pass the filter.");
    }

    @Test
    @DisplayName("TC03 - filter(capacity > 50) contains correct bogie names")
    void testFilterResultNames() {
        List<String> names = bogies.stream()
                .filter(b -> b.capacity > 50)
                .map(b -> b.name)
                .collect(Collectors.toList());
        assertTrue(names.contains("Sleeper"),   "Sleeper should be in results.");
        assertTrue(names.contains("AC Chair"),  "AC Chair should be in results.");
        assertTrue(names.contains("General"),   "General should be in results.");
        assertFalse(names.contains("Engine"),   "Engine should NOT be in results.");
    }

    @Test
    @DisplayName("TC04 - filter(capacity == 0) returns 2 non-passenger bogies")
    void testFilterNonPassengerBogies() {
        List<UseCase8StreamFilter.Bogie> result = bogies.stream()
                .filter(b -> b.capacity == 0)
                .collect(Collectors.toList());
        assertEquals(2, result.size(),
                "Engine and Pantry Car have capacity 0.");
    }

    @Test
    @DisplayName("TC05 - filter returns empty list when no elements match")
    void testFilterNoMatch() {
        List<UseCase8StreamFilter.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 1000)
                .collect(Collectors.toList());
        assertTrue(result.isEmpty(),
                "No bogie has capacity > 1000; result should be empty.");
    }

    @Test
    @DisplayName("TC06 - filter returns all elements when all match")
    void testFilterAllMatch() {
        List<UseCase8StreamFilter.Bogie> result = bogies.stream()
                .filter(b -> b.capacity >= 0)  // All capacities are >= 0
                .collect(Collectors.toList());
        assertEquals(7, result.size(),
                "All 7 bogies match capacity >= 0.");
    }

    @Test
    @DisplayName("TC07 - Filtering an empty list returns empty list")
    void testFilterEmptyList() {
        List<UseCase8StreamFilter.Bogie> empty = new ArrayList<>();
        List<UseCase8StreamFilter.Bogie> result = empty.stream()
                .filter(b -> b.capacity > 50)
                .collect(Collectors.toList());
        assertTrue(result.isEmpty(),
                "Filtering an empty list should return empty.");
    }

    @Test
    @DisplayName("TC08 - filter(capacity > 0) excludes only non-passenger bogies")
    void testFilterPassengerOnly() {
        List<UseCase8StreamFilter.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 0)
                .collect(Collectors.toList());
        assertEquals(5, result.size(),
                "5 out of 7 bogies have capacity > 0 (excluding Engine and Pantry Car).");
        result.forEach(b ->
                assertTrue(b.capacity > 0, b.name + " should have capacity > 0.")
        );
    }

    @Test
    @DisplayName("TC09 - Original list is NOT modified by stream filter")
    void testOriginalListUnchanged() {
        bogies.stream()
                .filter(b -> b.capacity > 50)
                .collect(Collectors.toList());
        assertEquals(7, bogies.size(),
                "Original list should remain unchanged after streaming.");
    }

    @Test
    @DisplayName("TC10 - Stream chaining: filter then count using stream pipeline")
    void testFilterAndCount() {
        long count = bogies.stream()
                .filter(b -> b.capacity >= 60)
                .count();
        assertEquals(3, count,
                "Sleeper(72), AC Chair(64), General(90) have capacity >= 60.");
    }
}
