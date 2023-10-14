class Solution {
    fun solution(s: String): Int {
        val stack = Stack(s.length)

        var rt: Int
        var answer = 0
        val open = "[{("
        loop@ for (lt in 0 until s.length) {
            rt = lt
            stack.clear()
            do {
                if (s[rt] in open) {
                    stack.push(s[rt])
                } else if (stack.isEmpty()) {
                    continue@loop
                } else if ((s[rt] == ')' && stack.peek() == '(')
                    || (s[rt] == '}' && stack.peek() == '{')
                    || (s[rt] == ']' && stack.peek() == '[')) {
                    stack.pop()
                } else {
                    continue@loop
                }
                rt = (rt + 1 + s.length) % s.length
            } while (lt != rt)

            if (stack.isEmpty()) {
                answer ++
            }
        }
        return answer
    }
}

class Stack(cap: Int) {
    val arr = CharArray(cap)
    var size = 0

    fun push(e: Char) {
        arr[size++] = e
    }
    fun pop() = arr[--size]
    fun isEmpty() = size == 0
    fun peek() = arr[size-1]
    fun clear() { size = 0 }
}
