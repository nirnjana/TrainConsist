import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC8 - UseCase8TrainConsistMgmt
 *
 * Tests all major operations:
 *  - Adding bogies
 *  - Removing bogies
 *  - Searching bogies
 *  - Updating bogies
 *  - Total capacity calculation
 *  - Bogie count
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UseCase8TrainConsistMgmtTest {

    // Instance of the train consist manager under test
    private UseCase8TrainConsistMgmt trainMgmt;

    /**
     * Set up a fresh consist before each test.
     * Adds three bogies as baseline data.
     */
    @BeforeEach
    void setUp() {
        trainMgmt = new UseCase8TrainConsistMgmt();
        trainMgmt.addBogie("B001", "Locomotive", 0);
        trainMgmt.addBogie("B002", "AC Sleeper", 72);
        trainMgmt.addBogie("B003", "General", 90);
    }

    // -----------------------------------------------------------------------
    // Test: Initial state after setUp
    // -----------------------------------------------------------------------

    @Test
    @Order(1)
    @DisplayName("TC01 - Initial bogie count should be 3 after setUp")
    void testInitialBogieCount() {
        assertEquals(3, trainMgmt.getBogieCount(),
                "After setUp, consist should have exactly 3 bogies.");
    }

    // -----------------------------------------------------------------------
    // Test: addBogie
    // -----------------------------------------------------------------------

    @Test
    @Order(2)
    @DisplayName("TC02 - Add a bogie increases count by 1")
    void testAddBogie() {
        trainMgmt.addBogie("B004", "Guard Van", 8);
        assertEquals(4, trainMgmt.getBogieCount(),
                "After adding one bogie, count should be 4.");
    }

    @Test
    @Order(3)
    @DisplayName("TC03 - Adding multiple bogies updates count correctly")
    void testAddMultipleBogies() {
        trainMgmt.addBogie("B004", "Pantry Car", 0);
        trainMgmt.addBogie("B005", "First Class", 54);
        assertEquals(5, trainMgmt.getBogieCount(),
                "After adding 2 more bogies, total should be 5.");
    }

    // -----------------------------------------------------------------------
    // Test: removeBogie
    // -----------------------------------------------------------------------

    @Test
    @Order(4)
    @DisplayName("TC04 - Remove existing bogie returns true and decreases count")
    void testRemoveExistingBogie() {
        boolean result = trainMgmt.removeBogie("B002");
        assertTrue(result, "Removing an existing bogie should return true.");
        assertEquals(2, trainMgmt.getBogieCount(),
                "Count should decrease by 1 after removal.");
    }

    @Test
    @Order(5)
    @DisplayName("TC05 - Remove non-existent bogie returns false")
    void testRemoveNonExistentBogie() {
        boolean result = trainMgmt.removeBogie("B999");
        assertFalse(result, "Removing a non-existent bogie should return false.");
        assertEquals(3, trainMgmt.getBogieCount(),
                "Count should remain 3 when removal fails.");
    }

    // -----------------------------------------------------------------------
    // Test: searchBogie
    // -----------------------------------------------------------------------

    @Test
    @Order(6)
    @DisplayName("TC06 - Search for existing bogie returns non-null")
    void testSearchExistingBogie() {
        UseCase8TrainConsistMgmt.Bogie found = trainMgmt.searchBogie("B001");
        assertNotNull(found, "Searching for B001 should return a Bogie object.");
        assertEquals("B001", found.bogieId, "Found bogie should have bogieId B001.");
    }

    @Test
    @Order(7)
    @DisplayName("TC07 - Search for non-existent bogie returns null")
    void testSearchNonExistentBogie() {
        UseCase8TrainConsistMgmt.Bogie found = trainMgmt.searchBogie("B999");
        assertNull(found, "Searching for B999 should return null.");
    }

    @Test
    @Order(8)
    @DisplayName("TC08 - Search is case-insensitive")
    void testSearchCaseInsensitive() {
        UseCase8TrainConsistMgmt.Bogie found = trainMgmt.searchBogie("b002");
        assertNotNull(found, "Search should be case-insensitive; b002 should find B002.");
    }

    // -----------------------------------------------------------------------
    // Test: updateBogie
    // -----------------------------------------------------------------------

    @Test
    @Order(9)
    @DisplayName("TC09 - Update existing bogie returns true and reflects changes")
    void testUpdateExistingBogie() {
        boolean result = trainMgmt.updateBogie("B003", "First Class", 54);
        assertTrue(result, "Updating an existing bogie should return true.");

        // Verify values were actually updated
        UseCase8TrainConsistMgmt.Bogie updated = trainMgmt.searchBogie("B003");
        assertNotNull(updated);
        assertEquals("First Class", updated.type, "Type should be updated to First Class.");
        assertEquals(54, updated.capacity, "Capacity should be updated to 54.");
    }

    @Test
    @Order(10)
    @DisplayName("TC10 - Update non-existent bogie returns false")
    void testUpdateNonExistentBogie() {
        boolean result = trainMgmt.updateBogie("B999", "Luxury", 30);
        assertFalse(result, "Updating a non-existent bogie should return false.");
    }

    // -----------------------------------------------------------------------
    // Test: getTotalCapacity
    // -----------------------------------------------------------------------

    @Test
    @Order(11)
    @DisplayName("TC11 - Total capacity is sum of all bogie capacities")
    void testGetTotalCapacity() {
        // B001=0, B002=72, B003=90 → total = 162
        int total = trainMgmt.getTotalCapacity();
        assertEquals(162, total,
                "Total capacity should be 0 + 72 + 90 = 162.");
    }

    @Test
    @Order(12)
    @DisplayName("TC12 - Total capacity is 0 when no bogies are present")
    void testTotalCapacityEmpty() {
        UseCase8TrainConsistMgmt emptyMgmt = new UseCase8TrainConsistMgmt();
        assertEquals(0, emptyMgmt.getTotalCapacity(),
                "Empty consist should have total capacity of 0.");
    }

    @Test
    @Order(13)
    @DisplayName("TC13 - Total capacity updates correctly after adding a bogie")
    void testTotalCapacityAfterAdd() {
        trainMgmt.addBogie("B004", "Guard Van", 8);
        // 0 + 72 + 90 + 8 = 170
        assertEquals(170, trainMgmt.getTotalCapacity(),
                "Total capacity should be 170 after adding Guard Van (8).");
    }

    @Test
    @Order(14)
    @DisplayName("TC14 - Total capacity updates correctly after removing a bogie")
    void testTotalCapacityAfterRemove() {
        trainMgmt.removeBogie("B003"); // removes capacity 90
        // 0 + 72 = 72
        assertEquals(72, trainMgmt.getTotalCapacity(),
                "Total capacity should be 72 after removing B003 (90).");
    }

    // -----------------------------------------------------------------------
    // Test: getBogieCount
    // -----------------------------------------------------------------------

    @Test
    @Order(15)
    @DisplayName("TC15 - Bogie count is 0 for a new, empty consist")
    void testBogieCountEmpty() {
        UseCase8TrainConsistMgmt emptyMgmt = new UseCase8TrainConsistMgmt();
        assertEquals(0, emptyMgmt.getBogieCount(),
                "A newly created consist should have 0 bogies.");
    }
}
