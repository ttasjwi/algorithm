fun main() {
    val a = readInt()
    val b = readInt()
    val c = readInt()
    val d = readInt()
    val e = readInt()
    val f = readInt()

    val div = (a * e - b * d)
    val x = (e * c - b* f) / div
    val y = (a * f - c * d) / div

    val sb = StringBuilder()
    sb.append(x).append(' ').append(y)
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