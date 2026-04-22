import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Test class for UC9 - Group Bogies by Type
 */
public class UseCase9GroupByTypeTest {

    private List<UseCase9GroupByType.Bogie> bogies;

    @BeforeEach
    void setUp() {
        bogies = new ArrayList<>();
        bogies.add(new UseCase9GroupByType.Bogie("Sleeper-1",  "Passenger",    72));
        bogies.add(new UseCase9GroupByType.Bogie("Sleeper-2",  "Passenger",    72));
        bogies.add(new UseCase9GroupByType.Bogie("AC Chair",   "Passenger",    64));
        bogies.add(new UseCase9GroupByType.Bogie("Engine",     "NonPassenger",  0));
        bogies.add(new UseCase9GroupByType.Bogie("Guard Van",  "NonPassenger",  8));
        bogies.add(new UseCase9GroupByType.Bogie("Coal Wagon", "Goods",         0));
    }

    @Test
    @DisplayName("TC01 - groupingBy produces 3 distinct groups")
    void testGroupCount() {
        Map<String, List<UseCase9GroupByType.Bogie>> grouped =
                bogies.stream().collect(Collectors.groupingBy(b -> b.type));
        assertEquals(3, grouped.size(), "Should have 3 groups: Passenger, NonPassenger, Goods.");
    }

    @Test
    @DisplayName("TC02 - Passenger group contains 3 bogies")
    void testPassengerGroupSize() {
        Map<String, List<UseCase9GroupByType.Bogie>> grouped =
                bogies.stream().collect(Collectors.groupingBy(b -> b.type));
        assertEquals(3, grouped.get("Passenger").size());
    }

    @Test
    @DisplayName("TC03 - NonPassenger group contains 2 bogies")
    void testNonPassengerGroupSize() {
        Map<String, List<UseCase9GroupByType.Bogie>> grouped =
                bogies.stream().collect(Collectors.groupingBy(b -> b.type));
        assertEquals(2, grouped.get("NonPassenger").size());
    }

    @Test
    @DisplayName("TC04 - Goods group contains 1 bogie")
    void testGoodsGroupSize() {
        Map<String, List<UseCase9GroupByType.Bogie>> grouped =
                bogies.stream().collect(Collectors.groupingBy(b -> b.type));
        assertEquals(1, grouped.get("Goods").size());
    }

    @Test
    @DisplayName("TC05 - groupingBy with counting() returns correct counts")
    void testGroupingByCount() {
        Map<String, Long> counts = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.type, Collectors.counting()));
        assertEquals(3L, counts.get("Passenger"));
        assertEquals(2L, counts.get("NonPassenger"));
        assertEquals(1L, counts.get("Goods"));
    }

    @Test
    @DisplayName("TC06 - Original list is not modified by groupingBy")
    void testOriginalListUnchanged() {
        bogies.stream().collect(Collectors.groupingBy(b -> b.type));
        assertEquals(6, bogies.size());
    }

    @Test
    @DisplayName("TC07 - groupingBy on empty list returns empty map")
    void testEmptyListGrouping() {
        List<UseCase9GroupByType.Bogie> empty = new ArrayList<>();
        Map<String, List<UseCase9GroupByType.Bogie>> grouped =
                empty.stream().collect(Collectors.groupingBy(b -> b.type));
        assertTrue(grouped.isEmpty());
    }
}
