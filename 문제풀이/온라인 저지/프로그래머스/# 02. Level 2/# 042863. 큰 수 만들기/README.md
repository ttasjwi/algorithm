# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042863
- 제목 : 큰 수 만들기
- 난이도 : Level 2
- number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42863" target="_blank">링크</a>

---

# 필요 지식
- 스택

---

# 풀이
```kotlin
class Solution {
    fun solution(number: String, k: Int): String {
        var k = k
        val dq = Deque(number.length)
        for (n in number) {
            while (dq.isNotEmpty() && dq.last() < n && k > 0) {
                dq.dqLast()
                k--
            }
            dq.eq(n)
        }
        while (k > 0) {
            dq.dqLast()
            k--
        }
        val sb = StringBuilder()
        while (dq.isNotEmpty()) {
            sb.append(dq.dqFirst())
        }
        return sb.toString()
    }
}

class Deque(cap: Int) {
    private val c = cap + 1
    private val arr = CharArray(c)
    private var front = 0
    private var rear = 0

    fun eq(e: Char) {
        arr[((rear + 1 + c) % c).also { rear = it }] = e
    }

    fun dqFirst(): Char = arr[((front + 1 + c) % c).also { front = it }]
    fun dqLast(): Char = arr[rear.also { rear = (it - 1 + c) % c }]
    fun last(): Char = arr[rear]
    fun isNotEmpty(): Boolean = front != rear
}
```
- 숫자들을 순서대로 읽으면서 스택에 쌓는다.
  - 쌓기 전에, 스택의 마지막 숫자가 있으면 그 숫자보다 클 경우 스택에서 k가 허용하는 한 추출한다.
- 다 순회하더라도 k가 남아있을 수 있다. 이 경우 스택 끝에서부터 k가 남을 때까지 횟수를 추출한다.
- 스택의 첫번째 요소부터 순서대로 StringBuilder에 append한다. (이를 위해 원형 큐를 이용하여 Deque를 만들어서 사용했다.)

---
