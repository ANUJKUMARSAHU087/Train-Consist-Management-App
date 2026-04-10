import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementAppTest {

    static class Bogie {
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

    // Loop-based filtering
    public static List<Bogie> filterUsingLoop(List<Bogie> list) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : list) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream-based filtering
    public static List<Bogie> filterUsingStream(List<Bogie> list) {
        return list.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    // Helper
    public static void printResult(String testName, boolean result) {
        if (result) {
            System.out.println(testName + " → PASSED");
        } else {
            System.out.println(testName + " → FAILED");
        }
    }

    public static void main(String[] args) {

        // Create dataset
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Sleeper", (i % 100) + 1));
        }

        // Loop Timing
        long startLoop = System.nanoTime();
        List<Bogie> loopResult = filterUsingLoop(bogies);
        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // Stream Timing
        long startStream = System.nanoTime();
        List<Bogie> streamResult = filterUsingStream(bogies);
        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // Test 1: Loop Filtering Logic
        printResult("testLoopFilteringLogic",
                loopResult.stream().allMatch(b -> b.getCapacity() > 60));

        // Test 2: Stream Filtering Logic
        printResult("testStreamFilteringLogic",
                streamResult.stream().allMatch(b -> b.getCapacity() > 60));

        // Test 3: Results Match
        printResult("testLoopAndStreamResultsMatch",
                loopResult.size() == streamResult.size());

        // Test 4: Execution Time Measurement
        printResult("testExecutionTimeMeasurement",
                loopTime > 0 && streamTime > 0);

        // Test 5: Large Dataset Processing
        printResult("testLargeDatasetProcessing",
                loopResult.size() > 0 && streamResult.size() > 0);

        // Display performance
        System.out.println("\nPerformance Comparison:");
        System.out.println("Loop Time   : " + loopTime + " ns");
        System.out.println("Stream Time : " + streamTime + " ns");

        if (loopTime < streamTime) {
            System.out.println("Loop is faster in this run.");
        } else {
            System.out.println("Stream is faster in this run.");
        }
    }
}
