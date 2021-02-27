import java.util.Scanner

fun sockMerchant(n: Int, ar: Array<Int>): Int {
    val distinct = ar.distinct()
    return distinct.map { distin ->
        ar.count { ar ->
            ar == distin
        }
    }.map {
        it / 2
    }.sum()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}