fun main() {
    val check = IntArray(9)
    var sum = 0
    var num: Int
    for (i in 1..5) {
        num = readInt()
        sum += num
        check[num/10 - 1] += 1
    }
    var cnt = 0
    val sb = StringBuilder()
    sb.append(sum/5).append('\n')
    for (i in check.indices) {
        if (check[i] > 0) {
            cnt += check[i]
            if (cnt >= 3) {
                sb.append((i + 1) * 10).append('\n')
                break
            }
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

