import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase18ReplaceBogieTest {

    private UseCase18ReplaceBogie mgmt;

    @BeforeEach
    void setUp() {
        mgmt = new UseCase18ReplaceBogie();
        mgmt.addBogie("B001", "Locomotive", 0);
        mgmt.addBogie("B002", "General", 90);
        mgmt.addBogie("B003", "Guard Van", 8);
    }

    @Test
    @DisplayName("TC01 - Replace valid index returns true")
    void testReplaceValid() {
        assertTrue(mgmt.replaceBogie(1, "B002-NEW", "First Class", 54));
    }

    @Test
    @DisplayName("TC02 - Replaced bogie has new type")
    void testReplacedBogieType() {
        mgmt.replaceBogie(1, "B002-NEW", "First Class", 54);
        assertEquals("First Class", mgmt.getBogie(1).type);
    }

    @Test
    @DisplayName("TC03 - Replace invalid index returns false")
    void testReplaceInvalidIndex() {
        assertFalse(mgmt.replaceBogie(10, "B999", "Pantry", 0));
    }

    @Test
    @DisplayName("TC04 - Replace does not change bogie count")
    void testReplaceCount() {
        mgmt.replaceBogie(0, "B001-NEW", "Locomotive", 0);
        assertEquals(3, mgmt.getBogieCount());
    }
}
