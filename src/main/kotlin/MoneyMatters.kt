import java.util.ArrayDeque

fun main() {
    val inputs = MoneyMatters().getInputs()
    println(MoneyMatters().processInputs(inputs))
}

class MoneyMatters {
    fun getInputs(): ArrayDeque<String> {
        val queue = ArrayDeque<String>()
        var line = readLine()
        while (!line.isNullOrBlank()) {
            queue.add(line)
            line = readLine()
        }
        return queue
    }

    fun processInputs(queue: ArrayDeque<String>): String {
        val indicators = queue.pollFirst()
        val (moneysCount, friendshipsCount) = indicators.split(" ").map { it.toInt() }
        val moneyLogs = arrayListOf<Int>()
        val friendshipLogs = arrayListOf<Pair<Int, Int>>()
        repeat(moneysCount) {
            moneyLogs.add(queue.pollFirst().toInt())
        }
        repeat(friendshipsCount) {
            friendshipLogs.add(queue.pollFirst().split(" ").map { it.toInt() }.zipWithNext()[0])
        }
        val friendshipsMap = mutableMapOf<Int, MutableSet<Int>>()
        for (friendshipLog in friendshipLogs) {
            if (friendshipsMap[friendshipLog.first] == null) {
                friendshipsMap[friendshipLog.first] = mutableSetOf(friendshipLog.second)
            } else {
                friendshipsMap[friendshipLog.first]?.add(friendshipLog.second)
            }
        }
        val even = calculateMoney(moneyLogs, friendshipsMap)
        return if (even) "POSSIBLE" else "IMPOSSIBLE"
    }

    fun calculateMoney(moneyLogs: List<Int>, friendships: Map<Int, MutableSet<Int>>): Boolean {
        val mapOfCurrentMoney = mutableMapOf<Int, Int>()
        moneyLogs.withIndex().map { mapOfCurrentMoney[it.index] = it.value }

        for (he in moneyLogs.indices) {
            val friendsQueue = ArrayDeque<Int>()
            friendships[he]?.forEach { friendsQueue.add(it) }
            while (!friendsQueue.isNullOrEmpty()) {
                val hisCurrentMoney = mapOfCurrentMoney[he]!!
                val singleFriend = friendsQueue.pollFirst()
                val friendMonday = mapOfCurrentMoney[singleFriend]!!

                val balance = hisCurrentMoney + friendMonday
                mapOfCurrentMoney[he] = 0
                mapOfCurrentMoney[singleFriend] = balance
            }
        }

        return mapOfCurrentMoney.count { it.value != 0 } == 0
    }
}