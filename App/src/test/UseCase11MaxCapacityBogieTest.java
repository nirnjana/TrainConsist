import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase11MaxCapacityBogieTest {

    private UseCase11MaxCapacityBogie mgmt;

    @BeforeEach
    void setUp() {
        mgmt = new UseCase11MaxCapacityBogie();
        mgmt.addBogie("B001", "Locomotive", 0);
        mgmt.addBogie("B002", "AC Sleeper", 72);
        mgmt.addBogie("B003", "General", 90);
    }

    @Test
    @DisplayName("TC01 - Max capacity bogie should be General (90)")
    void testMaxCapacity() {
        UseCase11MaxCapacityBogie.Bogie max = mgmt.findMaxCapacityBogie();
        assertNotNull(max);
        assertEquals(90, max.capacity);
    }

    @Test
    @DisplayName("TC02 - Empty consist returns null")
    void testEmptyConsist() {
        UseCase11MaxCapacityBogie empty = new UseCase11MaxCapacityBogie();
        assertNull(empty.findMaxCapacityBogie());
    }
}
