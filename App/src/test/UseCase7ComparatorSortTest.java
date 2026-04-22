import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Test class for UC7 - Sort Bogies by Capacity Using Comparator
 */
public class UseCase7ComparatorSortTest {

    private List<UseCase7ComparatorSort.Bogie> bogies;

    @BeforeEach
    void setUp() {
        bogies = new ArrayList<>();
        bogies.add(new UseCase7ComparatorSort.Bogie("Sleeper",     72));
        bogies.add(new UseCase7ComparatorSort.Bogie("AC Chair",    64));
        bogies.add(new UseCase7ComparatorSort.Bogie("First Class", 18));
        bogies.add(new UseCase7ComparatorSort.Bogie("General",     90));
        bogies.add(new UseCase7ComparatorSort.Bogie("Guard Van",    8));
    }

    @Test
    @DisplayName("TC01 - List should have 5 bogies before sorting")
    void testInitialSize() {
        assertEquals(5, bogies.size());
    }

    @Test
    @DisplayName("TC02 - After ascending sort, first bogie has lowest capacity")
    void testAscendingSortFirstElement() {
        bogies.sort(Comparator.comparingInt(b -> b.capacity));
        assertEquals(8, bogies.get(0).capacity,
                "Smallest capacity (8) should be first.");
        assertEquals("Guard Van", bogies.get(0).name);
    }

    @Test
    @DisplayName("TC03 - After ascending sort, last bogie has highest capacity")
    void testAscendingSortLastElement() {
        bogies.sort(Comparator.comparingInt(b -> b.capacity));
        assertEquals(90, bogies.get(bogies.size() - 1).capacity,
                "Largest capacity (90) should be last.");
        assertEquals("General", bogies.get(bogies.size() - 1).name);
    }

    @Test
    @DisplayName("TC04 - Ascending sort produces correct full order")
    void testAscendingOrder() {
        bogies.sort(Comparator.comparingInt(b -> b.capacity));
        int[] expected = {8, 18, 64, 72, 90};
        for (int i = 0; i < bogies.size(); i++) {
            assertEquals(expected[i], bogies.get(i).capacity,
                    "Position " + i + " should have capacity " + expected[i]);
        }
    }

    @Test
    @DisplayName("TC05 - After descending sort, first bogie has highest capacity")
    void testDescendingSortFirstElement() {
        bogies.sort(Comparator.comparingInt((UseCase7ComparatorSort.Bogie b) -> b.capacity).reversed());
        assertEquals(90, bogies.get(0).capacity,
                "Largest capacity (90) should be first in descending order.");
    }

    @Test
    @DisplayName("TC06 - Descending sort produces correct full order")
    void testDescendingOrder() {
        bogies.sort(Comparator.comparingInt((UseCase7ComparatorSort.Bogie b) -> b.capacity).reversed());
        int[] expected = {90, 72, 64, 18, 8};
        for (int i = 0; i < bogies.size(); i++) {
            assertEquals(expected[i], bogies.get(i).capacity,
                    "Position " + i + " should have capacity " + expected[i]);
        }
    }

    @Test
    @DisplayName("TC07 - Sort does not change list size")
    void testSortDoesNotChangeSize() {
        bogies.sort(Comparator.comparingInt(b -> b.capacity));
        assertEquals(5, bogies.size(),
                "Sort should not add or remove any elements.");
    }

    @Test
    @DisplayName("TC08 - Bogie name and capacity are correctly stored")
    void testBogieFields() {
        UseCase7ComparatorSort.Bogie b = new UseCase7ComparatorSort.Bogie("Sleeper", 72);
        assertEquals("Sleeper", b.name);
        assertEquals(72, b.capacity);
    }
}
