fun main() {
    val n = i()
    val d = Array(10){IntArray(n)}
    val DIV = 1_000_000_000
    var answer = 0
    for (c in 0.. n-1) {
        for (s in 0..9) {
            d[s][c] = if (c == 0) 1
            else when(s) {
                0 -> d[1][c-1]
                9 -> d[8][c-1]
                else -> (d[s-1][c-1]+d[s+1][c-1])%DIV
            }
            if (c == n-1 && s != 0) {
                answer += d[s][c]
                answer %= DIV
            }
        }
    }
    print(answer)
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while(System.`in`.read().also { c = it } > 47)
    return v
}
