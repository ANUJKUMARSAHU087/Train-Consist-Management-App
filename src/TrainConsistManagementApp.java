import java.util.LinkedHashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Create LinkedHashSet to maintain insertion order and uniqueness
        Set<String> trainFormation = new LinkedHashSet<>();

        // Adding bogies
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // Attempt to add duplicate bogie
        trainFormation.add("Sleeper"); // This will be ignored

        // Display final train formation
        System.out.println("Final Train Formation (Insertion Order Preserved):");

        for (String bogie : trainFormation) {
            System.out.println(bogie);
        }
    }
}