fun main() {
    val n = readInt() // 바구니 개수
    val m = readInt() // 공을 넣을 횟수

    val balls = IntArray(n+1)

    var i: Int
    var j: Int
    var k: Int
    repeat(m) {
        i = readInt()
        j = readInt()
        k = readInt()
        (i..j).forEach { balls[it] = k }
    }
    val sb = StringBuilder()
    (1..n).forEach{sb.append(balls[it]).append(' ')}
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