import java.util.Scanner

fun minimumSwaps(arr: Array<Int>): Int {
    val currentArray = arr.toMutableList()
    // number, index
    val map = mutableMapOf<Int, Int>()
    arr.withIndex().forEach {
        map[it.value] = it.index
    }

    var count = 0
    val loopThrough = currentArray.indices.map { it + 1 }
    loopThrough.forEach { currentNumber ->
        if (currentArray[currentNumber - 1] != currentNumber) {
            count += 1
            val indexOfCurrentNumber = map[currentNumber] ?: error("")
            val numberOnThePlace = currentArray[currentNumber - 1]
            currentArray[currentNumber - 1] = currentNumber
            currentArray[indexOfCurrentNumber] = numberOnThePlace
            map[currentNumber] = currentNumber - 1
            map[numberOnThePlace] = indexOfCurrentNumber
        }
    }
    return count
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val n = scan.nextLine().trim().toInt()
    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    val res = minimumSwaps(arr)
    println(res)
}