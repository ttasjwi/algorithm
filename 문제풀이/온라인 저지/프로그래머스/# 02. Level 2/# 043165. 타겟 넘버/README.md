# 문제
- 플랫폼 : 프로그래머스
- 번호 : 043165
- 제목 : 타겟 넘버
- 난이도 : Level 2
- 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/43165" target="_blank">링크</a>

---

# 필요 지식
- DFS

---

# 풀이
```kotlin
class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        fun dfs(value: Int, idx: Int) {
            if (idx == numbers.size) {
                if (value == target) answer ++
                return
            }
            dfs(value + numbers[idx], idx + 1)
            dfs(value - numbers[idx], idx + 1)
        }
        dfs(0, 0)
        return answer
    }
}
```
- 재귀함수를 호출하여, 현재 값에 더한 경우/뺀 경우 양쪽으로 가지치기를 한다.
- 마지막 인덱스에서 값이 같은 지를 판단하여 같으면 answer를 증가시킨다.
  - 마지막 직전 인덱스에서 판단하여 처리를 끝내는 방법도 있긴 하다.

