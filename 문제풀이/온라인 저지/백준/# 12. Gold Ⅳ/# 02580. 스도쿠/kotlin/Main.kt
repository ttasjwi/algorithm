private val board = Array(9) { IntArray(9) }
private val rowCheck = Array(9){BooleanArray(10)}
private val colCheck = Array(9){BooleanArray(10)}
private val sqrCheck = Array(9){BooleanArray(10)}
private val list = ArrayList<IntArray>()
fun main() {
    for (r in 0..8) {
        for (c in 0..8) {
            board[r][c] = i()
            if (board[r][c] != 0) {
                rowCheck[r][board[r][c]] = true
                colCheck[c][board[r][c]] = true
                sqrCheck[r/3*3+c/3][board[r][c]] = true
            } else {
                list.add(intArrayOf(r,c))
            }
        }
    }
    back(0)
}

private fun back(depth: Int) {
    if (depth == list.size) {
        val sb = StringBuilder()
        for (r in 0..8) {
            for (c in 0..8) {
                sb.append(board[r][c]).append(' ')
            }
            sb.append('\n')
        }
        print(sb)
        System.exit(0)
    }
    val r = list[depth][0]
    val c = list[depth][1]
    for (i in 1..9) {
        if (rowCheck[r][i] || colCheck[c][i] || sqrCheck[r/3*3+c/3][i]) {
            continue
        } else {
            rowCheck[r][i] = true
            colCheck[c][i] = true
            sqrCheck[r/3*3+c/3][i] = true
            board[r][c] = i
            back(depth+1)
            rowCheck[r][i] = false
            colCheck[c][i] = false
            sqrCheck[r/3*3+c/3][i] = false
        }
    }
}

private const val S = 162
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
