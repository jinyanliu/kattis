import java.util.ArrayDeque

fun main() {
    val myQueue = ArrayDeque<String>()
    var line = readLine()!!
    while (line != "-1") {
        myQueue.add(line)
        line = readLine()!!
    }

    processInputs(myQueue).forEach {
        println(it)
    }
}

fun processInputs(queue: ArrayDeque<String>): List<String> {
    val result = arrayListOf<String>()
    while (queue.isNotEmpty()) {
        val sectionElements = arrayListOf<String>()
        val indicator = queue.pollFirst()!!.toInt()
        repeat(indicator) {
            sectionElements.add(queue.pollFirst())
        }
        val total = processOneSection(sectionElements)
        result.add("$total miles")
    }
    return result
}

fun processOneSection(sectionElements: List<String>): Int {
    val logs = sectionElements.map { it.split(" ") }.map { it[0].toInt() to it[1].toInt() }
    val normalizedLogs = logs.withIndex()
        .map { it.value.first to (if (it.index == 0) it.value.second else (it.value.second - logs[it.index - 1].second)) }
    return normalizedLogs.sumBy { it.first * it.second }
}