import java.io.BufferedWriter
import java.io.OutputStreamWriter

lateinit var board: Array<CharArray>

fun main() {
    val n = i()
    board = Array(n) { CharArray(n) }
    foo(0, 0, n, false)
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    for (b in board) {
        bw.write(b)
        bw.newLine()
    }
    bw.flush()
}

fun foo(sr: Int, sc: Int, len: Int, isBlank: Boolean) {
    if (isBlank) {
        for (i in sr..sr + len - 1) {
            for (j in sc..sc + len - 1) {
                board[i][j] = ' '
            }
        }
        return
    }
    if (len == 1) {
        board[sr][sc] = '*'
        return
    }
    val n = len / 3
    for (i in 0..2) {
        for (j in 0..2) {
            foo(sr + n * i, sc + n * j, n, (i == 1 && j == 1))
        }
    }
    return
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while (System.`in`.read().also { c = it } > 47)
    return v
}
