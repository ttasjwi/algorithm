fun main() {
    val s = s()
    val dp = Array(26){IntArray(s.length + 1)}
    for (i in s.indices) {
        for (ch in 'a'..'z') {
            dp[ch.code-97][i+1] =
                if (ch == s[i]) dp[ch.code - 97][i] + 1
                else dp[ch.code-97][i]
        }
    }
    var q = i()
    var x: Byte
    var i: Int
    var j: Int
    while(q-- > 0 ) {
        x = r()
        r()
        i = i() + 1
        j = i() + 1
        sb.append(dp[x.toInt()-97][j] - dp[x.toInt()-97][i-1]).append('\n')
    }
    print(sb)
}

private const val S = 65536
private val iS = java.io.DataInputStream(System.`in`)
private val b = ByteArray(S)
private var c = 0
private var l = 0
private val sb = StringBuilder()

private fun i(): Int {
    var v = 0
    var c = r()
    do v = v * 10 + c - 48 while (r().also { c = it } > 47)
    return v
}

private fun s(): String {
    var c = r()
    do sb.append(c.toChar()) while (r().also { c = it } > 32)
    val s = sb.toString()
    sb.setLength(0)
    return s
}

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}