import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC11 - Validate Train ID & Cargo Codes
 */
public class UseCase11RegexValidationTest {

    // --- Train ID tests ---

    @Test
    @DisplayName("TC01 - TR-1234 is a valid Train ID")
    void testValidTrainId() {
        assertTrue(UseCase11RegexValidation.validateTrainId("TR-1234"));
    }

    @Test
    @DisplayName("TC02 - TR-9999 is a valid Train ID")
    void testValidTrainIdMax() {
        assertTrue(UseCase11RegexValidation.validateTrainId("TR-9999"));
    }

    @Test
    @DisplayName("TC03 - TR-12 is invalid (too short)")
    void testShortTrainId() {
        assertFalse(UseCase11RegexValidation.validateTrainId("TR-12"));
    }

    @Test
    @DisplayName("TC04 - TN-1234 is invalid (wrong prefix)")
    void testWrongPrefixTrainId() {
        assertFalse(UseCase11RegexValidation.validateTrainId("TN-1234"));
    }

    @Test
    @DisplayName("TC05 - TR-ABCD is invalid (letters instead of digits)")
    void testLettersInTrainId() {
        assertFalse(UseCase11RegexValidation.validateTrainId("TR-ABCD"));
    }

    @Test
    @DisplayName("TC06 - Empty string is invalid Train ID")
    void testEmptyTrainId() {
        assertFalse(UseCase11RegexValidation.validateTrainId(""));
    }

    // --- Cargo Code tests ---

    @Test
    @DisplayName("TC07 - CG-AB12 is a valid Cargo Code")
    void testValidCargoCode() {
        assertTrue(UseCase11RegexValidation.validateCargoCode("CG-AB12"));
    }

    @Test
    @DisplayName("TC08 - CG-ZX99 is a valid Cargo Code")
    void testValidCargoCodeMax() {
        assertTrue(UseCase11RegexValidation.validateCargoCode("CG-ZX99"));
    }

    @Test
    @DisplayName("TC09 - CG-ab12 is invalid (lowercase letters)")
    void testLowercaseCargoCode() {
        assertFalse(UseCase11RegexValidation.validateCargoCode("CG-ab12"));
    }

    @Test
    @DisplayName("TC10 - CG-1234 is invalid (digits where letters expected)")
    void testDigitsOnlyCargoCode() {
        assertFalse(UseCase11RegexValidation.validateCargoCode("CG-1234"));
    }

    @Test
    @DisplayName("TC11 - CG-ABC1 is invalid (3 letters + 1 digit)")
    void testWrongFormatCargoCode() {
        assertFalse(UseCase11RegexValidation.validateCargoCode("CG-ABC1"));
    }

    @Test
    @DisplayName("TC12 - Empty string is invalid Cargo Code")
    void testEmptyCargoCode() {
        assertFalse(UseCase11RegexValidation.validateCargoCode(""));
    }
}
