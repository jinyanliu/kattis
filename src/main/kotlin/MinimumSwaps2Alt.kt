fun orderList(arr: Array<Int>): Array<Int> {
    var currentArray = arr.toMutableList()
    var loopTimes = currentArray.size - 1
    while (loopTimes >= 1) {
        (1..loopTimes).forEach {
            currentArray = compareAndMaybeSwap(currentArray, it - 1, it)
        }
        loopTimes -= 1
    }
    return currentArray.toTypedArray()
}

fun compareAndMaybeSwap(array: MutableList<Int>, firstIndex: Int, secondIndex: Int): MutableList<Int> {
    val firstElement = array[firstIndex]
    val secondElement = array[secondIndex]
    if (firstElement > secondElement) {
        array[firstIndex] = secondElement
        array[secondIndex] = firstElement
    }
    return array
}

fun main() {

}