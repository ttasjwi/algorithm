fun main() {
    val n = i()
    val m = i()
    val board = Array(n + 1) { IntArray(m + 1) }
    var flag: Boolean
    var sum: Int
    var answer = 64
    for (i in 1..n) {
        flag = i % 2 == 1
        for (j in 1..m) {
            board[i][j] =
                board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1] + if ((r() == 'B'.toByte()) == flag) 0 else 1
            flag = !flag

            if (i >= 8 && j >= 8) {
                sum = board[i][j] - board[i - 8][j] - board[i][j - 8] + board[i - 8][j - 8]
                if (sum > 32) sum = 64 - sum
                if (answer > sum) answer = sum
            }
        }
        r()
    }
    println(answer)
}


private const val S = 65536
private val iS = java.io.DataInputStream(System.`in`)
private val b = ByteArray(S)
private var c = 0
private var l = 0

private fun i(): Int {
    var v = 0
    var c = r()
    do v = v * 10 + c - 48 while (r().also { c = it } > 47)
    return v
}

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}