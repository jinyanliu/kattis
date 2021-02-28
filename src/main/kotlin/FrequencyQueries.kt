fun freqQuery(queries: Array<Array<Int>>): Array<Int> {
    val currentList = arrayListOf<Int>()
    val resultList = arrayListOf<Int>()

    queries.map { it[0] to it[1] }.forEach {
        when (it.first) {
            1 -> currentList.add(it.second)
            2 -> currentList.remove(it.second)
            3 -> resultList.add(getOutput(currentList, it.second))
            else -> error("")
        }
    }
    return resultList.toTypedArray()
}

fun getOutput(list: ArrayList<Int>, frequency: Int): Int {
    list.forEach { number ->
        if (list.count { it == number } == frequency) {
            return 1
        }
    }
    return 0
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