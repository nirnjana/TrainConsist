import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * UC11 - Validate Train ID & Cargo Codes Using Regular Expressions
 *
 * Goal: Validate Train ID and Cargo Code formats using Regular Expressions.
 *
 * Key Concepts:
 *  - Pattern  : Compiled regex that defines the expected format
 *  - Matcher  : Applies the pattern against an actual input string
 *  - matches(): Returns true if the entire input matches the pattern
 *  - Regex    : Pattern language: \d (digit), [A-Z] (uppercase), {n} (exact count)
 *
 * Formats:
 *  - Train ID  : "TR-" followed by exactly 4 digits  → e.g. TR-1234
 *  - Cargo Code: "CG-" followed by 2 uppercase + 2 digits → e.g. CG-AB12
 *
 * Flow:
 *  1. User enters Train ID and Cargo Code
 *  2. System compiles regex pattern
 *  3. Matcher checks input against the pattern
 *  4. If match → accepted; else → error message shown
 *  5. Program continues
 */
public class UseCase11RegexValidation {

    // Regex patterns
    static final String TRAIN_ID_PATTERN    = "TR-\\d{4}";          // TR- + 4 digits
    static final String CARGO_CODE_PATTERN  = "CG-[A-Z]{2}\\d{2}";  // CG- + 2 uppercase + 2 digits

    /**
     * Validates a Train ID against the expected pattern.
     *
     * @param trainId The input to validate
     * @return true if valid, false otherwise
     */
    public static boolean validateTrainId(String trainId) {
        Pattern pattern = Pattern.compile(TRAIN_ID_PATTERN);
        Matcher matcher = pattern.matcher(trainId);
        return matcher.matches();
    }

    /**
     * Validates a Cargo Code against the expected pattern.
     *
     * @param cargoCode The input to validate
     * @return true if valid, false otherwise
     */
    public static boolean validateCargoCode(String cargoCode) {
        Pattern pattern = Pattern.compile(CARGO_CODE_PATTERN);
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    /**
     * Prints validation result for a given value and pattern type.
     */
    private static void printResult(String label, String value, boolean valid) {
        System.out.printf("  %-20s -> %-12s [%s]%n",
                label, value, valid ? "VALID ✔" : "INVALID ✘");
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC11 - Validate Train ID & Cargo Codes\n");

        // --- Train ID Validation ---
        System.out.println("Train ID Validation (format: TR-XXXX):");
        printResult("Valid",    "TR-1234", validateTrainId("TR-1234")); // ✔
        printResult("Valid",    "TR-9999", validateTrainId("TR-9999")); // ✔
        printResult("Invalid",  "TR-12",   validateTrainId("TR-12"));   // too short
        printResult("Invalid",  "TN-1234", validateTrainId("TN-1234")); // wrong prefix
        printResult("Invalid",  "TR-ABCD", validateTrainId("TR-ABCD")); // letters not digits
        printResult("Invalid",  "1234",    validateTrainId("1234"));    // missing prefix

        // --- Cargo Code Validation ---
        System.out.println("\nCargo Code Validation (format: CG-AANN):");
        printResult("Valid",    "CG-AB12", validateCargoCode("CG-AB12")); // ✔
        printResult("Valid",    "CG-ZX99", validateCargoCode("CG-ZX99")); // ✔
        printResult("Invalid",  "CG-ab12", validateCargoCode("CG-ab12")); // lowercase
        printResult("Invalid",  "CG-1234", validateCargoCode("CG-1234")); // digits not letters
        printResult("Invalid",  "AB12",    validateCargoCode("AB12"));    // missing prefix
        printResult("Invalid",  "CG-ABC1", validateCargoCode("CG-ABC1")); // 3 letters, 1 digit

        System.out.println("\nProgram continues...");
    }
}
