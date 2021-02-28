import java.util.Scanner

fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
    val expenditureList = expenditure.toMutableList()
    var resultCount = 0

    repeat(expenditure.size - d) {
        val sortedList = expenditureList.subList(0, d).sorted()
        val median: Double = if (d % 2 == 0) {
            val (firstNumber, secondNumber) = d / 2 - 1 to d / 2
            (sortedList[firstNumber] + sortedList[secondNumber]) / 2.0
        } else {
            val medianIndex = (d - 1) / 2
            sortedList[medianIndex].toDouble()
        }
        if (shouldNotify(median, expenditureList[d])) {
            resultCount += 1
        }

        expenditureList.removeAt(0)
    }

    return resultCount
}

fun shouldNotify(median: Double, day: Int) = day >= median * 2

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nd = scan.nextLine().split(" ")

    val n = nd[0].trim().toInt()

    val d = nd[1].trim().toInt()

    val expenditure = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = activityNotifications(expenditure, d)

    println(result)
}

