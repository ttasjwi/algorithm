private val comb = Array(31) { IntArray(31) }

fun main() {
    var t = i()
    var n: Int
    var m: Int
    val sb = StringBuilder()
    while (t-- > 0) {
        n = i()
        m = i()
        sb.append(comb(m,n)).append('\n')
    }
    print(sb)
}

private fun comb(n: Int, r: Int): Int {
    if (comb[n][r] > 0) {
        return comb[n][r]
    }
    if (r == 0 || r == n) {
        comb[n][r] = 1
        comb[r][n] = comb[n][r]
        return comb[n][r]
    }
    if (r == 1 || r == n-1) {
        comb[n][r] = n
        comb[r][n] = comb[n][r]
        return comb[n][r]
    }
    comb[n][r] = comb(n-1, r-1) + comb(n-1, r)
    comb[n][n-r] = comb[n][r]
    return comb[n][r]
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while (System.`in`.read().also { c = it } > 47)
    return v
}
