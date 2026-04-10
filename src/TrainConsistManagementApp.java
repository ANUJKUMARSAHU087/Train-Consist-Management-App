import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistManagementApp {

    // Binary Search Method
    public static boolean binarySearch(String[] bogieIds, String key) {
        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int comparison = bogieIds[mid].compareTo(key);

            if (comparison == 0) {
                return true; // match found
            } else if (comparison < 0) {
                low = mid + 1; // search right half
            } else {
                high = mid - 1; // search left half
            }
        }
        return false; // not found
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Step 1: Input number of bogies
        System.out.print("Enter number of bogie IDs: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        // Step 2: Create array
        String[] bogieIds = new String[n];

        // Step 3: Input bogie IDs
        System.out.println("Enter bogie IDs:");
        for (int i = 0; i < n; i++) {
            bogieIds[i] = scanner.nextLine();
        }

        // Step 4: SORT (important precondition)
        Arrays.sort(bogieIds);

        System.out.println("\nSorted Bogie IDs: " + Arrays.toString(bogieIds));

        // Step 5: Input search key
        System.out.print("Enter bogie ID to search: ");
        String key = scanner.nextLine();

        // Step 6: Perform binary search
        boolean found = binarySearch(bogieIds, key);

        // Step 7: Display result
        if (found) {
            System.out.println("Bogie ID " + key + " found in the consist.");
        } else {
            System.out.println("Bogie ID " + key + " NOT found in the consist.");
        }

        scanner.close();
    }
}