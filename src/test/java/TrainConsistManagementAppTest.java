import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }
}

public class TrainConsistManagementAppTest {

    // Grouping method
    public static Map<String, List<Bogie>> groupBogies(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));
    }

    // Helper method
    public static void printResult(String testName, boolean result) {
        if (result) {
            System.out.println(testName + " → PASSED");
        } else {
            System.out.println(testName + " → FAILED");
        }
    }

    public static void main(String[] args) {

        // Test 1: Bogies Grouped By Type
        List<Bogie> list1 = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("Sleeper", 75),
                new Bogie("AC Chair", 60)
        );
        Map<String, List<Bogie>> result1 = groupBogies(list1);
        printResult("testGrouping_BogiesGroupedByType",
                result1.containsKey("Sleeper") && result1.get("Sleeper").size() == 2);

        // Test 2: Multiple Bogies in Same Group
        printResult("testGrouping_MultipleBogiesInSameGroup",
                result1.get("Sleeper").size() == 2);

        // Test 3: Different Bogie Types
        printResult("testGrouping_DifferentBogieTypes",
                result1.size() == 2);

        // Test 4: Empty Bogie List
        List<Bogie> list4 = new ArrayList<>();
        Map<String, List<Bogie>> result4 = groupBogies(list4);
        printResult("testGrouping_EmptyBogieList",
                result4.isEmpty());

        // Test 5: Single Bogie Category
        List<Bogie> list5 = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("Sleeper", 90)
        );
        Map<String, List<Bogie>> result5 = groupBogies(list5);
        printResult("testGrouping_SingleBogieCategory",
                result5.size() == 1 && result5.containsKey("Sleeper"));

        // Test 6: Map Contains Correct Keys
        List<Bogie> list6 = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 100)
        );
        Map<String, List<Bogie>> result6 = groupBogies(list6);
        printResult("testGrouping_MapContainsCorrectKeys",
                result6.containsKey("Sleeper") &&
                result6.containsKey("AC Chair") &&
                result6.containsKey("First Class"));

        // Test 7: Group Size Validation
        List<Bogie> list7 = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60)
        );
        Map<String, List<Bogie>> result7 = groupBogies(list7);
        printResult("testGrouping_GroupSizeValidation",
                result7.get("Sleeper").size() == 2);

        // Test 8: Original List Unchanged
        List<Bogie> list8 = new ArrayList<>(Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC Chair", 60)
        ));
        groupBogies(list8);
        printResult("testGrouping_OriginalListUnchanged",
                list8.size() == 2 &&
                list8.get(0).getName().equals("Sleeper") &&
                list8.get(1).getName().equals("AC Chair"));
    }
}
