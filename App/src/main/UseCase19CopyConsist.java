import java.util.ArrayList;
import java.util.List;

/**
 * UC19 - Copy Consist to Another Train
 * Goal: Copy all bogies from one train consist to another (clone operation).
 */
public class UseCase19CopyConsist {

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

    public void addBogie(String bogieId, String type, int capacity) {
        consist.add(new Bogie(bogieId, type, capacity));
    }

    /**
     * Copies contents of this consist into the target consist.
     *
     * @param target The target UseCase19CopyConsist to copy into
     */
    public void copyTo(UseCase19CopyConsist target) {
        for (Bogie b : consist) {
            target.addBogie(b.bogieId, b.type, b.capacity);
        }
        System.out.println("Consist copied. " + consist.size() + " bogies transferred.");
    }

    public int getBogieCount() {
        return consist.size();
    }

    public void displayConsist(String label) {
        System.out.println("\n=== " + label + " ===");
        if (consist.isEmpty()) {
            System.out.println("  (empty)");
        } else {
            for (int i = 0; i < consist.size(); i++) {
                System.out.println((i + 1) + ". " + consist.get(i));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC19 - Copy Consist to Another Train\n");

        UseCase19CopyConsist source = new UseCase19CopyConsist();
        source.addBogie("B001", "Locomotive", 0);
        source.addBogie("B002", "AC Sleeper", 72);
        source.addBogie("B003", "Guard Van", 8);

        UseCase19CopyConsist destination = new UseCase19CopyConsist();

        source.displayConsist("Source Train");
        destination.displayConsist("Destination Train (before copy)");

        source.copyTo(destination);

        destination.displayConsist("Destination Train (after copy)");
    }
}
