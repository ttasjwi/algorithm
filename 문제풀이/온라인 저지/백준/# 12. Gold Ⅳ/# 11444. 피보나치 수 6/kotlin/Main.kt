fun main() {
    val n = i()
    val c = 1_000_000_007L
    fun multiply(a: Array<LongArray>, b: Array<LongArray>): Array<LongArray> {
        val result = Array(2) { LongArray(2) }
        for (i in 0 until 2) {
            for (j in 0 until 2) {
                for (k in 0 until 2) {
                    result[i][j] += a[i][k] * b[k][j]
                    result[i][j] %= c
                }
            }
        }
        return result
    }
    fun pow(array: Array<LongArray>, n: Long): Array<LongArray> {
        if (n == 0L || n == 1L) return array
        if (n == 2L) return multiply(array, array)
        return if (n % 2 == 0L)
            pow(pow(array, n / 2), 2)
        else {
            multiply(pow(pow(array, n / 2), 2), array)
        }
    }
    print(pow(arrayOf(longArrayOf(1, 1), longArrayOf(1, 0)), n - 1)[0][0])
}

private fun i(): Long {
    var v = 0L
    var c = System.`in`.read()
    val n = c == 45
    c = if (n) System.`in`.read() else c
    do {
        v = v * 10 + c - 48
    } while (System.`in`.read().also { c = it } > 47)
    return if (n) -v else v
}