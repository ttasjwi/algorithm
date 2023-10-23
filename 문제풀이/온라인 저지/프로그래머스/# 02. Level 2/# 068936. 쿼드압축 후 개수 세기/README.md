# 문제
- 플랫폼 : 프로그래머스
- 번호 : 068936
- 제목 : 쿼드압축 후 개수 세기
- 난이도 : Level 2
- 배열에 최종적으로 남는 0의 개수와 1의 개수를 배열에 담아서 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/68936" target="_blank">링크</a>

---

# 필요 지식
- 분할 정복

---

# 풀이
```kotlin
class Solution {
    fun solution(arr: Array<IntArray>): IntArray {
        val answer = IntArray(2)
        fun div(sr:Int, sc:Int, len:Int) {
            val nextLen = len shr 1
            for (r in sr until sr+len) {
                for (c in sc until sc+len) {
                    if (arr[r][c] != arr[sr][sc]) {
                        div(sr,sc, nextLen)
                        div(sr+nextLen, sc, nextLen)
                        div(sr, sc+nextLen, nextLen)
                        div(sr+nextLen, sc+nextLen, nextLen)
                        return
                    }
                }
            }
            if (arr[sr][sc] == 0) {
                answer[0] ++
            } else {
                answer[1] ++
            }
        }
        div(0, 0, arr.size)
        return answer
    }
}
```
- div(sr,sc,len)
  - sr,sc부터 시작해서 len 길이만큼 순회
  - 첫행,첫열 요소와 다른 요소가 한번이라도 나오면 반복을 멈추고 주어진 영역을 4분할해서 탐색하도록 함
  - 처음부터 끝까지 모두 순회에 성공할 경우 `arr[sr][sc]`를 읽고 그 값이 0이면 `answer[0]`(0의 갯수) 증가/ 1이면 `answer[1]` 증가
- 최종적으로 구해진 answer를 반환

---
