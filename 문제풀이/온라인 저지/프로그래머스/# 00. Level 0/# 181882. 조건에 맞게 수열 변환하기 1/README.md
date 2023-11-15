# 문제
- 플랫폼 : 프로그래머스
- 번호 : 181882
- 제목 : 조건에 맞게 수열 변환하기 1
- 난이도 : Level 0
- 각 원소에 대해 값이 50보다 크거나 같은 짝수라면 2로 나누고, 50보다 작은 홀수라면 2를 곱합니다. 그 결과인 정수 배열을 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181882" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```kotlin
class Solution {
    fun solution(arr: IntArray) = IntArray(arr.size) { i ->
        when {
            (arr[i] >= 50 && arr[i] % 2 == 0) -> arr[i] shr 1
            (arr[i] < 50 && arr[i] % 2 != 0) -> arr[i] shl 1
            else -> arr[i]
        }
    }
}
```
- 정말 시키는 대로 하면 됨.
