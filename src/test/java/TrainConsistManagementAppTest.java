import java.util.*;

public class TrainConsistManagementAppTest {

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    // Safety Check Method
    public static boolean isSafe(List<GoodsBogie> goodsList) {
        return goodsList.stream().allMatch(b -> {
            if (b.type.equalsIgnoreCase("Cylindrical")) {
                return b.cargo.equalsIgnoreCase("Petroleum");
            }
            return true;
        });
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

        // Test 1: All Safe Bogies
        List<GoodsBogie> list1 = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Box", "Grain"),
                new GoodsBogie("Open", "Coal")
        );
        printResult("testSafety_AllValidBogies", isSafe(list1));

        // Test 2: Cylindrical with Wrong Cargo
        List<GoodsBogie> list2 = Arrays.asList(
                new GoodsBogie("Cylindrical", "Coal")
        );
        printResult("testSafety_InvalidCylindricalCargo", !isSafe(list2));

        // Test 3: Mixed Valid and Invalid
        List<GoodsBogie> list3 = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Coal"),
                new GoodsBogie("Box", "Grain")
        );
        printResult("testSafety_MixedBogies", !isSafe(list3));

        // Test 4: No Cylindrical Bogies
        List<GoodsBogie> list4 = Arrays.asList(
                new GoodsBogie("Box", "Grain"),
                new GoodsBogie("Open", "Coal")
        );
        printResult("testSafety_NoCylindricalBogies", isSafe(list4));

        // Test 5: Empty List
        List<GoodsBogie> list5 = new ArrayList<>();
        printResult("testSafety_EmptyList", isSafe(list5)); // true by default

        // Test 6: Case Insensitivity
        List<GoodsBogie> list6 = Arrays.asList(
                new GoodsBogie("cylindrical", "petroleum")
        );
        printResult("testSafety_CaseInsensitive", isSafe(list6));

        // Test 7: Multiple Cylindrical All Valid
        List<GoodsBogie> list7 = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Petroleum")
        );
        printResult("testSafety_AllCylindricalValid", isSafe(list7));

        // Test 8: Original List Unchanged
        List<GoodsBogie> list8 = new ArrayList<>(Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Box", "Grain")
        ));
        isSafe(list8);
        printResult("testSafety_OriginalListUnchanged",
                list8.size() == 2 &&
                list8.get(0).cargo.equals("Petroleum"));
    }
}
