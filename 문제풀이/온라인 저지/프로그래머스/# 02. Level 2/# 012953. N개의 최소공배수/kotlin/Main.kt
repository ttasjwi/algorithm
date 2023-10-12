class Solution {
    fun solution(arr: IntArray): Int {
        fun gcd(a:Int, b:Int) : Int {
            var max: Int
            var min: Int
            if (a >= b) {
                max = a
                min = b
            } else {
                max = b
                min = a
            }
            var r: Int
            while ((max % min).also { r =it } != 0) {
                max = min
                min = r
            }
            return min
        }
        fun lcm(a:Int, b:Int) = a * b / gcd(a,b)
        var lcm = arr[0]
        for (i in 1 until arr.size) {
            lcm = lcm(lcm, arr[i])
        }
        return lcm
    }
}
