fun main() {
    val a = s()
    val b = s()
    val dp = Array(a.size) { IntArray(b.size) }
    for (i in 1..a.size - 1) {
        for (j in 1..b.size - 1) {
            dp[i][j] =
                if (a[i] == b[j]) dp[i - 1][j - 1] + 1
                else Math.max(dp[i - 1][j], dp[i][j - 1])
        }
    }
    sb.append(dp[a.size - 1][b.size - 1])
    print(sb)
}

private val sb = StringBuilder()

private fun s(): CharArray {
    sb.append(' ')
    var c = System.`in`.read()
    do sb.append(c.toChar()) while (System.`in`.read().also { c = it } > 13)
    val s = sb.toString().toCharArray()
    sb.setLength(0)
    return s
}
