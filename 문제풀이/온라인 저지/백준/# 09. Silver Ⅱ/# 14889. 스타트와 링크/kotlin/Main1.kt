fun main() {
    val n = i()
    val stats = Array(n+1){IntArray(n+1)}
    val check = BooleanArray(n+1)
    var min = Integer.MAX_VALUE
    for (i in 1..n) {
        for (j in 1..n) {
            stats[i][j] = i()
        }
    }

    fun back(depth: Int, from: Int) {
        if (depth == n / 2) {
            var start = 0
            var link = 0
            for (i in 1..n-1) {
                for (j in i+1..n) {
                    if (check[i] && check[j]) {
                        start += stats[i][j] + stats[j][i]
                    } else if (!check[i] && !check[j]) {
                        link += stats[i][j] + stats[j][i]
                    }
                }
            }
            val diff = Math.abs(start - link)
            if (diff == 0) {
                print(0)
                System.exit(0)
            }
            if (min > diff) {
                min = diff
            }
            return
        }
        for (i in from..n) {
            if (!check[i]) {
                check[i] = true
                back(depth + 1, i + 1)
                check[i] = false
            }
        }
    }

    back(0, 1)
    print(min)
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