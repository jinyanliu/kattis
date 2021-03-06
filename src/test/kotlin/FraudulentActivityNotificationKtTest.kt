import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FraudulentActivityNotificationsKtTest {

    @Test
    fun activityNotifications_1() {
        val array = arrayOf(10, 20, 30, 40, 50)
        val d = 3
        val result = activityNotifications(array, d)
        assertEquals(1, result)
    }

    @Test
    fun activityNotifications_2() {
        val array = arrayOf(2, 3, 4, 2, 3, 6, 8, 4, 5)
        val d = 5
        val result = activityNotifications(array, d)
        assertEquals(2, result)
    }

    @Test
    fun activityNotifications_3() {
        val array = arrayOf(1, 2, 3, 4, 4)
        val d = 4
        val result = activityNotifications(array, d)
        assertEquals(0, result)
    }

    @Test
    fun testWindowed() {
        val array = arrayOf(1, 2, 3, 4, 4)
        println(array.asSequence().windowed(4, 1).toList())
    }

    @Test
    fun testArrayAdd() {
        val array = mutableListOf<Int>(1, 2, 3, 4, 4)
        array.add(2, 8)
        println(array)
    }

    @Test
    fun testForEachTerminates() {
        val array = mutableListOf<Int>(1, 2, 3, 4, 4)
        array.forEach {
            println(it)
            if(it==3) return@forEach
        }
        println(array)
    }
}