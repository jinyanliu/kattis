import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class FrequencyQueriesKtTest {
    @Test
    fun freqQuery_1() {
        val array = arrayOf(
            arrayOf(1, 1),
            arrayOf(2, 2),
            arrayOf(3, 2),
            arrayOf(1, 1),
            arrayOf(1, 1),
            arrayOf(2, 1),
            arrayOf(3, 2)
        )
        val result = freqQuery(array)
        assertTrue(result.contentDeepEquals(arrayOf(0, 1)))
    }

    @Test
    fun freqQuery_2() {
        val array = arrayOf(
            arrayOf(1, 5),
            arrayOf(1, 6),
            arrayOf(3, 2),
            arrayOf(1, 10),
            arrayOf(1, 10),
            arrayOf(1, 6),
            arrayOf(2, 5),
            arrayOf(3, 2)
        )
        val result = freqQuery(array)
        assertTrue(result.contentDeepEquals(arrayOf(0, 1)))
    }

    @Test
    fun freqQuery_3() {
        val array = arrayOf(
            arrayOf(3, 4),
            arrayOf(2, 1003),
            arrayOf(1, 16),
            arrayOf(3, 1)
        )
        val result = freqQuery(array)
        assertTrue(result.contentDeepEquals(arrayOf(0, 1)))
    }

    @Test
    fun freqQuery_4() {
        val array = arrayOf(
            arrayOf(1, 3),
            arrayOf(2, 3),
            arrayOf(3, 2),
            arrayOf(1, 4),
            arrayOf(1, 5),
            arrayOf(1, 5),
            arrayOf(1, 4),
            arrayOf(3, 2),
            arrayOf(2, 4),
            arrayOf(3, 2)
        )
        val result = freqQuery(array)
        assertTrue(result.contentDeepEquals(arrayOf(0, 1, 1)))
    }
}