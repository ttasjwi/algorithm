fun main() {
    val sb = StringBuilder()
    var a: Int
    var b: Int
    while (true) {
        a = readInt()
        b = readInt()
        when {
            a==0 && b==0 -> break
            b%a == 0 -> sb.append("factor\n")
            a%b == 0 -> sb.append("multiple\n")
            else -> sb.append("neither\n")
        }
    }
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
