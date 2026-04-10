import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }
}

public class TrainConsistManagementAppTest {

    // Filter method
    public static List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    // Helper method for result display
    public static void printResult(String testName, boolean result) {
        if (result) {
            System.out.println(testName + " → PASSED");
        } else {
            System.out.println(testName + " → FAILED");
        }
    }

    public static void main(String[] args) {

        // Test 1: Capacity Greater Than Threshold
        List<Bogie> list1 = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 100)
        );
        List<Bogie> result1 = filterBogies(list1, 70);
        printResult("testFilter_CapacityGreaterThanThreshold", result1.size() == 2);

        // Test 2: Capacity Equal To Threshold
        List<Bogie> list2 = Arrays.asList(
                new Bogie("AC Chair", 70),
                new Bogie("Sleeper", 80)
        );
        List<Bogie> result2 = filterBogies(list2, 70);
        printResult("testFilter_CapacityEqualToThreshold",
                result2.size() == 1 && result2.get(0).getName().equals("Sleeper"));

        // Test 3: Capacity Less Than Threshold
        List<Bogie> list3 = Arrays.asList(
                new Bogie("General", 50),
                new Bogie("AC Chair", 60)
        );
        List<Bogie> result3 = filterBogies(list3, 70);
        printResult("testFilter_CapacityLessThanThreshold", result3.isEmpty());

        // Test 4: Multiple Bogies Matching
        List<Bogie> list4 = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("First Class", 100),
                new Bogie("Luxury", 120)
        );
        List<Bogie> result4 = filterBogies(list4, 70);
        printResult("testFilter_MultipleBogiesMatching", result4.size() == 3);

        // Test 5: No Bogies Matching
        List<Bogie> list5 = Arrays.asList(
                new Bogie("General", 40),
                new Bogie("AC Chair", 50)
        );
        List<Bogie> result5 = filterBogies(list5, 70);
        printResult("testFilter_NoBogiesMatching", result5.isEmpty());

        // Test 6: All Bogies Matching
        List<Bogie> list6 = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("First Class", 90)
        );
        List<Bogie> result6 = filterBogies(list6, 70);
        printResult("testFilter_AllBogiesMatching", result6.size() == 2);

        // Test 7: Empty List
        List<Bogie> list7 = new ArrayList<>();
        List<Bogie> result7 = filterBogies(list7, 70);
        printResult("testFilter_EmptyBogieList", result7.isEmpty());

        // Test 8: Original List Unchanged
        List<Bogie> list8 = new ArrayList<>(Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC Chair", 60)
        ));
        filterBogies(list8, 70);
        printResult("testFilter_OriginalListUnchanged",
                list8.size() == 2 &&
                        list8.get(0).getName().equals("Sleeper") &&
                        list8.get(1).getName().equals("AC Chair"));
    }
}
