import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC18 - Linear Search for Bogie ID
 */
public class UseCase18LinearSearchTest {

    private String[] bogieIDs;

    @BeforeEach
    void setUp() {
        bogieIDs = new String[]{"B005", "B002", "B008", "B001", "B006", "B003", "B007", "B004"};
    }

    @Test
    @DisplayName("TC01 - Found element returns its correct index")
    void testFoundReturnsIndex() {
        int index = UseCase18LinearSearch.linearSearch(bogieIDs, "B003");
        assertEquals(5, index, "B003 is at index 5.");
    }

    @Test
    @DisplayName("TC02 - Not found returns -1")
    void testNotFoundReturnsMinusOne() {
        int index = UseCase18LinearSearch.linearSearch(bogieIDs, "B099");
        assertEquals(-1, index);
    }

    @Test
    @DisplayName("TC03 - First element is found at index 0")
    void testFirstElement() {
        int index = UseCase18LinearSearch.linearSearch(bogieIDs, "B005");
        assertEquals(0, index);
    }

    @Test
    @DisplayName("TC04 - Last element is found at last index")
    void testLastElement() {
        int index = UseCase18LinearSearch.linearSearch(bogieIDs, "B004");
        assertEquals(bogieIDs.length - 1, index);
    }

    @Test
    @DisplayName("TC05 - Search on empty array returns -1")
    void testEmptyArray() {
        int index = UseCase18LinearSearch.linearSearch(new String[]{}, "B001");
        assertEquals(-1, index);
    }

    @Test
    @DisplayName("TC06 - Search is case-sensitive (b001 != B001)")
    void testCaseSensitive() {
        int index = UseCase18LinearSearch.linearSearch(bogieIDs, "b001");
        assertEquals(-1, index, "Search is case-sensitive; lowercase 'b001' should not match 'B001'.");
    }

    @Test
    @DisplayName("TC07 - B001 is found at the correct index")
    void testB001Found() {
        int index = UseCase18LinearSearch.linearSearch(bogieIDs, "B001");
        assertEquals(3, index, "B001 is at index 3.");
    }
}
