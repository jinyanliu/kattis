import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class SpeedLimitKtTest {

    @Test
    fun processOneSection() {
        val inputs = listOf("20 2", "30 6", "10 7")
        assertEquals(processOneSection(inputs), 170)
    }

    @Test
    fun processInputs() {
        val myQueue = ArrayDeque<String>()
        arrayListOf<String>("3", "20 2", "30 6", "10 7", "2", "60 1", "30 5").forEach { myQueue.add(it) }
        assertEquals(processInputs(myQueue), listOf("170 miles", "180 miles"))
    }
}