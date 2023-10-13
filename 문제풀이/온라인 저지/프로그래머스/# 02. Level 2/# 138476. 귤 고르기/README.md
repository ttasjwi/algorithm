# 문제
- 플랫폼 : 프로그래머스
- 번호 : 138476
- 제목 : 귤 고르기
- 난이도 : Level 2
- 경화가 귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값을 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/138476" target="_blank">링크</a>

---

# 필요 지식
- 그리디 알고리즘

---

# 풀이
```kotlin
import java.util.*

class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        val map = HashMap<Int, Int>()
        for (t in tangerine) {
            if (!map.containsKey(t)) {
                map[t] = 1
            } else {
                map[t] = map[t]!! + 1
            }
        }
        val arr = map.values.toIntArray()
        Arrays.sort(arr)
        var count = 0
        var cur = k
        for (i in arr.lastIndex downTo 0) {
            count ++
            cur -= arr[i]
            if (cur <= 0) break
        }
        return count
    }
}
```
- map에 귤의 갯수들을 카운팅하고, 귤의 갯수들을 배열로 얻어온다.
- 배열을 정렬하고, 귤의 갯수가 많은 것부터 우선적으로 박스에 담는다.
  - 귤의 갯수가 많은 것을 우선적으로 담을 수록 귤의 크기 종류가 적어진다.

---
