import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Test class for UC12 - Safety Compliance Check for Goods Bogies
 */
public class UseCase12SafetyComplianceTest {

    private List<UseCase12SafetyCompliance.GoodsBogie> bogies;

    @BeforeEach
    void setUp() {
        bogies = new ArrayList<>();
        bogies.add(new UseCase12SafetyCompliance.GoodsBogie("G001", "Cylindrical", "Liquid", 30, true));
        bogies.add(new UseCase12SafetyCompliance.GoodsBogie("G002", "Rectangular", "Solid",  45, true));
        bogies.add(new UseCase12SafetyCompliance.GoodsBogie("G003", "Cylindrical", "Liquid", 20, true));
    }

    @Test
    @DisplayName("TC01 - All bogies pass full safety check")
    void testAllPassSafetyCheck() {
        assertTrue(bogies.stream().allMatch(UseCase12SafetyCompliance.fullSafetyCheck));
    }

    @Test
    @DisplayName("TC02 - Weight > 50 fails the weight rule")
    void testWeightViolation() {
        bogies.add(new UseCase12SafetyCompliance.GoodsBogie("G004", "Rectangular", "Solid", 60, true));
        assertFalse(bogies.stream().allMatch(UseCase12SafetyCompliance.weightSafe));
    }

    @Test
    @DisplayName("TC03 - Cylindrical bogie with Solid cargo fails cylindrical rule")
    void testCylindricalCargoViolation() {
        bogies.add(new UseCase12SafetyCompliance.GoodsBogie("G005", "Cylindrical", "Solid", 30, true));
        assertFalse(bogies.stream().allMatch(UseCase12SafetyCompliance.cylindricalSafe));
    }

    @Test
    @DisplayName("TC04 - Rectangular bogie with Solid cargo passes cylindrical rule")
    void testRectangularSolidPasses() {
        // Rectangular + Solid is fine
        assertTrue(bogies.stream().allMatch(UseCase12SafetyCompliance.cylindricalSafe));
    }

    @Test
    @DisplayName("TC05 - isSafe=false fails the marked safety rule")
    void testMarkedUnsafeFails() {
        bogies.add(new UseCase12SafetyCompliance.GoodsBogie("G006", "Rectangular", "Solid", 40, false));
        assertFalse(bogies.stream().allMatch(UseCase12SafetyCompliance.markedSafe));
    }

    @Test
    @DisplayName("TC06 - Empty list allMatch() returns true (vacuously safe)")
    void testEmptyListAllMatch() {
        List<UseCase12SafetyCompliance.GoodsBogie> empty = new ArrayList<>();
        assertTrue(empty.stream().allMatch(UseCase12SafetyCompliance.fullSafetyCheck),
                "allMatch on empty stream is vacuously true.");
    }

    @Test
    @DisplayName("TC07 - Full check fails if any rule is violated")
    void testFullCheckFail() {
        bogies.add(new UseCase12SafetyCompliance.GoodsBogie("G007", "Cylindrical", "Gas", 80, false));
        assertFalse(bogies.stream().allMatch(UseCase12SafetyCompliance.fullSafetyCheck));
    }
}
