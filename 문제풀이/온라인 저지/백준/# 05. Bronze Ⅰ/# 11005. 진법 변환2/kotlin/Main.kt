import java.lang.StringBuilder

fun main() {
    var n = readInt()
    val b = readInt()
    val sb = StringBuilder()
    var tmp: Int
    while (n >= b) {
        tmp = n % b
        sb.append(toNumberChar(tmp))
        n /= b
    }
    sb.append(toNumberChar(n))
    print(sb.reverse())
}

private fun toNumberChar(value: Int): Char {
    return if (value < 10) (value + 48).toChar()
           else (value + 55).toChar()
}

private fun readInt(): Int {
    var value = 0
    var input: Int
    while (true) {
        input = System.`in`.read()
        when (input) {
            10, 32 -> return value // 공백이나 개행자
            else -> value = value * 10 + (input - 48)
        }
    }
}
