import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC14 - Handle Invalid Bogie Capacity
 */
public class UseCase14InvalidCapacityExceptionTest {

    @Test
    @DisplayName("TC01 - Valid capacity creates bogie successfully")
    void testValidCapacityCreatesBogie() {
        UseCase14InvalidCapacityException.PassengerBogie b =
                new UseCase14InvalidCapacityException.PassengerBogie("Sleeper", 72);
        assertEquals("Sleeper", b.name);
        assertEquals(72, b.capacity);
    }

    @Test
    @DisplayName("TC02 - Capacity 0 throws InvalidCapacityException")
    void testZeroCapacityThrows() {
        assertThrows(
                UseCase14InvalidCapacityException.InvalidCapacityException.class,
                () -> new UseCase14InvalidCapacityException.PassengerBogie("Bad", 0),
                "Capacity of 0 should throw InvalidCapacityException."
        );
    }

    @Test
    @DisplayName("TC03 - Negative capacity throws InvalidCapacityException")
    void testNegativeCapacityThrows() {
        assertThrows(
                UseCase14InvalidCapacityException.InvalidCapacityException.class,
                () -> new UseCase14InvalidCapacityException.PassengerBogie("Neg", -5)
        );
    }

    @Test
    @DisplayName("TC04 - Exception message contains the invalid value")
    void testExceptionMessage() {
        UseCase14InvalidCapacityException.InvalidCapacityException ex =
                assertThrows(
                        UseCase14InvalidCapacityException.InvalidCapacityException.class,
                        () -> new UseCase14InvalidCapacityException.PassengerBogie("Bad", -10)
                );
        assertTrue(ex.getMessage().contains("-10"),
                "Exception message should mention the invalid capacity value.");
    }

    @Test
    @DisplayName("TC05 - getInvalidCapacity() returns the actual bad value")
    void testGetInvalidCapacity() {
        UseCase14InvalidCapacityException.InvalidCapacityException ex =
                assertThrows(
                        UseCase14InvalidCapacityException.InvalidCapacityException.class,
                        () -> new UseCase14InvalidCapacityException.PassengerBogie("Bad", -99)
                );
        assertEquals(-99, ex.getInvalidCapacity());
    }

    @Test
    @DisplayName("TC06 - Capacity 1 (minimum valid) does not throw")
    void testMinValidCapacity() {
        assertDoesNotThrow(
                () -> new UseCase14InvalidCapacityException.PassengerBogie("Mini", 1)
        );
    }

    @Test
    @DisplayName("TC07 - InvalidCapacityException is a RuntimeException")
    void testExceptionIsRuntimeException() {
        UseCase14InvalidCapacityException.InvalidCapacityException ex =
                new UseCase14InvalidCapacityException.InvalidCapacityException(0);
        assertInstanceOf(RuntimeException.class, ex);
    }
}
