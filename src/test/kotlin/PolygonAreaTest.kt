import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.ArrayDeque

class PolygonAreaTest {
    @Test
    internal fun testProcessOneSection() {
        val section1 = listOf<String>("0 0", "10 0", "0 10")
        assertEquals(PolygonArea().processOneSection(section1), "ccw" to "50.0")
        val section2 = listOf<String>("41 -6", "-24 -74", "-51 -6", "73 17", "-30 -34")
        assertEquals(PolygonArea().processOneSection(section2), "cw" to "3817.5")
    }

    @Test
    fun processInputs() {
        val queue = ArrayDeque<String>()
        listOf(
            "3",
            "0 0",
            "10 0",
            "0 10",
            "5",
            "41 -6",
            "-24 -74",
            "-51 -6",
            "73 17",
            "-30 -34",
            "3",
            "0 0",
            "10 0",
            "0 10",
            "5",
            "41 -6",
            "-24 -74",
            "-51 -6",
            "73 17",
            "-30 -34"
        ).forEach { queue.add(it) }
        assertEquals(PolygonArea().processInputs(queue), listOf("ccw 50.0", "cw 3817.5", "ccw 50.0", "cw 3817.5"))
    }

    @Test
    internal fun testDecimal() {
        assertEquals(3.1, BigDecimal(3.189).setScale(1, RoundingMode.DOWN).toDouble())
    }
}