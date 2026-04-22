import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC15 - Safe Cargo Assignment Using try-catch-finally
 */
public class UseCase15TryCatchFinallyTest {

    @Test
    @DisplayName("TC01 - Liquid cargo to Cylindrical bogie succeeds")
    void testLiquidCylindricalSuccess() {
        UseCase15TryCatchFinally.GoodsBogie bogie =
                new UseCase15TryCatchFinally.GoodsBogie("G001", "Cylindrical");
        assertDoesNotThrow(() -> bogie.assignCargo("Liquid"));
        assertEquals("Liquid", bogie.cargo);
    }

    @Test
    @DisplayName("TC02 - Solid cargo to Cylindrical bogie throws exception")
    void testSolidCylindricalThrows() {
        UseCase15TryCatchFinally.GoodsBogie bogie =
                new UseCase15TryCatchFinally.GoodsBogie("G002", "Cylindrical");
        assertThrows(UseCase15TryCatchFinally.UnsafeCargoException.class,
                () -> bogie.assignCargo("Solid"));
    }

    @Test
    @DisplayName("TC03 - Gas cargo to Cylindrical bogie throws exception")
    void testGasCylindricalThrows() {
        UseCase15TryCatchFinally.GoodsBogie bogie =
                new UseCase15TryCatchFinally.GoodsBogie("G003", "Cylindrical");
        assertThrows(UseCase15TryCatchFinally.UnsafeCargoException.class,
                () -> bogie.assignCargo("Gas"));
    }

    @Test
    @DisplayName("TC04 - Solid cargo to Rectangular bogie succeeds")
    void testSolidRectangularSuccess() {
        UseCase15TryCatchFinally.GoodsBogie bogie =
                new UseCase15TryCatchFinally.GoodsBogie("G004", "Rectangular");
        assertDoesNotThrow(() -> bogie.assignCargo("Solid"));
        assertEquals("Solid", bogie.cargo);
    }

    @Test
    @DisplayName("TC05 - Gas cargo to Rectangular bogie throws exception")
    void testGasRectangularThrows() {
        UseCase15TryCatchFinally.GoodsBogie bogie =
                new UseCase15TryCatchFinally.GoodsBogie("G005", "Rectangular");
        assertThrows(UseCase15TryCatchFinally.UnsafeCargoException.class,
                () -> bogie.assignCargo("Gas"));
    }

    @Test
    @DisplayName("TC06 - Exception message includes shape and cargo type")
    void testExceptionMessage() {
        UseCase15TryCatchFinally.GoodsBogie bogie =
                new UseCase15TryCatchFinally.GoodsBogie("G006", "Cylindrical");
        UseCase15TryCatchFinally.UnsafeCargoException ex = assertThrows(
                UseCase15TryCatchFinally.UnsafeCargoException.class,
                () -> bogie.assignCargo("Solid")
        );
        assertTrue(ex.getMessage().contains("Solid"));
        assertTrue(ex.getMessage().contains("Cylindrical"));
    }

    @Test
    @DisplayName("TC07 - After failed assignment, cargo remains null")
    void testCargoRemainsNullAfterFailure() {
        UseCase15TryCatchFinally.GoodsBogie bogie =
                new UseCase15TryCatchFinally.GoodsBogie("G007", "Cylindrical");
        try {
            bogie.assignCargo("Gas");
        } catch (UseCase15TryCatchFinally.UnsafeCargoException ignored) { }
        assertNull(bogie.cargo, "Cargo should remain null after failed assignment.");
    }
}
