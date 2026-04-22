import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase16ClearConsistTest {

    private UseCase16ClearConsist mgmt;

    @BeforeEach
    void setUp() {
        mgmt = new UseCase16ClearConsist();
        mgmt.addBogie("B001", "Locomotive", 0);
        mgmt.addBogie("B002", "AC Sleeper", 72);
    }

    @Test
    @DisplayName("TC01 - After clear, count is 0")
    void testClearCount() {
        mgmt.clearConsist();
        assertEquals(0, mgmt.getBogieCount());
    }

    @Test
    @DisplayName("TC02 - After clear, consist is empty")
    void testClearIsEmpty() {
        mgmt.clearConsist();
        assertTrue(mgmt.isEmpty());
    }

    @Test
    @DisplayName("TC03 - Clearing an empty consist does not throw")
    void testClearEmptyConsist() {
        mgmt.clearConsist();
        assertDoesNotThrow(() -> mgmt.clearConsist());
    }
}
