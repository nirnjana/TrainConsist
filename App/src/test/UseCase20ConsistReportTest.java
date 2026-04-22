import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase20ConsistReportTest {

    private UseCase20ConsistReport mgmt;

    @BeforeEach
    void setUp() {
        mgmt = new UseCase20ConsistReport("Rajdhani Express");
        mgmt.addBogie("B001", "Locomotive", 0);
        mgmt.addBogie("B002", "AC Sleeper", 72);
        mgmt.addBogie("B003", "General", 90);
        mgmt.addBogie("B004", "Pantry Car", 0);
        mgmt.addBogie("B005", "Guard Van", 8);
    }

    @Test
    @DisplayName("TC01 - Total bogie count is 5")
    void testBogieCount() {
        assertEquals(5, mgmt.getBogieCount());
    }

    @Test
    @DisplayName("TC02 - Total capacity is 170")
    void testTotalCapacity() {
        assertEquals(170, mgmt.getTotalCapacity());
    }

    @Test
    @DisplayName("TC03 - Valid consist returns true")
    void testValidConsist() {
        assertTrue(mgmt.isValidConsist());
    }

    @Test
    @DisplayName("TC04 - Count by type AC Sleeper is 1")
    void testCountByType() {
        assertEquals(1, mgmt.countByType("AC Sleeper"));
    }

    @Test
    @DisplayName("TC05 - Generate report does not throw")
    void testGenerateReportNoException() {
        assertDoesNotThrow(() -> mgmt.generateReport());
    }
}
