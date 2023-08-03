fun main() {
    val n = readLong()
    val sb = StringBuilder()
    sb.append(n * n * n).append('\n').append('3')
    print(sb)
}

private fun readLong(): Long {
    var value = 0L
    var input: Int
    while (true) {
        input = System.`in`.read()
        when (input) {
            10, 32 -> return value
            else -> value = value * 10 + (input - 48)
        }
    }
}
