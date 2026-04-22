import java.util.ArrayList;
import java.util.List;

/**
 * UC20 - Generate Consist Report
 * Goal: Generate a comprehensive summary report of the train consist
 *       including total bogies, total capacity, type breakdown, and validation status.
 */
public class UseCase20ConsistReport {

    static class Bogie {
        String bogieId;
        String type;
        int capacity;

        Bogie(String bogieId, String type, int capacity) {
            this.bogieId = bogieId;
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return "[" + bogieId + "] Type: " + type + " | Capacity: " + capacity;
        }
    }

    private List<Bogie> consist = new ArrayList<>();
    private String trainName;

    public UseCase20ConsistReport(String trainName) {
        this.trainName = trainName;
    }

    public void addBogie(String bogieId, String type, int capacity) {
        consist.add(new Bogie(bogieId, type, capacity));
    }

    public int getBogieCount() {
        return consist.size();
    }

    public int getTotalCapacity() {
        int total = 0;
        for (Bogie b : consist) total += b.capacity;
        return total;
    }

    public int countByType(String type) {
        int count = 0;
        for (Bogie b : consist) {
            if (b.type.equalsIgnoreCase(type)) count++;
        }
        return count;
    }

    public boolean isValidConsist() {
        return countByType("Locomotive") == 1
                && countByType("Guard Van") >= 1
                && consist.stream().anyMatch(b -> b.capacity > 0);
    }

    /**
     * Generates and prints a full consist report.
     */
    public void generateReport() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║       TRAIN CONSIST REPORT           ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf("║ Train Name  : %-22s║%n", trainName);
        System.out.printf("║ Total Bogies: %-22d║%n", getBogieCount());
        System.out.printf("║ Total Capacity: %-20d║%n", getTotalCapacity());
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║         BOGIE BREAKDOWN              ║");
        System.out.println("╠══════════════════════════════════════╣");
        List<String> printed = new ArrayList<>();
        for (Bogie b : consist) {
            if (!printed.contains(b.type)) {
                System.out.printf("║  %-15s : %-18d║%n", b.type, countByType(b.type));
                printed.add(b.type);
            }
        }
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf("║ Consist Valid: %-21s║%n", isValidConsist() ? "YES ✔" : "NO  ✘");
        System.out.println("╚══════════════════════════════════════╝");
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC20 - Generate Consist Report\n");

        UseCase20ConsistReport mgmt = new UseCase20ConsistReport("Rajdhani Express");
        mgmt.addBogie("B001", "Locomotive", 0);
        mgmt.addBogie("B002", "AC Sleeper", 72);
        mgmt.addBogie("B003", "AC Sleeper", 72);
        mgmt.addBogie("B004", "First Class", 54);
        mgmt.addBogie("B005", "General", 90);
        mgmt.addBogie("B006", "Pantry Car", 0);
        mgmt.addBogie("B007", "Guard Van", 8);

        mgmt.generateReport();
    }
}
