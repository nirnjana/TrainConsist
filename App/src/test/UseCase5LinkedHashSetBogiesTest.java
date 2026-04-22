import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Test class for UC5 - Preserve Insertion Order of Bogies Using LinkedHashSet
 */
public class UseCase5LinkedHashSetBogiesTest {

    private Set<String> formation;

    @BeforeEach
    void setUp() {
        formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("AC Chair");
        formation.add("Guard Van");
    }

    @Test
    @DisplayName("TC01 - Should contain 4 unique bogies after setup")
    void testInitialSize() {
        assertEquals(4, formation.size());
    }

    @Test
    @DisplayName("TC02 - Adding duplicate returns false + size unchanged")
    void testDuplicateIgnored() {
        boolean result = formation.add("Engine");
        assertFalse(result, "Adding duplicate should return false.");
        assertEquals(4, formation.size(), "Size should remain 4.");
    }

    @Test
    @DisplayName("TC03 - Adding new bogie returns true and increases size")
    void testNewBogieAdded() {
        boolean result = formation.add("First Class");
        assertTrue(result);
        assertEquals(5, formation.size());
    }

    @Test
    @DisplayName("TC04 - Insertion order is preserved")
    void testInsertionOrderPreserved() {
        // Convert to list for index-based access
        List<String> ordered = new ArrayList<>(formation);
        assertEquals("Engine",   ordered.get(0), "1st should be Engine.");
        assertEquals("Sleeper",  ordered.get(1), "2nd should be Sleeper.");
        assertEquals("AC Chair", ordered.get(2), "3rd should be AC Chair.");
        assertEquals("Guard Van",ordered.get(3), "4th should be Guard Van.");
    }

    @Test
    @DisplayName("TC05 - Duplicate does not alter original insertion order")
    void testDuplicateDoesNotChangeOrder() {
        formation.add("Engine"); // Already first, duplicate
        List<String> ordered = new ArrayList<>(formation);
        assertEquals("Engine", ordered.get(0),
                "Engine should remain at position 0 even if added again.");
    }

    @Test
    @DisplayName("TC06 - New bogie is appended at the end")
    void testNewBogieAppendedAtEnd() {
        formation.add("Pantry Car");
        List<String> ordered = new ArrayList<>(formation);
        assertEquals("Pantry Car", ordered.get(ordered.size() - 1),
                "New bogie should appear at the last position.");
    }

    @Test
    @DisplayName("TC07 - Formation is unique — no duplicates at all")
    void testNoDuplicates() {
        formation.add("Sleeper");
        formation.add("AC Chair");
        // Every element in a Set is unique
        long uniqueCount = formation.stream().distinct().count();
        assertEquals(formation.size(), uniqueCount,
                "All elements should be unique.");
    }
}
