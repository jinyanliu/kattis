import org.junit.jupiter.api.Assertions.assertEquals
import java.util.ArrayDeque

internal class MoneyMattersAltTest {
    @org.junit.jupiter.api.Test
    fun processInputs() {
        val queue1 = ArrayDeque<String>()
        listOf<String>("5 3", "100", "-75", "-25", "-42", "42", "0 1", "1 2", "3 4").forEach { queue1.add(it) }
        assertEquals("POSSIBLE", MoneyMattersAlt().processInputs(queue1))

        val queue2 = ArrayDeque<String>()
        listOf<String>("4 2", "15", "20", "-10", "-25", "0 2", "1 3").forEach { queue2.add(it) }
        assertEquals("IMPOSSIBLE", MoneyMattersAlt().processInputs(queue2))

        val queue3 = ArrayDeque<String>()
        listOf<String>("4 3", "15", "20", "-10", "-25", "0 2", "1 3", "0 3").forEach { queue2.add(it) }
        assertEquals("POSSIBLE", MoneyMattersAlt().processInputs(queue2))
    }
}