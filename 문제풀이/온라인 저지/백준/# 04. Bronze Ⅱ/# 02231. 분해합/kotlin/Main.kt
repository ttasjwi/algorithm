fun main() {
    val n = readInt()
    // n = k + k1 + k2 + ... k4 + ...
    // 1<= k1 + k2 +... <= length * 9
    // n-length *9 <= k <= n-1
    for (k in n- 9 * n.toString().length until n) {
        if (k + sum(k) == n) {
            print(k)
            return
        }
    }
    print(0)
}

private fun sum(n: Int): Int {
    var sum = 0
    for (ch in n.toString()) {
        sum += ch.code - 48
    }
    return sum
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

