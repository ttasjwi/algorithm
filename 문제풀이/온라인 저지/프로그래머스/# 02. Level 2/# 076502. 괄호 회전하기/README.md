# 문제
- 플랫폼 : 프로그래머스
- 번호 : 076502
- 제목 : 괄호 회전하기
- 난이도 : Level 2
- s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/76502" target="_blank">링크</a>

---

# 필요 지식
- 스택
- 문자열 처리

---

# 풀이
```kotlin
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
```
- 괄호 맞는지 판단하는 문제는 십중팔구 스택 문제이다.
- subString을 써서 새 문자열을 할당하는 식으로 처리하는 분들도 많았는데,
나 같은 경우는 포인터 두개를 조절하여 뒷부분을 넘어가면 앞부분으로 가서 문자열을 읽는 식으로 처리하도록 했다.
  - 문자열을 재할당하지 않아도 된다.
- 배열 또는 문자열의 끝 인덱스를 넘었을 때 첫 인덱스로 돌아와서 순회하도록 하려면 `(rt + 1 + s.length)% s.length` 와 같이 순회하면 된다.
  - 이 관용구는 자주 쓰이므로 기억해두면 좋다.

---
