import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase15ReverseConsistTest {

    private UseCase15ReverseConsist mgmt;

    @BeforeEach
    void setUp() {
        mgmt = new UseCase15ReverseConsist();
        mgmt.addBogie("B001", "Locomotive", 0);
        mgmt.addBogie("B002", "AC Sleeper", 72);
        mgmt.addBogie("B003", "Guard Van", 8);
    }

    @Test
    @DisplayName("TC01 - Bogie count should be correct")
    void testBogieCount() {
        assertEquals(3, mgmt.getBogieCount());
    }

    @Test
    @DisplayName("TC02 - Display reverse does not throw")
    void testDisplayReverseNoException() {
        assertDoesNotThrow(() -> mgmt.displayReverse());
    }
}
