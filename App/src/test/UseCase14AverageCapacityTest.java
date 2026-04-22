import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase14AverageCapacityTest {

    private UseCase14AverageCapacity mgmt;

    @BeforeEach
    void setUp() {
        mgmt = new UseCase14AverageCapacity();
        mgmt.addBogie("B001", "Locomotive", 0);
        mgmt.addBogie("B002", "AC Sleeper", 72);
        mgmt.addBogie("B003", "General", 90);
    }

    @Test
    @DisplayName("TC01 - Average of passenger bogies (72+90)/2 = 81.0")
    void testAverageCapacity() {
        assertEquals(81.0, mgmt.calculateAverageCapacity(), 0.01);
    }

    @Test
    @DisplayName("TC02 - Empty consist average is 0.0")
    void testAverageEmpty() {
        UseCase14AverageCapacity empty = new UseCase14AverageCapacity();
        assertEquals(0.0, empty.calculateAverageCapacity(), 0.01);
    }
}
