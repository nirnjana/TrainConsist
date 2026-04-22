import java.util.ArrayList;
import java.util.List;

/**
 * UC17 - Check if Consist Contains a Specific Bogie Type
 * Goal: Check whether the consist contains at least one bogie of a specific type.
 */
public class UseCase17ContainsBogieType {

    static class Bogie {
        String bogieId;
        String type;
        int capacity;

        Bogie(String bogieId, String type, int capacity) {
            this.bogieId = bogieId;
            this.type = type;
            this.capacity = capacity;
        }
    }

    private List<Bogie> consist = new ArrayList<>();

    public void addBogie(String bogieId, String type, int capacity) {
        consist.add(new Bogie(bogieId, type, capacity));
    }

    /**
     * Checks if the consist contains at least one bogie of the specified type.
     *
     * @param type The bogie type to check for
     * @return true if found, false otherwise
     */
    public boolean containsType(String type) {
        for (Bogie b : consist) {
            if (b.type.equalsIgnoreCase(type)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC17 - Check if Consist Contains a Specific Bogie Type\n");

        UseCase17ContainsBogieType mgmt = new UseCase17ContainsBogieType();
        mgmt.addBogie("B001", "Locomotive", 0);
        mgmt.addBogie("B002", "AC Sleeper", 72);
        mgmt.addBogie("B003", "General", 90);

        System.out.println("Contains 'AC Sleeper': " + mgmt.containsType("AC Sleeper"));
        System.out.println("Contains 'Guard Van'  : " + mgmt.containsType("Guard Van"));
        System.out.println("Contains 'Locomotive': " + mgmt.containsType("Locomotive"));
    }
}
