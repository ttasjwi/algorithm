# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012949
- 제목 : 행렬의 곱셈
- 난이도 : Level 2
- arr1에 arr2를 곱한 결과를 반환하는 함수
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12949" target="_blank">링크</a>

---

# 필요 지식
- 수학
- 구현

---

# 풀이
```kotlin
class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val answer = Array(arr1.size) {IntArray(arr2[0].size)}
        var value: Int
        for (i in arr1.indices) {
            for (j in arr2[0].indices) {
                for (k in arr1[0].indices) {
                    answer[i][j] += arr1[i][k] * arr2[k][j]
                }
            }
        }
        return answer
    }
}
```
- A,B의 행, 열의 갯수를 (i,k), (k, j)라 하면 둘의 곱행렬의 행, 열 갯수는 (i, j)이다.
- 결과 행렬의 i행 j열은 a(i,k) * b(k,j)의 합이다.
