import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase10FilterBogiesByTypeTest {

    private UseCase10FilterBogiesByType mgmt;

    @BeforeEach
    void setUp() {
        mgmt = new UseCase10FilterBogiesByType();
        mgmt.addBogie("B001", "AC Sleeper", 72);
        mgmt.addBogie("B002", "AC Sleeper", 72);
        mgmt.addBogie("B003", "General", 90);
        mgmt.addBogie("B004", "Locomotive", 0);
    }

    @Test
    @DisplayName("TC01 - Filter AC Sleeper returns 2")
    void testFilterACSleeper() {
        assertEquals(2, mgmt.filterByType("AC Sleeper").size());
    }

    @Test
    @DisplayName("TC02 - Filter General returns 1")
    void testFilterGeneral() {
        assertEquals(1, mgmt.filterByType("General").size());
    }

    @Test
    @DisplayName("TC03 - Filter non-existent type returns empty list")
    void testFilterNotFound() {
        assertTrue(mgmt.filterByType("Guard Van").isEmpty());
    }
}
