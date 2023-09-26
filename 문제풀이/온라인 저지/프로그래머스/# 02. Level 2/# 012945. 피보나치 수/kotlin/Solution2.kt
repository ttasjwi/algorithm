class Solution2 {
    fun solution(n: Int): Int {
        val div = 1_234_567L
        fun multiply(a: Array<LongArray>, b: Array<LongArray>): Array<LongArray> {
            val result = Array(2){LongArray(2)}
            for (i in 0 until 2) {
                for (j in 0 until 2) {
                    for (k in 0 until 2) {
                        result[i][j] += a[i][k] * b[k][j]
                        result[i][j] %= div
                    }
                }
            }
            return result
        }

        fun pow(x: Int): Array<LongArray> {
            if (x == 1) return arrayOf(longArrayOf(1, 1), longArrayOf(1, 0))
            val tmp = pow(x / 2).let { multiply(it, it) }
            if (x % 2 == 0) return tmp
            return multiply(tmp, arrayOf(longArrayOf(1, 1), longArrayOf(1, 0)))
        }
        return pow(n-1)[0][0].toInt()
    }

}
