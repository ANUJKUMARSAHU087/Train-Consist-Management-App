import java.util.*;

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
}

public class TrainConsistManagementAppTest {

    // Reduce method to calculate total seats
    public static int totalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)   // extract capacity
                .reduce(0, Integer::sum);  // sum all values
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

        // Test 1: Total Seat Calculation
        List<Bogie> list1 = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 100)
        );
        int total1 = totalSeats(list1);
        printResult("testReduce_TotalSeatCalculation", total1 == 240);

        // Test 2: Multiple Bogies Aggregation
        printResult("testReduce_MultipleBogiesAggregation", total1 == 240);

        // Test 3: Single Bogie
        List<Bogie> list3 = Arrays.asList(
                new Bogie("Sleeper", 80)
        );
        int total3 = totalSeats(list3);
        printResult("testReduce_SingleBogieCapacity", total3 == 80);

        // Test 4: Empty List
        List<Bogie> list4 = new ArrayList<>();
        int total4 = totalSeats(list4);
        printResult("testReduce_EmptyBogieList", total4 == 0);

        // Test 5: Correct Capacity Extraction
        List<Bogie> list5 = Arrays.asList(
                new Bogie("Sleeper", 50),
                new Bogie("AC Chair", 70)
        );
        int total5 = totalSeats(list5);
        printResult("testReduce_CorrectCapacityExtraction", total5 == 120);

        // Test 6: All Bogies Included
        List<Bogie> list6 = Arrays.asList(
                new Bogie("Sleeper", 40),
                new Bogie("Sleeper", 60),
                new Bogie("AC Chair", 30)
        );
        int total6 = totalSeats(list6);
        printResult("testReduce_AllBogiesIncluded", total6 == 130);

        // Test 7: Original List Unchanged
        List<Bogie> list7 = new ArrayList<>(Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC Chair", 60)
        ));
        totalSeats(list7);
        printResult("testReduce_OriginalListUnchanged",
                list7.size() == 2 &&
                        list7.get(0).getCapacity() == 80 &&
                        list7.get(1).getCapacity() == 60);
    }
}
