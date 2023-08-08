fun main() {
    var n = i()
    val cards = BooleanArray(20_000_001)
    while (n -- > 0) {
        cards[i() + 10_000_000] = true
    }
    var m = i()
    val sb = StringBuilder()
    while (m -- > 0) {
        sb.append(if (cards[i() + 10_000_000]) 1 else 0).append('\n')
    }
    print(sb)
}

private fun i(): Int {
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