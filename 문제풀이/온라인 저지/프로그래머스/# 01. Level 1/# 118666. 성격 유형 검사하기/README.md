# 문제
- 플랫폼 : 프로그래머스
- 번호 : 118666
- 제목 : 성격 유형 검사하기
- 난이도 : Level 1
- 검사자의 성격 유형 검사 결과를 지표 번호 순서대로 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/118666" target="_blank">링크</a>

---

# 필요 지식
- 해시
- 구현

---

# 풀이
```kotlin
class Solution {

    private val map = mapOf(
        "RT" to intArrayOf(0,3,2,1,0,-1,-2,-3),
        "TR" to intArrayOf(0,-3,-2,-1,0,1,2,3),
        "CF" to intArrayOf(1,3,2,1,0,-1,-2,-3),
        "FC" to intArrayOf(1,-3,-2,-1,0,1,2,3),
        "JM" to intArrayOf(2,3,2,1,0,-1,-2,-3),
        "MJ" to intArrayOf(2,-3,-2,-1,0,1,2,3),
        "AN" to intArrayOf(3,3,2,1,0,-1,-2,-3),
        "NA" to intArrayOf(3,-3,-2,-1,0,1,2,3)
    )

    fun solution(survey: Array<String>, choices: IntArray): String {
        val arr = IntArray(4)

        for (i in choices.indices) {
            val idx = map[survey[i]]!![0]
            val point = map[survey[i]]!![choices[i]]
            arr[idx] += point
        }
        val result = CharArray(4)
        result[0] = if (arr[0] >= 0) 'R' else 'T'
        result[1] = if (arr[1] >= 0) 'C' else 'F'
        result[2] = if (arr[2] >= 0) 'J' else 'M'
        result[3] = if (arr[3] >= 0) 'A' else 'N'
        return String(result)
    }
}
```
- 각 survey 후보 별로 배열을 해싱한다.
  - 0번 인덱스 : 지표의 인덱스(0번,1번,2번,3번)
  - 1~7번 인덱스 : 점수
- 배열을 순회하면서 해당 지표의 점수를 추가 합산한다.
- 각 유형별 점수가 0 이상인지 혹은 음수인지에 따라 결과를 만들면 된다.

---
