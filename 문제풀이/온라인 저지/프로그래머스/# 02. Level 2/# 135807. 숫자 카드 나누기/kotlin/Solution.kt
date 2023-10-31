class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        val gcdA = gcdOf(arrayA)
        val gcdB = gcdOf(arrayB)

        var resultA = 0
        var resultB = 0
        if (gcdA != 1 && cannotDivide(arrayB, gcdA)) resultA = gcdA
        if (gcdB != 1 && cannotDivide(arrayA, gcdB)) resultB = gcdB
        return maxOf(resultA, resultB)
    }

    private fun gcdOf(arr: IntArray): Int {
        var gcd = arr[0]
        for (i in 1 until arr.size) {
            gcd = gcd(gcd, arr[i])
        }
        return gcd
    }

    private fun cannotDivide(arr: IntArray, div: Int): Boolean {
        for (e in arr) {
            if (e% div == 0) return false
        }
        return true
    }

    private fun gcd(a: Int, b: Int): Int {
        val max: Int
        val min: Int
        if (a >= b) {
            max = a
            min = b
        } else {
            max = b
            min = a
        }
        val r = max % min
        return if (r == 0) min else gcd(min, r)
    }

}
