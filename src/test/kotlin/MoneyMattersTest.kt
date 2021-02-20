import org.junit.jupiter.api.Assertions.assertEquals
import java.util.ArrayDeque

internal class MoneyMattersTest {

    @org.junit.jupiter.api.Test
    fun processInputs() {
        val queue1 = ArrayDeque<String>()
        listOf<String>("5 3", "100", "-75", "-25", "-42", "42", "0 1", "1 2", "3 4").forEach { queue1.add(it) }
        assertEquals("POSSIBLE", MoneyMatters().processInputs(queue1))

        val queue2 = ArrayDeque<String>()
        listOf<String>("4 2", "15", "20", "-10", "-25", "0 2", "1 3").forEach { queue2.add(it) }
        assertEquals("IMPOSSIBLE", MoneyMatters().processInputs(queue2))
    }

    @org.junit.jupiter.api.Test
    fun calculateMoney() {
        val moneyLogs1 = listOf<Int>(100, -75, -25, -42, 42)
        val map1 = mutableMapOf<Int, MutableSet<Int>>()
        listOf<Pair<Int, Int>>(0 to 1, 1 to 2, 3 to 4).forEach { map1[it.first] = mutableSetOf<Int>(it.second) }
        assertEquals(true, MoneyMatters().calculateMoney(moneyLogs1, map1))

        val moneyLogs2 = listOf<Int>(15, 20, -10, -25)
        val map2 = mutableMapOf<Int, MutableSet<Int>>()
        listOf<Pair<Int, Int>>(0 to 2, 1 to 3).forEach { map2[it.first] = mutableSetOf<Int>(it.second) }
        assertEquals(false, MoneyMatters().calculateMoney(moneyLogs2, map2))
    }
}