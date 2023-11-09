# 문제
- 플랫폼 : 프로그래머스
- 번호 : 161990
- 제목 : 바탕화면 정리
- 난이도 : Level 1
- 바탕화면의 파일들을 한 번에 삭제하기 위해 최소한의 이동거리를 갖는 드래그의 시작점과 끝점을 담은 정수 배열을 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/161990" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
```kotlin
class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        val answer = intArrayOf(50,50,0,0)
        
        for (r in wallpaper.indices) {
            for (c in wallpaper[0].indices) {
                if (wallpaper[r][c] == '#') {
                    if (r < answer[0]) answer[0] = r
                    if (c < answer[1]) answer[1] = c
                    if (r+1 > answer[2]) answer[2] = r+1
                    if (c+1 > answer[3]) answer[3] = c+1
                }
            }
        }
        return answer
    }
}
```
- 왼쪽 위끝행, 왼쪽 위끝열, 오른쪽 아래끝행, 오른쪽 아래끝열을 구해야한다.
- 왼쪽 끝값 갱신 : 현재행, 현재 열과 비교한다.
- 오른쪽 끝값 갱신 : 현재행+1, 현재열+1과 비교한다.

---
