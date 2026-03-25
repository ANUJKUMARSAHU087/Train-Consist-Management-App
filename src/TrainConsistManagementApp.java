import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        // Create a HashSet to store unique bogie IDs
        Set<String> bogieIds = new HashSet<>();

        // Adding bogie IDs (including duplicates intentionally)
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // Duplicate
        bogieIds.add("BG104");
        bogieIds.add("BG102"); // Duplicate

        // Display the final set of unique bogie IDs
        System.out.println("Final Unique Bogie IDs in Train:");
        for (String id : bogieIds) {
            System.out.println(id);
        }
    }
}