import java.util.regex.*;

public class TrainConsistManagementAppTest {

    // Regex patterns
    static Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
    static Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

    // Validation methods
    public static boolean isValidTrainID(String trainId) {
        if (trainId == null) return false;
        Matcher matcher = trainPattern.matcher(trainId);
        return matcher.matches();
    }

    public static boolean isValidCargoCode(String cargoCode) {
        if (cargoCode == null) return false;
        Matcher matcher = cargoPattern.matcher(cargoCode);
        return matcher.matches();
    }

    // Helper
    public static void printResult(String testName, boolean result) {
        if (result) {
            System.out.println(testName + " → PASSED");
        } else {
            System.out.println(testName + " → FAILED");
        }
    }

    public static void main(String[] args) {

        // Test 1: Valid Train ID
        printResult("testRegex_ValidTrainID",
                isValidTrainID("TRN-1234"));

        // Test 2: Invalid Train ID Format
        printResult("testRegex_InvalidTrainIDFormat",
                !isValidTrainID("TRAIN12") &&
                        !isValidTrainID("TRN12A") &&
                        !isValidTrainID("1234-TRN"));

        // Test 3: Valid Cargo Code
        printResult("testRegex_ValidCargoCode",
                isValidCargoCode("PET-AB"));

        // Test 4: Invalid Cargo Code
        printResult("testRegex_InvalidCargoCodeFormat",
                !isValidCargoCode("PET-ab") &&
                        !isValidCargoCode("PET123") &&
                        !isValidCargoCode("AB-PET"));

        // Test 5: Train ID Digit Length Validation
        printResult("testRegex_TrainIDDigitLengthValidation",
                !isValidTrainID("TRN-123") &&
                        !isValidTrainID("TRN-12345"));

        // Test 6: Cargo Code Uppercase Validation
        printResult("testRegex_CargoCodeUppercaseValidation",
                !isValidCargoCode("PET-Ab") &&
                        !isValidCargoCode("PET-aB"));

        // Test 7: Empty Input Handling
        printResult("testRegex_EmptyInputHandling",
                !isValidTrainID("") &&
                        !isValidCargoCode(""));

        // Test 8: Exact Pattern Match
        printResult("testRegex_ExactPatternMatch",
                !isValidTrainID("TRN-1234X") &&
                        !isValidCargoCode("PET-ABC"));
    }
}
