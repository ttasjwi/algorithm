fun main() {
    val a1 = readInt()
    val a0 = readInt()
    val c = readInt()
    val n0 = readInt()

    print(if (a1 <= c && (a1 - c) * n0 + a0 <= 0) 1 else 0)
}

private fun readInt(): Int {
    var value = 0
    var input: Int
    while (true) {
        input = System.`in`.read()
        when (input) {
            10, 32 -> return value
            else -> value = value * 10 + (input - 48)
        }
    }
}
