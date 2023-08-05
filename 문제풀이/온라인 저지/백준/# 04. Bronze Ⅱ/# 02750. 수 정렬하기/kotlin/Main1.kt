fun main() {
    val check = BooleanArray(2001)
    var n = readInt()
    while (n-- > 0) {
        check[readInt() + 1000] = true
    }

    val sb = StringBuilder()
    for (i in check.indices) {
        if (check[i]) {
            sb.append(i-1000).append('\n')
        }
    }
    print(sb)
}

private fun readInt(): Int {
    var value = 0
    var negative = false
    var input: Int
    while (true) {
        input = System.`in`.read()
        when (input) {
            10, 32 -> return if (negative) -value else value
            45 -> negative = true
            else -> value = value * 10 + (input - 48)
        }
    }
}