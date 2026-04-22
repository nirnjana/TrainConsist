import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC16 - Bubble Sort
 */
public class UseCase16BubbleSortTest {

    @Test
    @DisplayName("TC01 - Sorted array is in ascending order")
    void testAscendingOrder() {
        int[] arr = {72, 18, 90, 64, 8};
        UseCase16BubbleSort.bubbleSort(arr);
        assertArrayEquals(new int[]{8, 18, 64, 72, 90}, arr);
    }

    @Test
    @DisplayName("TC02 - Already sorted array remains sorted")
    void testAlreadySorted() {
        int[] arr = {8, 18, 64, 72, 90};
        UseCase16BubbleSort.bubbleSort(arr);
        assertArrayEquals(new int[]{8, 18, 64, 72, 90}, arr);
    }

    @Test
    @DisplayName("TC03 - Reverse-sorted array is fully sorted")
    void testReverseOrder() {
        int[] arr = {90, 72, 64, 18, 8};
        UseCase16BubbleSort.bubbleSort(arr);
        assertArrayEquals(new int[]{8, 18, 64, 72, 90}, arr);
    }

    @Test
    @DisplayName("TC04 - Single element array stays unchanged")
    void testSingleElement() {
        int[] arr = {42};
        UseCase16BubbleSort.bubbleSort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    @DisplayName("TC05 - Empty array does not throw")
    void testEmptyArray() {
        int[] arr = {};
        assertDoesNotThrow(() -> UseCase16BubbleSort.bubbleSort(arr));
    }

    @Test
    @DisplayName("TC06 - Duplicate values are handled correctly")
    void testDuplicates() {
        int[] arr = {72, 18, 72, 64, 18};
        UseCase16BubbleSort.bubbleSort(arr);
        assertArrayEquals(new int[]{18, 18, 64, 72, 72}, arr);
    }

    @Test
    @DisplayName("TC07 - First element is smallest after sort")
    void testFirstIsSmallest() {
        int[] arr = {90, 64, 8, 72, 54};
        UseCase16BubbleSort.bubbleSort(arr);
        assertEquals(8, arr[0]);
    }

    @Test
    @DisplayName("TC08 - Last element is largest after sort")
    void testLastIsLargest() {
        int[] arr = {90, 64, 8, 72, 54};
        UseCase16BubbleSort.bubbleSort(arr);
        assertEquals(90, arr[arr.length - 1]);
    }
}
