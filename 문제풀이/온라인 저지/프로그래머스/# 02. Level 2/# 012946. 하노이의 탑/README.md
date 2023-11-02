# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012946
- 제목 : 하노이의 탑
- 난이도 : Level 2
- 1번 기둥에 있는 원판의 개수 n이 매개변수로 주어질 때, n개의 원판을 3번 원판으로 최소로 옮기는 방법을 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12946" target="_blank">링크</a>

---

# 필요 지식
- 재귀

---

# 풀이
```kotlin
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
```
- n개의 석판을 1번째에서 세번째 위치로 옮기는 방법은 재귀적으로 생각하면 좋다.
- 어떤 n개의 석판을 start에서 mid를 거쳐서 to 로 옮기는 관점에서 생각하면
  - n-1개를 to를 거쳐서 mid로 옮기고
  - 맨 아래 1개를 to로 옮긴 뒤
  - n-1개를 from을 거쳐서 to로 옮기면 된다.
- 1개의 석판을 옮길 때는 중간 경유지를 거치지 않고 그대로 바로 옮겨버리면 된다.

---
