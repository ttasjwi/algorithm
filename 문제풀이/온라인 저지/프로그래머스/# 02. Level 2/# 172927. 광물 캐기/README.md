# 문제
- 플랫폼 : 프로그래머스
- 번호 : 172927
- 제목 : 광물 캐기
- 난이도 : Level 2
- 마인이 작업을 끝내기까지 필요한 최소한의 피로도를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/172927" target="_blank">링크</a>

---

# 필요 지식
- DFS

---

# 풀이
```kotlin
class Solution {

    private val table = arrayOf(
        mapOf("diamond" to 1, "iron" to 1, "stone" to 1),
        mapOf("diamond" to 5, "iron" to 1, "stone" to 1),
        mapOf("diamond" to 25, "iron" to 5, "stone" to 1)
    )

    fun solution(picks: IntArray, minerals: Array<String>): Int {
        var answer = Integer.MAX_VALUE
        fun dfs(startStem: Int, startIdx: Int) {
            if (startIdx == minerals.size || (picks[0] == 0 && picks[1] == 0 && picks[2] == 0)) {
                if (answer > startStem) answer = startStem
                return
            }
            var c: Int
            var i: Int
            var stem: Int
            for (j in picks.indices) {
                if (picks[j] > 0) {
                    picks[j] --
                    c = 5
                    i = startIdx
                    stem = startStem
                    while (c-- > 0) {
                        stem += table[j][minerals[i]]!!
                        i ++
                        if (i == minerals.size) break
                    }
                    dfs(stem, i)
                    picks[j] ++
                }
            }
        }
        dfs(0, 0)
        return answer
    }

}
```
- table : 곡괭이 별 자원 채굴 시 소모 피로도
- dfs : 깊이 우선 탐색
  - startStem : 시작 시점의 피로도
  - startIdx : 시작 시점에 채굴해야할 mineral 인덱스
  - startIdx가 mineral.size(모두 채굴한 상황) 이거나, picks의 모든 요소가 0 일 경우 answer와 startStem을 비교하여 더 작은 쪽으로 갱신 후 return
  - picks를 순회하면서, `picks[j]`의 값이 0보다 크면 `picks[j]` 를 1 감소시키고, 5회동안 자원 채굴을 시도한다. (stem, i 증가, c 감소)
  - 이 과정에서 모든 자원을 채굴하거나 c가 0이 되면 dfs(stem, i) 를 호출한 뒤 `picks[j]` 값을 원상 복구 시킨다.
- `dfs(0,0)` 을 호출한 뒤 answer를 반환한다.

---
