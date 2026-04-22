import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase9SortBogiesByTypeTest {

    private UseCase9SortBogiesByType mgmt;

    @BeforeEach
    void setUp() {
        mgmt = new UseCase9SortBogiesByType();
        mgmt.addBogie("B001", "General", 90);
        mgmt.addBogie("B002", "AC Sleeper", 72);
        mgmt.addBogie("B003", "Locomotive", 0);
    }

    @Test
    @DisplayName("TC01 - After sorting, first bogie should be AC Sleeper")
    void testSortFirstElement() {
        mgmt.sortByType();
        assertEquals("AC Sleeper", mgmt.getConsist().get(0).type);
    }

    @Test
    @DisplayName("TC02 - After sorting, last bogie should be Locomotive")
    void testSortLastElement() {
        mgmt.sortByType();
        assertEquals("Locomotive", mgmt.getConsist().get(2).type);
    }

    @Test
    @DisplayName("TC03 - Sort does not change bogie count")
    void testSortCount() {
        mgmt.sortByType();
        assertEquals(3, mgmt.getConsist().size());
    }
}
