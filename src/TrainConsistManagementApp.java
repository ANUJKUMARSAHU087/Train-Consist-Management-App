import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Step 1: Take number of bogies
        System.out.print("Enter number of bogie types: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Step 2: Create array
        String[] bogieTypes = new String[n];

        // Step 3: Input bogie names
        System.out.println("Enter bogie type names:");
        for (int i = 0; i < n; i++) {
            bogieTypes[i] = scanner.nextLine();
        }

        // Step 4: Sort using Arrays.sort()
        Arrays.sort(bogieTypes);

        // Step 5: Display sorted result
        System.out.println("\nSorted Bogie Types:");
        System.out.println(Arrays.toString(bogieTypes));

        scanner.close();
    }
}