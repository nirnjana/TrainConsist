import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase13ValidateConsistTest {

    @Test
    @DisplayName("TC01 - Valid consist passes validation")
    void testValidConsist() {
        UseCase13ValidateConsist mgmt = new UseCase13ValidateConsist();
        mgmt.addBogie("B001", "Locomotive", 0);
        mgmt.addBogie("B002", "AC Sleeper", 72);
        mgmt.addBogie("B003", "Guard Van", 8);
        assertTrue(mgmt.validateConsist());
    }

    @Test
    @DisplayName("TC02 - Missing Guard Van fails validation")
    void testMissingGuardVan() {
        UseCase13ValidateConsist mgmt = new UseCase13ValidateConsist();
        mgmt.addBogie("B001", "Locomotive", 0);
        mgmt.addBogie("B002", "AC Sleeper", 72);
        assertFalse(mgmt.validateConsist());
    }

    @Test
    @DisplayName("TC03 - Two locomotives fails validation")
    void testTwoLocomotives() {
        UseCase13ValidateConsist mgmt = new UseCase13ValidateConsist();
        mgmt.addBogie("B001", "Locomotive", 0);
        mgmt.addBogie("B002", "Locomotive", 0);
        mgmt.addBogie("B003", "AC Sleeper", 72);
        mgmt.addBogie("B004", "Guard Van", 8);
        assertFalse(mgmt.validateConsist());
    }
}
