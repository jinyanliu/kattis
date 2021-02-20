import java.math.BigDecimal
import java.math.RoundingMode
import java.util.ArrayDeque
import kotlin.math.abs

fun main() {
    val inputs = getInputs()
    PolygonArea().processInputs(inputs).forEach {
        println(it)
    }
}

private fun getInputs(): ArrayDeque<String> {
    val inputsQueue = ArrayDeque<String>()
    var line = readLine()!!
    while (line != "0") {
        inputsQueue.add(line)
        line = readLine()!!
    }
    return inputsQueue
}

class PolygonArea {
    fun processInputs(queue: ArrayDeque<String>): List<String> {
        val result = arrayListOf<String>()
        while (queue.isNotEmpty()) {
            val oneSection = arrayListOf<String>()
            val indicator = queue.pollFirst()!!.toInt()
            repeat(indicator) {
                oneSection.add(queue.pollFirst())
            }
            val area = processOneSection(oneSection)
            result.add("${area.first} ${area.second}")
        }
        return result
    }

    fun processOneSection(section: List<String>): Pair<String, String> {
        val points = section.map { it.split(" ") }.map { it[0].toInt() to it[1].toInt() }
        var area = 0.0

        for (i in points.indices) {
            area += if (i == points.size - 1) {
                points[i].first * points[0].second
            } else {
                points[i].first * points[i + 1].second
            }
        }

        for (i in points.indices) {
            area -= if (i == 0) {
                points[i].first * points[points.size - 1].second
            } else {
                points[i].first * points[i - 1].second
            }
        }

        val isClockWise = if (area <= 0) "cw" else "ccw"
        val result = abs(area / 2.0)
        return isClockWise to BigDecimal(result).setScale(1, RoundingMode.DOWN).toDouble().toString()
    }
}