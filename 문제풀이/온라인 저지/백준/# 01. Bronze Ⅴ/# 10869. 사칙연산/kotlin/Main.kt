fun main() {
    val a = readInt()
    val b = readInt()
    val sb = StringBuilder()
    sb.append(a+b)
        .append('\n')
        .append(a-b)
        .append('\n')
        .append(a*b)
        .append('\n')
        .append(a/b)
        .append('\n')
        .append(a%b)
    print(sb)
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
