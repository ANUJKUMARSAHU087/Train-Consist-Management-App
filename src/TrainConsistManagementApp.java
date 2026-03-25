import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Welcome message
        System.out.println("=== Train Consist Management App ===");

        // Create ArrayList for passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // Adding bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Display bogies after insertion
        System.out.println("\nPassenger bogies after addition:");
        System.out.println(passengerBogies);

        // Remove a bogie (AC Chair)
        passengerBogies.remove("AC Chair");

        // Display bogies after removal
        System.out.println("\nPassenger bogies after removal:");
        System.out.println(passengerBogies);

        // Check existence of Sleeper bogie
        boolean isSleeperPresent = passengerBogies.contains("Sleeper");
        System.out.println("\nIs Sleeper bogie present? " + isSleeperPresent);

        // Final state of the list
        System.out.println("\nFinal passenger bogie list:");
        System.out.println(passengerBogies);

        // Program continues...
    }
}