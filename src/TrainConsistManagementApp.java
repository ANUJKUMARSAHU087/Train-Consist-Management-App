import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistManagementApp {

    // Binary Search with validation (UC19 + UC20)
    public static boolean binarySearch(String[] bogieIds, String key) {

        // ✅ UC20: State Validation (Fail-Fast)
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("Search operation failed: No bogies available in the train consist.");
        }

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int comparison = bogieIds[mid].compareTo(key);

            if (comparison == 0) {
                return true;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            // Step 1: Input number of bogies
            System.out.print("Enter number of bogie IDs: ");
            int n = scanner.nextInt();
            scanner.nextLine();

            // Step 2: Create array
            String[] bogieIds = new String[n];

            // Step 3: Input bogie IDs
            if (n > 0) {
                System.out.println("Enter bogie IDs:");
                for (int i = 0; i < n; i++) {
                    bogieIds[i] = scanner.nextLine();
                }
            }

            // Step 4: Sort before binary search
            Arrays.sort(bogieIds);

            // Step 5: Input search key
            System.out.print("Enter bogie ID to search: ");
            String key = scanner.nextLine();

            // Step 6: Perform search
            boolean found = binarySearch(bogieIds, key);

            // Step 7: Display result
            if (found) {
                System.out.println("Bogie ID " + key + " found in the consist.");
            } else {
                System.out.println("Bogie ID " + key + " NOT found in the consist.");
            }

        } catch (IllegalStateException e) {
            // ✅ Handle fail-fast exception
            System.out.println("ERROR: " + e.getMessage());
        }

        scanner.close();
    }
}