import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC20 - Exception Handling During Search Operations
 */
public class UseCase20ExceptionOnEmptySearchTest {

    private UseCase20ExceptionOnEmptySearch.TrainConsist emptyTrain;
    private UseCase20ExceptionOnEmptySearch.TrainConsist populatedTrain;

    @BeforeEach
    void setUp() {
        emptyTrain = new UseCase20ExceptionOnEmptySearch.TrainConsist();

        populatedTrain = new UseCase20ExceptionOnEmptySearch.TrainConsist();
        populatedTrain.addBogie("B001", "Locomotive");
        populatedTrain.addBogie("B002", "AC Sleeper");
        populatedTrain.addBogie("B003", "Guard Van");
    }

    @Test
    @DisplayName("TC01 - Search on empty consist throws IllegalStateException")
    void testEmptyConsistThrows() {
        assertThrows(IllegalStateException.class,
                () -> emptyTrain.search("B001"),
                "Searching on empty consist must throw IllegalStateException.");
    }

    @Test
    @DisplayName("TC02 - Exception message mentions empty consist")
    void testExceptionMessage() {
        IllegalStateException ex = assertThrows(IllegalStateException.class,
                () -> emptyTrain.search("B001"));
        assertTrue(ex.getMessage().toLowerCase().contains("empty"),
                "Message should mention the consist is empty.");
    }

    @Test
    @DisplayName("TC03 - Search on populated consist does not throw for found bogie")
    void testPopulatedConsistNoExceptionFound() {
        assertDoesNotThrow(() -> populatedTrain.search("B002"));
    }

    @Test
    @DisplayName("TC04 - Search on populated consist returns correct bogie")
    void testFoundBogie() {
        UseCase20ExceptionOnEmptySearch.Bogie result = populatedTrain.search("B002");
        assertNotNull(result, "B002 should be found.");
        assertEquals("B002", result.bogieId);
        assertEquals("AC Sleeper", result.type);
    }

    @Test
    @DisplayName("TC05 - Search for non-existent bogie returns null (no exception)")
    void testNotFoundReturnsNull() {
        UseCase20ExceptionOnEmptySearch.Bogie result = populatedTrain.search("B099");
        assertNull(result, "Non-existent bogie should return null, not throw.");
    }

    @Test
    @DisplayName("TC06 - Adding bogies then searching works correctly")
    void testAddThenSearch() {
        emptyTrain.addBogie("X001", "General");
        assertDoesNotThrow(() -> emptyTrain.search("X001"));
        UseCase20ExceptionOnEmptySearch.Bogie b = emptyTrain.search("X001");
        assertNotNull(b);
    }

    @Test
    @DisplayName("TC07 - Empty consist size is 0")
    void testEmptyConsistSize() {
        assertEquals(0, emptyTrain.size());
    }

    @Test
    @DisplayName("TC08 - Populated consist has correct size")
    void testPopulatedConsistSize() {
        assertEquals(3, populatedTrain.size());
    }
}
