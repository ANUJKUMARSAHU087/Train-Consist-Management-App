import java.util.*;
import java.util.stream.Collectors;

// Base Bogie class
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

    @Override
    public String toString() {
        return "Bogie Type: " + type + ", Capacity: " + capacity;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Reusing Bogie list (like UC7)
        List<Bogie> bogieList = new ArrayList<>();

        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 60));
        bogieList.add(new Bogie("First Class", 40));
        bogieList.add(new Bogie("Sleeper", 80));
        bogieList.add(new Bogie("AC Chair", 75));

        System.out.println("All Bogies:");
        bogieList.forEach(System.out::println);

        // 🔹 Stream Filtering (UC8)
        List<Bogie> filteredBogies = bogieList.stream()
                .filter(b -> b.getCapacity() > 60)   // condition
                .collect(Collectors.toList());      // collect result

        System.out.println("\nFiltered Bogies (Capacity > 60):");
        filteredBogies.forEach(System.out::println);
    }
}