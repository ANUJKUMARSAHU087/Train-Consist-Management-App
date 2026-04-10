import java.util.Scanner;

public class TrainConsistManagementApp {

    // Linear Search Method
    public static boolean linearSearch(String[] bogieIds, String key) {
        for (int i = 0; i < bogieIds.length; i++) {
            if (bogieIds[i].equals(key)) {  // safe string comparison
                return true; // match found → early termination
            }
        }
        return false; // no match found
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Step 1: Input number of bogies
        System.out.print("Enter number of bogie IDs: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Step 2: Create array
        String[] bogieIds = new String[n];

        // Step 3: Input bogie IDs
        System.out.println("Enter bogie IDs:");
        for (int i = 0; i < n; i++) {
            bogieIds[i] = scanner.nextLine();
        }

        // Step 4: Input search key
        System.out.print("Enter bogie ID to search: ");
        String searchKey = scanner.nextLine();

        // Step 5: Perform search
        boolean found = linearSearch(bogieIds, searchKey);

        // Step 6: Display result
        if (found) {
            System.out.println("Bogie ID " + searchKey + " found in the consist.");
        } else {
            System.out.println("Bogie ID " + searchKey + " NOT found in the consist.");
        }

        scanner.close();
    }
}