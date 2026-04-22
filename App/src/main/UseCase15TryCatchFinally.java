/**
 * UC15 - Safe Cargo Assignment Using try-catch-finally
 *
 * Goal: Safely handle unsafe cargo assignments without crashing the app.
 *
 * Key Concepts:
 *  - try block      : Contains code that may throw an exception
 *  - catch block    : Handles the thrown exception gracefully
 *  - finally block  : Always executes — used for cleanup or logging
 *  - Custom Exception: UnsafeCargoException thrown when cargo is incompatible
 *  - Graceful Degradation: App continues running even after an error
 *
 * Rules:
 *  - Cylindrical bogies → only "Liquid" cargo is safe
 *  - Rectangular bogies → "Solid" or "Liquid" cargo is safe
 *  - Any other combination → UnsafeCargoException is thrown
 *
 * Flow:
 *  1. User attempts to assign cargo to a goods bogie
 *  2. System checks shape and cargo compatibility
 *  3. If unsafe → exception is thrown
 *  4. Exception is caught in catch block
 *  5. Error message is displayed
 *  6. finally block executes cleanup/logging
 *  7. Program continues safely
 */
public class UseCase15TryCatchFinally {

    // -----------------------------------------------------------------------
    // Custom Exception: UnsafeCargoException
    // -----------------------------------------------------------------------
    static class UnsafeCargoException extends Exception {
        public UnsafeCargoException(String shape, String cargo) {
            super("Unsafe cargo assignment: '" + cargo
                    + "' cargo cannot be loaded into a '" + shape + "' bogie.");
        }
    }

    // -----------------------------------------------------------------------
    // GoodsBogie class
    // -----------------------------------------------------------------------
    static class GoodsBogie {
        String bogieId;
        String shape;     // "Cylindrical" or "Rectangular"
        String cargo;     // Assigned cargo type

        GoodsBogie(String bogieId, String shape) {
            this.bogieId = bogieId;
            this.shape   = shape;
            this.cargo   = null; // Not yet assigned
        }

        /**
         * Assigns cargo to the bogie with safety validation.
         * Throws UnsafeCargoException if incompatible.
         *
         * @param cargoType Cargo to assign
         * @throws UnsafeCargoException if the cargo is not safe for the bogie shape
         */
        public void assignCargo(String cargoType) throws UnsafeCargoException {
            // Compatibility rules
            if (shape.equals("Cylindrical") && !cargoType.equals("Liquid")) {
                throw new UnsafeCargoException(shape, cargoType);
            }
            if (shape.equals("Rectangular") && cargoType.equals("Gas")) {
                throw new UnsafeCargoException(shape, cargoType);
            }
            this.cargo = cargoType;
            System.out.println("  ✔ Cargo '" + cargoType
                    + "' assigned to bogie [" + bogieId + "]");
        }

        @Override
        public String toString() {
            return "[" + bogieId + "] Shape=" + shape + " Cargo=" + cargo;
        }
    }

    /**
     * Attempts to assign cargo with full try-catch-finally handling.
     */
    public static void performCargoAssignment(GoodsBogie bogie, String cargo) {
        System.out.println("\nAssigning '" + cargo + "' to "
                + bogie.bogieId + " (" + bogie.shape + ")...");
        try {
            // Step 1: Try to assign cargo
            bogie.assignCargo(cargo);
            System.out.println("  Result: Assignment successful.");
        } catch (UnsafeCargoException e) {
            // Step 2: Handle the exception gracefully
            System.out.println("  ✘ Error caught: " + e.getMessage());
            System.out.println("  Result: Assignment rejected — bogie remains safe.");
        } finally {
            // Step 3: Always runs — cleanup or logging
            System.out.println("  [LOG] Assignment attempt logged for bogie: "
                    + bogie.bogieId);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC15 - Safe Cargo Assignment Using try-catch-finally\n");

        GoodsBogie cylindrical = new GoodsBogie("G001", "Cylindrical");
        GoodsBogie rectangular = new GoodsBogie("G002", "Rectangular");

        // Safe: Liquid → Cylindrical ✔
        performCargoAssignment(cylindrical, "Liquid");

        // Unsafe: Solid → Cylindrical ✘
        performCargoAssignment(cylindrical, "Solid");

        // Unsafe: Gas → Cylindrical ✘
        performCargoAssignment(cylindrical, "Gas");

        // Safe: Solid → Rectangular ✔
        performCargoAssignment(rectangular, "Solid");

        // Unsafe: Gas → Rectangular ✘
        performCargoAssignment(rectangular, "Gas");

        System.out.println("\nProgram continues safely...");
    }
}
