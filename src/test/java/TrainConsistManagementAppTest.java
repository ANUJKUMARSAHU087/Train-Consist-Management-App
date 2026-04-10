import java.util.*;

public class TrainConsistManagementAppTest {

    // Custom Exception
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // Passenger Bogie Class
    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }

        public String getType() {
            return type;
        }
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

        // Test 1: Valid Capacity Creation
        try {
            PassengerBogie b = new PassengerBogie("Sleeper", 80);
            printResult("testException_ValidCapacityCreation", b != null);
        } catch (Exception e) {
            printResult("testException_ValidCapacityCreation", false);
        }

        // Test 2: Negative Capacity
        try {
            new PassengerBogie("Sleeper", -10);
            printResult("testException_NegativeCapacityThrowsException", false);
        } catch (InvalidCapacityException e) {
            printResult("testException_NegativeCapacityThrowsException", true);
        }

        // Test 3: Zero Capacity
        try {
            new PassengerBogie("Sleeper", 0);
            printResult("testException_ZeroCapacityThrowsException", false);
        } catch (InvalidCapacityException e) {
            printResult("testException_ZeroCapacityThrowsException", true);
        }

        // Test 4: Exception Message Validation
        try {
            new PassengerBogie("Sleeper", 0);
            printResult("testException_ExceptionMessageValidation", false);
        } catch (InvalidCapacityException e) {
            printResult("testException_ExceptionMessageValidation",
                    e.getMessage().equals("Capacity must be greater than zero"));
        }

        // Test 5: Object Integrity
        try {
            PassengerBogie b = new PassengerBogie("AC Chair", 60);
            printResult("testException_ObjectIntegrityAfterCreation",
                    b.getType().equals("AC Chair") && b.getCapacity() == 60);
        } catch (Exception e) {
            printResult("testException_ObjectIntegrityAfterCreation", false);
        }

        // Test 6: Multiple Valid Bogies
        try {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 80);
            PassengerBogie b2 = new PassengerBogie("First Class", 100);
            printResult("testException_MultipleValidBogiesCreation",
                    b1 != null && b2 != null);
        } catch (Exception e) {
            printResult("testException_MultipleValidBogiesCreation", false);
        }
    }
}
