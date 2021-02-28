import java.util.Scanner

fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
    var resultCount = 0
    var currentSortedList = mutableListOf<Int>()
    var currentFirstItem: Int? = null

    val medianIndex: Pair<Int, Int> = if (d % 2 == 0) {
        (d / 2) - 1 to d / 2
    } else {
        (d - 1) / 2 to (d - 1) / 2
    }

    (d until expenditure.size).forEach {
        val previousFirstItem = currentFirstItem ?: -1
        currentFirstItem = expenditure[it - d]
        if (currentSortedList.isEmpty()) {
            currentSortedList = expenditure.toMutableList().subList(it - d, it).sorted().toMutableList()
        } else {
            if (previousFirstItem != expenditure[it - 1]) {
                currentSortedList.remove(previousFirstItem)
                var added = false
                for (i in currentSortedList.indices) {
                    if (currentSortedList[i] > expenditure[it - 1]) {
                        added = true
                        currentSortedList.add(i, expenditure[it - 1])
                        break
                    }
                }
                if (!added) {
                    currentSortedList.add(expenditure[it - 1])
                }
            }
        }

        val median = (currentSortedList[medianIndex.first] + currentSortedList[medianIndex.second]) / 2.0
        if (shouldNotify(median, expenditure[it].toDouble())) {
            resultCount += 1
        }
    }

    return resultCount
}

fun shouldNotify(median: Double, currentExpend: Double) = currentExpend >= median * 2

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nd = scan.nextLine().split(" ")

    val n = nd[0].trim().toInt()

    val d = nd[1].trim().toInt()

    val expenditure = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = activityNotifications(expenditure, d)

    println(result)
}

