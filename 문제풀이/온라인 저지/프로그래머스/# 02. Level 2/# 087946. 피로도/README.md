# 문제
- 플랫폼 : 프로그래머스
- 번호 : 087946
- 제목 : 피로도
- 난이도 : Level 2
- 유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열 dungeons 가 매개변수로 주어질 때, 유저가 탐험할수 있는 최대 던전 수를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/87946" target="_blank">링크</a>

---

# 필요 지식
- 백트래킹

---

# 풀이
```kotlin
class Solution {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var answer = 0
        val check = BooleanArray(dungeons.size)
        fun backTracking(l: Int, cnt: Int) {
            var isEnd = true
            for (i in dungeons.indices) {
                if (l >= dungeons[i][0] && !check[i]) {
                    if (isEnd) {
                        isEnd = false
                    }
                    check[i] = true
                    backTracking(l - dungeons[i][1], cnt + 1)
                    check[i] = false
                }
            }
            if (isEnd && cnt > answer) {
                answer = cnt
            }
        }
        backTracking(k, 0)
        return answer
    }
}
```
- 매 순간 여러개의 던전 중 하나를 선택해야하고, 현재 자신이 처한 조건에 따라 선택지가 달라진다.
- 이는 백트래킹으로 해석할 수 있다.
- 던전들 목록을 순회하면서, 방문하지 않았고 최소피로도보다 자신의 생명력이 더 높은 던전이면 방문하기로 결정한다.
  - isEnd 변수는 다음 던전에 갈 수 없는 상태를 의미하는데 다음 던전에 갈 수 있으면 이 값을 false로 갱신한다.
  - 배열에서 해당 던전을 방문체크한다.
  - 방문체크를 해제한다.
- isEnd 가 true이면서, cnt가 answer보다 크면 answer를 cnt로 갱신한다.
- 최종적으로 answer를 출력하면 된다.

---
