fun main() {
    val n = readLong()
    val sb = StringBuilder()
    sb.append(n * (n-1)/2).append('\n').append('2')
    print(sb)
}

private fun readLong(): Long {
    var value = 0L
    var input: Int
    while (true) {
        input = System.`in`.read()
        when (input) {
            10, 32 -> return value // 공백이나 개행자
            else -> value = value * 10 + (input - 48)
        }
    }
}