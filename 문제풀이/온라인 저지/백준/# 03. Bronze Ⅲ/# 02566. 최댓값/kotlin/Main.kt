import java.lang.StringBuilder

fun main() {
    var current: Int
    var maxValue = -1
    var maxColumn = 0
    var maxRow = 0

    loop@for (r in 1..9) {
        for (c in 1..9) {
            current = readInt()
            if (maxValue < current) {
                maxValue = current
                maxColumn = c
                maxRow = r
                if (current == 99) break@loop
            }
        }
    }
    val sb = StringBuilder()
    sb.append(maxValue)
        .append('\n')
        .append(maxRow).append(' ').append(maxColumn)
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
