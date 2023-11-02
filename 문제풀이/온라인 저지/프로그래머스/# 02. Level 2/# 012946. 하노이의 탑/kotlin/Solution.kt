class Solution {
    fun solution(n: Int): Array<IntArray> {
        val answer = ArrayList<IntArray>()
        fun hanoi(n: Int, from: Int, mid: Int, to: Int) {
            if (n == 1) {
                answer += intArrayOf(from, to)
                return
            }
            hanoi(n-1, from, to, mid)
            hanoi(1, from, mid, to)
            hanoi(n-1, mid, from, to)
        }
        hanoi(n, 1, 2, 3)
        return answer.toTypedArray()
    }

}
