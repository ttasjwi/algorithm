fun main() {
    val n = readInt()
    val m = readInt()
    val baskets = IntArray(n+1)

    for (x in 1..n) {
        baskets[x] = x
    }

    var lt: Int
    var rt: Int
    var tmp: Int
    repeat(m) {
        lt = readInt()
        rt = readInt()

        while (lt < rt) {
            tmp = baskets[rt]
            baskets[rt] = baskets[lt]
            baskets[lt] = tmp

            lt += 1
            rt -= 1
        }
    }
    val sb = StringBuilder()
    for (x in 1..n) {
        sb.append(baskets[x]).append(' ')
    }
    print(sb)
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