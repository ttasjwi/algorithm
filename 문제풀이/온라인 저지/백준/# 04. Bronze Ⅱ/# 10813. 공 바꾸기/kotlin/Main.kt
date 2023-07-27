fun main() {
    val n = readInt() // 바구니 갯수
    val m = readInt() // 공을 바꾸는 횟수
    val balls = IntArray(n+1)
    for (x in 1..n) {
        balls[x] = x
    }

    var i: Int
    var j: Int
    var tmp: Int
    repeat(m) {
        i = readInt()
        j = readInt()
        tmp = balls[j]
        balls[j] = balls[i]
        balls[i] = tmp
    }
    val sb = StringBuilder()
    for (x in 1..n) {
        sb.append(balls[x])
        sb.append(' ')
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
