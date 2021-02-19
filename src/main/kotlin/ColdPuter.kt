fun main() {
    readLine()
    val temperatures = readLine()?.split(" ")?.map { it.toInt() }
    println(temperatures?.count { it < 0 })
}