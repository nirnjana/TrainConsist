import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC19 - Binary Search for Bogie ID
 */
public class UseCase19BinarySearchTest {

    private String[] bogieIDs;

    @BeforeEach
    void setUp() {
        // SORTED array — required for binary search
        bogieIDs = new String[]{"B001", "B002", "B003", "B004", "B005",
                                "B006", "B007", "B008", "B009", "B010"};
    }

    @Test
    @DisplayName("TC01 - Found element returns correct index")
    void testFoundReturnsIndex() {
        assertEquals(6, UseCase19BinarySearch.binarySearch(bogieIDs, "B007"),
                "B007 is at index 6.");
    }

    @Test
    @DisplayName("TC02 - Not found returns -1")
    void testNotFoundReturnsMinusOne() {
        assertEquals(-1, UseCase19BinarySearch.binarySearch(bogieIDs, "B099"));
    }

    @Test
    @DisplayName("TC03 - First element found at index 0")
    void testFirstElement() {
        assertEquals(0, UseCase19BinarySearch.binarySearch(bogieIDs, "B001"));
    }

    @Test
    @DisplayName("TC04 - Last element found at last index")
    void testLastElement() {
        assertEquals(9, UseCase19BinarySearch.binarySearch(bogieIDs, "B010"));
    }

    @Test
    @DisplayName("TC05 - Middle element found correctly")
    void testMiddleElement() {
        // Index 4 or 5 (B005 or B006) — searching B005
        assertEquals(4, UseCase19BinarySearch.binarySearch(bogieIDs, "B005"));
    }

    @Test
    @DisplayName("TC06 - Empty array returns -1")
    void testEmptyArray() {
        assertEquals(-1, UseCase19BinarySearch.binarySearch(new String[]{}, "B001"));
    }

    @Test
    @DisplayName("TC07 - B003 found at index 2")
    void testB003() {
        assertEquals(2, UseCase19BinarySearch.binarySearch(bogieIDs, "B003"));
    }

    @Test
    @DisplayName("TC08 - Case-sensitive: b001 does not match B001")
    void testCaseSensitive() {
        assertEquals(-1, UseCase19BinarySearch.binarySearch(bogieIDs, "b001"),
                "Binary search is case-sensitive.");
    }
}
