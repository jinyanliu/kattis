import java.util.ArrayDeque

fun main() {
    val inputs = MoneyMattersAlt().getInputs()
    println(MoneyMattersAlt().processInputs(inputs))
}

class MoneyMattersAlt {
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

        val qu = QuickUnion(moneysCount)
        friendshipLogs.forEach { qu.union(it.first, it.second) }
        val groupToIds = mutableMapOf<Int, MutableSet<Int>>()
        for (i in 0 until moneysCount) {
            val groupId = qu.getRoot(i)
            groupToIds.get(groupId)?.add(i) ?: groupToIds.put(groupId, mutableSetOf(i))
        }

        val even = calculateMoney(groupToIds.values.toList(), moneyLogs)
        return if (even) "POSSIBLE" else "IMPOSSIBLE"
    }

    fun calculateMoney(friendshipsGroups: List<MutableSet<Int>>, moneyLogs: List<Int>): Boolean {
        for (friendshipGroup in friendshipsGroups) {
            if (friendshipGroup.sumBy { moneyLogs[it] } != 0) {
                return false
            }
        }
        return true
    }

    class QuickUnion(n: Int) {
        private var parent: IntArray = IntArray(n)


        init {
            for (i in 0 until n) {
                parent[i] = i
            }
        }

        fun getRoot(p: Int): Int {
            var idx = p

            var isRoot = idx == parent[idx]

            while (!isRoot) {
                idx = parent[idx]
                isRoot = idx == parent[idx]
            }
            return idx
        }

        fun union(p: Int, q: Int) {
            val rootP = getRoot(p)
            val rootQ = getRoot(q)
            if (rootP == rootQ) return
            parent[rootP] = rootQ
        }
    }
}

