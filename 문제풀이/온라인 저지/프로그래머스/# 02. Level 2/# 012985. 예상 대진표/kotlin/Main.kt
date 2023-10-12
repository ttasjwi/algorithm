class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        var x = a-1
        var y = b-1
        while (true) {
            answer ++
            if ((x%2 == 0 && y == x+1) || (x%2 == 1 && y == x-1)) break
            x /= 2
            y /= 2
        }
        return answer
    }
}
