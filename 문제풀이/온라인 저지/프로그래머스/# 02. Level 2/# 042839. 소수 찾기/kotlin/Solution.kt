import kotlin.math.sqrt

class Solution {
    fun solution(numbers: String): Int {
        val max = (1).let{
            var result = it
            repeat(numbers.length) { result *= 10 }
            result
        }
        val isPrime = BooleanArray(max) {true}
        isPrime[0] = false
        isPrime[1] = false
        for (i in 2..sqrt(max.toDouble()).toInt()) {
            if (isPrime[i]) {
                for (j in 2*i until max step i) {
                    isPrime[j] = false
                }
            }
        }
        val set = HashSet<Int>()
        val check = BooleanArray(numbers.length)
        fun dfs(v: Int, cnt: Int) {
            var next: Int
            for (i in numbers.indices) {
                if (!check[i]) {
                    check[i] = true
                    next = v * 10 + numbers[i].code - 48
                    if (isPrime[next]) set += next
                    if (cnt + 1 < numbers.length) dfs(next, cnt + 1)
                    check[i] = false
                }
            }
        }
        dfs(0, 0)
        return set.size
    }


}