# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012914
- 제목 : 멀리 뛰기
- 난이도 : Level 2
- 멀리뛰기에 사용될 칸의 수 n이 주어질 때, 효진이가 끝에 도달하는 방법의 수를 반환
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12914" target="_blank">링크</a>

---

# 필요 지식
- 다이나믹 프로그래밍(DP)

---

# 풀이
```kotlin
class Solution {
    fun solution(n: Int): Long {
        if (n == 1) return 1
        var before = 1L
        var cur = 2L
        for (i in 3..n) {
            cur = (before + cur).also { before = cur }
            cur %= 1234567L
        }
        return cur
    }
}
```
- k번 위치에 오는 방법은 k-1번에서 위치에서 1칸 건너 오거나, k-2번에서 2칸 건너오는 방법 두 가지가 있다.
