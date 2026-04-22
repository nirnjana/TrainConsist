import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase19CopyConsistTest {

    private UseCase19CopyConsist source;
    private UseCase19CopyConsist destination;

    @BeforeEach
    void setUp() {
        source = new UseCase19CopyConsist();
        source.addBogie("B001", "Locomotive", 0);
        source.addBogie("B002", "AC Sleeper", 72);
        source.addBogie("B003", "Guard Van", 8);
        destination = new UseCase19CopyConsist();
    }

    @Test
    @DisplayName("TC01 - After copy, destination count matches source")
    void testCopyCount() {
        source.copyTo(destination);
        assertEquals(source.getBogieCount(), destination.getBogieCount());
    }

    @Test
    @DisplayName("TC02 - Source count unchanged after copy")
    void testSourceUnchanged() {
        source.copyTo(destination);
        assertEquals(3, source.getBogieCount());
    }

    @Test
    @DisplayName("TC03 - Destination starts empty before copy")
    void testDestinationStartsEmpty() {
        assertEquals(0, destination.getBogieCount());
    }
}
