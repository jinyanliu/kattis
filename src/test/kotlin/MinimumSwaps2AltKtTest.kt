import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class MinimumSwaps2AltKtTest {

    @Test
    fun orderList_1() {
        val array = arrayOf(7, 1, 3, 2, 4, 5, 6)
        val result = orderList(array)
        assertTrue(result.contentDeepEquals(arrayOf(1, 2, 3, 4, 5, 6, 7)))
    }

    @Test
    fun orderList_2() {
        val array = arrayOf(4, 3, 1, 2)
        val result = orderList(array)
        assertTrue(result.contentDeepEquals(arrayOf(1, 2, 3, 4)))
    }

    @Test
    fun orderList_3() {
        val array = arrayOf(2, 3, 4, 1, 5)
        val result = orderList(array)
        assertTrue(result.contentDeepEquals(arrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun orderList_4() {
        val array = arrayOf(1, 3, 5, 2, 4, 6, 7)
        val result = orderList(array)
        assertTrue(result.contentDeepEquals(arrayOf(1, 2, 3, 4, 5, 6, 7)))
    }
}