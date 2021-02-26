import kotlin.random.Random

fun main() {
    calculate()
}

private fun calculate() {
    val takenIndex = List(10) { Random.nextInt(0, 101) }
    println(takenIndex)
    val sortedList = takenIndex.sorted()
    println(sortedList)

    val mapStorage = mutableMapOf<Int, Int>()
    mapStorage[0] = sortedList[0] - 1
    (sortedList.indices).forEach {
        if (it == sortedList.size - 1) {
            mapStorage[sortedList[it]] = 101 - sortedList[it] - 1
        } else {
            mapStorage[sortedList[it]] = sortedList[it + 1] - sortedList[it] - 1
        }
    }
    println(mapStorage)
}

