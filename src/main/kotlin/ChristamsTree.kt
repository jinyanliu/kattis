fun main() {
    drawTree(50)
}

private fun drawTree(n: Int) {
    (n - 1 downTo 0).forEach { lineNumber ->
        repeat(lineNumber) { print(" ") }
        (lineNumber..(n - 1) * 2 - lineNumber).forEach {
            if (lineNumber % 2 == 0) {
                if (it % 2 == 0) print("X") else print(" ")
            } else {
                if (it % 2 == 0) print(" ") else print("X")
            }
        }
        println()
    }
}