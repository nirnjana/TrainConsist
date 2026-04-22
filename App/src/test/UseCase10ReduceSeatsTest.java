import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Test class for UC10 - Count Total Seats in Train Using reduce()
 */
public class UseCase10ReduceSeatsTest {

    private List<UseCase10ReduceSeats.Bogie> bogies;

    @BeforeEach
    void setUp() {
        bogies = new ArrayList<>();
        bogies.add(new UseCase10ReduceSeats.Bogie("Engine",      0));
        bogies.add(new UseCase10ReduceSeats.Bogie("Sleeper-1",  72));
        bogies.add(new UseCase10ReduceSeats.Bogie("Sleeper-2",  72));
        bogies.add(new UseCase10ReduceSeats.Bogie("AC Chair",   64));
        bogies.add(new UseCase10ReduceSeats.Bogie("Guard Van",   8));
    }

    @Test
    @DisplayName("TC01 - reduce(0, Integer::sum) gives correct total")
    void testReduceSum() {
        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
        assertEquals(216, total, "0+72+72+64+8 = 216");
    }

    @Test
    @DisplayName("TC02 - mapToInt().sum() gives same result")
    void testMapToIntSum() {
        int total = bogies.stream().mapToInt(b -> b.capacity).sum();
        assertEquals(216, total);
    }

    @Test
    @DisplayName("TC03 - Lambda accumulator gives same result")
    void testLambdaAccumulator() {
        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, (acc, cap) -> acc + cap);
        assertEquals(216, total);
    }

    @Test
    @DisplayName("TC04 - Empty list reduces to identity value 0")
    void testEmptyListReducesToZero() {
        List<UseCase10ReduceSeats.Bogie> empty = new ArrayList<>();
        int total = empty.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertEquals(0, total);
    }

    @Test
    @DisplayName("TC05 - All zero capacities sums to 0")
    void testAllZeroCapacities() {
        List<UseCase10ReduceSeats.Bogie> nonPassenger = new ArrayList<>();
        nonPassenger.add(new UseCase10ReduceSeats.Bogie("Engine",     0));
        nonPassenger.add(new UseCase10ReduceSeats.Bogie("Pantry Car", 0));
        int total = nonPassenger.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertEquals(0, total);
    }

    @Test
    @DisplayName("TC06 - Single bogie reduces to its own capacity")
    void testSingleBogie() {
        List<UseCase10ReduceSeats.Bogie> single = new ArrayList<>();
        single.add(new UseCase10ReduceSeats.Bogie("Sleeper", 72));
        int total = single.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertEquals(72, total);
    }
}
