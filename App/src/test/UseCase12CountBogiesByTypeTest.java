import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase12CountBogiesByTypeTest {

    private UseCase12CountBogiesByType mgmt;

    @BeforeEach
    void setUp() {
        mgmt = new UseCase12CountBogiesByType();
        mgmt.addBogie("B001", "AC Sleeper", 72);
        mgmt.addBogie("B002", "AC Sleeper", 72);
        mgmt.addBogie("B003", "General", 90);
        mgmt.addBogie("B004", "Locomotive", 0);
    }

    @Test
    @DisplayName("TC01 - Count AC Sleeper = 2")
    void testCountACSleeper() {
        assertEquals(2, mgmt.countByType("AC Sleeper"));
    }

    @Test
    @DisplayName("TC02 - Count General = 1")
    void testCountGeneral() {
        assertEquals(1, mgmt.countByType("General"));
    }

    @Test
    @DisplayName("TC03 - Count missing type = 0")
    void testCountMissing() {
        assertEquals(0, mgmt.countByType("Guard Van"));
    }
}
