fun freqQuery(queries: Array<Array<Int>>): Array<Int> {
    val elementToFrequency = mutableMapOf<Int, Int>()
    val resultList = arrayListOf<Int>()

    queries.map { it[0] to it[1] }.forEach {
        when (it.first) {
            1 -> {
                val currentFrequency = elementToFrequency[it.second] ?: 0
                elementToFrequency[it.second] = currentFrequency + 1
            }
            2 -> {
                val currentFrequency = elementToFrequency[it.second]
                if (currentFrequency != null && currentFrequency > 0) {
                    elementToFrequency[it.second] = currentFrequency - 1
                }
            }
            3 -> resultList.add(getOutput(elementToFrequency, it.second))
            else -> error("")
        }
    }
    return resultList.toTypedArray()
}

fun getOutput(map: Map<Int, Int>, frequency: Int): Int {
    return if (map.containsValue(frequency)) 1 else 0
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()
    val queries = Array<Array<Int>>(q, { Array<Int>(2, { 0 }) })
    for (i in 0 until q) {
        queries[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }
    val ans = freqQuery(queries)
    println(ans.joinToString("\n"))
}