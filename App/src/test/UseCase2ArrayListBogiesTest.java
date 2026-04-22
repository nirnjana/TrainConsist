import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

/**
 * Test class for UC2 - Manage Passenger Bogies Using ArrayList
 *
 * Tests:
 *  - add() increases size
 *  - remove() decreases size and removes correct element
 *  - contains() returns correct boolean
 *  - Insertion order is preserved
 */
public class UseCase2ArrayListBogiesTest {

    private ArrayList<String> bogies;

    @BeforeEach
    void setUp() {
        bogies = new ArrayList<>();
        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("First Class");
    }

    // -----------------------------------------------------------------------
    // Tests for add()
    // -----------------------------------------------------------------------

    @Test
    @DisplayName("TC01 - After adding 3 bogies, size should be 3")
    void testAddIncreasesSize() {
        assertEquals(3, bogies.size(),
                "ArrayList should contain exactly 3 bogies after 3 adds.");
    }

    @Test
    @DisplayName("TC02 - add() preserves insertion order")
    void testInsertionOrder() {
        assertEquals("Sleeper",     bogies.get(0), "Index 0 should be Sleeper.");
        assertEquals("AC Chair",    bogies.get(1), "Index 1 should be AC Chair.");
        assertEquals("First Class", bogies.get(2), "Index 2 should be First Class.");
    }

    @Test
    @DisplayName("TC03 - Adding another bogie increases size to 4")
    void testAddFourthBogie() {
        bogies.add("Guard Van");
        assertEquals(4, bogies.size());
        assertEquals("Guard Van", bogies.get(3));
    }

    // -----------------------------------------------------------------------
    // Tests for remove()
    // -----------------------------------------------------------------------

    @Test
    @DisplayName("TC04 - remove('AC Chair') decreases size by 1")
    void testRemoveDecreasesSize() {
        bogies.remove("AC Chair");
        assertEquals(2, bogies.size(),
                "Size should be 2 after removing one element.");
    }

    @Test
    @DisplayName("TC05 - remove() deletes the correct element")
    void testRemoveCorrectElement() {
        bogies.remove("AC Chair");
        assertFalse(bogies.contains("AC Chair"),
                "'AC Chair' should no longer be in the list after removal.");
    }

    @Test
    @DisplayName("TC06 - Other elements remain after remove()")
    void testOthersRemainAfterRemove() {
        bogies.remove("AC Chair");
        assertTrue(bogies.contains("Sleeper"), "Sleeper should still be present.");
        assertTrue(bogies.contains("First Class"), "First Class should still be present.");
    }

    @Test
    @DisplayName("TC07 - remove() on non-existent element returns false")
    void testRemoveNonExistent() {
        boolean result = bogies.remove("Guard Van");
        assertFalse(result, "Removing a non-existent element should return false.");
        assertEquals(3, bogies.size(), "Size should remain unchanged.");
    }

    // -----------------------------------------------------------------------
    // Tests for contains()
    // -----------------------------------------------------------------------

    @Test
    @DisplayName("TC08 - contains() returns true for existing bogie")
    void testContainsExisting() {
        assertTrue(bogies.contains("Sleeper"),
                "contains() should return true for 'Sleeper'.");
    }

    @Test
    @DisplayName("TC09 - contains() returns false after removal")
    void testContainsAfterRemoval() {
        bogies.remove("AC Chair");
        assertFalse(bogies.contains("AC Chair"),
                "contains() should return false after removing 'AC Chair'.");
    }

    @Test
    @DisplayName("TC10 - contains() returns false for non-existent element")
    void testContainsNonExistent() {
        assertFalse(bogies.contains("Dining Car"),
                "contains() should return false for a bogie never added.");
    }
}
