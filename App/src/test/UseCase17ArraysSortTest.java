import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

/**
 * Test class for UC17 - Sort Bogie Names Using Arrays.sort()
 */
public class UseCase17ArraysSortTest {

    @Test
    @DisplayName("TC01 - Arrays.sort() produces alphabetical order")
    void testAlphabeticalSort() {
        String[] arr = {"Sleeper", "Guard Van", "AC Chair", "Engine"};
        Arrays.sort(arr);
        assertArrayEquals(new String[]{"AC Chair", "Engine", "Guard Van", "Sleeper"}, arr);
    }

    @Test
    @DisplayName("TC02 - First element is alphabetically earliest")
    void testFirstElementIsEarliest() {
        String[] arr = {"Sleeper", "AC Chair", "General", "Engine"};
        Arrays.sort(arr);
        assertEquals("AC Chair", arr[0]);
    }

    @Test
    @DisplayName("TC03 - Last element is alphabetically latest")
    void testLastElementIsLatest() {
        String[] arr = {"Sleeper", "AC Chair", "General", "Engine"};
        Arrays.sort(arr);
        assertEquals("Sleeper", arr[arr.length - 1]);
    }

    @Test
    @DisplayName("TC04 - Already sorted array stays unchanged")
    void testAlreadySorted() {
        String[] arr = {"AC Chair", "Engine", "Guard Van", "Sleeper"};
        String[] copy = arr.clone();
        Arrays.sort(arr);
        assertArrayEquals(copy, arr);
    }

    @Test
    @DisplayName("TC05 - Single element array remains unchanged")
    void testSingleElement() {
        String[] arr = {"Engine"};
        Arrays.sort(arr);
        assertArrayEquals(new String[]{"Engine"}, arr);
    }

    @Test
    @DisplayName("TC06 - Sort does not change array length")
    void testSizePreserved() {
        String[] arr = {"Sleeper", "Engine", "Guard Van"};
        Arrays.sort(arr);
        assertEquals(3, arr.length);
    }

    @Test
    @DisplayName("TC07 - Sorting a copy does not affect the original")
    void testCopyIndependent() {
        String[] original = {"Sleeper", "Engine", "Guard Van"};
        String[] sorted = Arrays.copyOf(original, original.length);
        Arrays.sort(sorted);
        // Original should remain unchanged
        assertEquals("Sleeper", original[0]);
        assertEquals("Engine",  original[1]);
    }
}
