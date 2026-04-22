import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase17ContainsBogieTypeTest {

    private UseCase17ContainsBogieType mgmt;

    @BeforeEach
    void setUp() {
        mgmt = new UseCase17ContainsBogieType();
        mgmt.addBogie("B001", "Locomotive", 0);
        mgmt.addBogie("B002", "AC Sleeper", 72);
    }

    @Test
    @DisplayName("TC01 - Contains existing type returns true")
    void testContainsExisting() {
        assertTrue(mgmt.containsType("AC Sleeper"));
    }

    @Test
    @DisplayName("TC02 - Contains missing type returns false")
    void testContainsMissing() {
        assertFalse(mgmt.containsType("Guard Van"));
    }

    @Test
    @DisplayName("TC03 - Contains is case-insensitive")
    void testContainsCaseInsensitive() {
        assertTrue(mgmt.containsType("ac sleeper"));
    }
}
