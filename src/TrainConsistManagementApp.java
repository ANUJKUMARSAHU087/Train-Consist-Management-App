import java.util.*;
import java.util.stream.*;

class Bogie {
    String type;
    int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Sample bogie list (can be reused from previous use cases)
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 40),
                new Bogie("Sleeper", 72)
        );

        // ✅ Stream pipeline: map + reduce
        int totalSeats = bogies.stream()
                .map(b -> b.getCapacity())   // Extract capacity
                .reduce(0, Integer::sum);   // Aggregate using reduce

        // Output
        System.out.println("Total Seating Capacity of Train: " + totalSeats);
    }
}