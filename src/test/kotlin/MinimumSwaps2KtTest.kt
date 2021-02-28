import org.junit.jupiter.api.Assertions.assertEquals

internal class MinimumSwaps2KtTest {

    @org.junit.jupiter.api.Test
    fun minimumSwaps_1() {
        val array = arrayOf(7, 1, 3, 2, 4, 5, 6)
        val result = minimumSwaps(array)
        assertEquals(5, result)
    }

    @org.junit.jupiter.api.Test
    fun minimumSwaps_2() {
        val array = arrayOf(4,3,1,2)
        val result = minimumSwaps(array)
        assertEquals(3, result)
    }

    @org.junit.jupiter.api.Test
    fun minimumSwaps_3() {
        val array = arrayOf(2,3,4,1,5)
        val result = minimumSwaps(array)
        assertEquals(3, result)
    }

    @org.junit.jupiter.api.Test
    fun minimumSwaps_4() {
        val array = arrayOf(1,3,5,2,4,6,7)
        val result = minimumSwaps(array)
        assertEquals(3, result)
    }
}