import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;

/**
 * Test class for UC4 - Maintain Ordered Bogie Consist Using LinkedList
 */
public class UseCase4LinkedListConsistTest {

    private LinkedList<String> consist;

    @BeforeEach
    void setUp() {
        consist = new LinkedList<>();
        consist.addLast("Engine");
        consist.addLast("Sleeper");
        consist.addLast("AC");
        consist.addLast("Cargo");
        consist.addLast("Guard");
    }

    @Test
    @DisplayName("TC01 - Initial consist should have 5 bogies")
    void testInitialSize() {
        assertEquals(5, consist.size(),
                "Should have 5 bogies after setup.");
    }

    @Test
    @DisplayName("TC02 - addFirst() places element at index 0")
    void testAddFirst() {
        consist.addFirst("New Engine");
        assertEquals("New Engine", consist.getFirst(),
                "addFirst() should place element at head.");
        assertEquals(6, consist.size());
    }

    @Test
    @DisplayName("TC03 - addLast() places element at end")
    void testAddLast() {
        consist.addLast("Brake Van");
        assertEquals("Brake Van", consist.getLast(),
                "addLast() should place element at tail.");
        assertEquals(6, consist.size());
    }

    @Test
    @DisplayName("TC04 - add(index, element) inserts at correct position")
    void testAddAtIndex() {
        consist.add(2, "Pantry Car");
        assertEquals("Pantry Car", consist.get(2),
                "Pantry Car should be at index 2.");
        assertEquals(6, consist.size(),
                "Size should be 6 after insertion.");
    }

    @Test
    @DisplayName("TC05 - add(index) shifts existing elements correctly")
    void testAddAtIndexShiftsElements() {
        consist.add(2, "Pantry Car");
        // Before: Engine(0), Sleeper(1), AC(2), Cargo(3), Guard(4)
        // After:  Engine(0), Sleeper(1), Pantry Car(2), AC(3), Cargo(4), Guard(5)
        assertEquals("Sleeper",   consist.get(1));
        assertEquals("Pantry Car", consist.get(2));
        assertEquals("AC",        consist.get(3));
    }

    @Test
    @DisplayName("TC06 - removeFirst() removes head and returns it")
    void testRemoveFirst() {
        String removed = consist.removeFirst();
        assertEquals("Engine", removed,
                "removeFirst() should remove and return 'Engine'.");
        assertEquals(4, consist.size());
        assertEquals("Sleeper", consist.getFirst(),
                "New head should be 'Sleeper'.");
    }

    @Test
    @DisplayName("TC07 - removeLast() removes tail and returns it")
    void testRemoveLast() {
        String removed = consist.removeLast();
        assertEquals("Guard", removed,
                "removeLast() should remove and return 'Guard'.");
        assertEquals(4, consist.size());
        assertEquals("Cargo", consist.getLast(),
                "New tail should be 'Cargo'.");
    }

    @Test
    @DisplayName("TC08 - Order is preserved after insertions and removals")
    void testOrderAfterOperations() {
        consist.add(2, "Pantry Car");  // Insert at 2
        consist.removeFirst();          // Remove Engine
        consist.removeLast();           // Remove Guard
        // Remaining: Sleeper, Pantry Car, AC, Cargo
        assertEquals("Sleeper",    consist.get(0));
        assertEquals("Pantry Car", consist.get(1));
        assertEquals("AC",         consist.get(2));
        assertEquals("Cargo",      consist.get(3));
        assertEquals(4, consist.size());
    }

    @Test
    @DisplayName("TC09 - Insertion order matches adding sequence")
    void testInsertionOrderPreserved() {
        assertEquals("Engine",  consist.get(0));
        assertEquals("Sleeper", consist.get(1));
        assertEquals("AC",      consist.get(2));
        assertEquals("Cargo",   consist.get(3));
        assertEquals("Guard",   consist.get(4));
    }
}
