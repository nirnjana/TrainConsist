import java.util.ArrayList;
import java.util.List;

/**
 * UC18 - Replace a Bogie in the Consist
 * Goal: Replace an existing bogie at a specific position with a new bogie.
 */
public class UseCase18ReplaceBogie {

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
     * Replaces the bogie at the given index with a new bogie.
     *
     * @param index     0-based index of the bogie to replace
     * @param bogieId   New bogie ID
     * @param type      New bogie type
     * @param capacity  New capacity
     * @return true if replaced, false if index is out of bounds
     */
    public boolean replaceBogie(int index, String bogieId, String type, int capacity) {
        if (index < 0 || index >= consist.size()) {
            System.out.println("✘ Invalid index: " + index);
            return false;
        }
        consist.set(index, new Bogie(bogieId, type, capacity));
        System.out.println("✔ Bogie at position " + (index + 1) + " replaced.");
        return true;
    }

    public int getBogieCount() {
        return consist.size();
    }

    public Bogie getBogie(int index) {
        if (index < 0 || index >= consist.size()) return null;
        return consist.get(index);
    }

    public void displayConsist() {
        System.out.println("\n=== Train Consist ===");
        for (int i = 0; i < consist.size(); i++) {
            System.out.println((i + 1) + ". " + consist.get(i));
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC18 - Replace a Bogie in the Consist\n");

        UseCase18ReplaceBogie mgmt = new UseCase18ReplaceBogie();
        mgmt.addBogie("B001", "Locomotive", 0);
        mgmt.addBogie("B002", "General", 90);
        mgmt.addBogie("B003", "Guard Van", 8);

        System.out.println("Before Replace:");
        mgmt.displayConsist();

        mgmt.replaceBogie(1, "B002-NEW", "First Class", 54);
        mgmt.replaceBogie(5, "B999", "Pantry Car", 0); // invalid index

        System.out.println("After Replace:");
        mgmt.displayConsist();
    }
}
