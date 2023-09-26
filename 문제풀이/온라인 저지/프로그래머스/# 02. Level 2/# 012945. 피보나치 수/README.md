# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012945
- 제목 : 피보나치 수
- 난이도 : Level 2
- n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12945" target="_blank">링크</a>

---

# 필요 지식
- DP
- 분할정복

---

# 풀이
## 풀이1: DP 방식
```kotlin
class Solution {
    fun solution(n: Int): Int {
        var p1 = 0
        var p2 = 1
        val div = 1_234_567
        for (i in 2..n) {
            p2 = ((p1 + p2)%div).also { p1 = p2 }
        }
        return p2
    }
}
```
- 바텀업 방식의 DP 사용

---

## 풀이2: 분할정복
```kotlin
class Solution {
    fun solution(n: Int): Int {
        val div = 1_234_567L
        fun multiply(a: Array<LongArray>, b: Array<LongArray>): Array<LongArray> {
            val result = Array(2){LongArray(2)}
            for (i in 0 until 2) {
                for (j in 0 until 2) {
                    for (k in 0 until 2) {
                        result[i][j] += a[i][k] * b[k][j]
                        result[i][j] %= div
                    }
                }
            }
            return result
        }

        fun pow(x: Int): Array<LongArray> {
            if (x == 1) return arrayOf(longArrayOf(1, 1), longArrayOf(1, 0))
            val tmp = pow(x / 2).let { multiply(it, it) }
            if (x % 2 == 0) return tmp
            return multiply(tmp, arrayOf(longArrayOf(1, 1), longArrayOf(1, 0)))
        }
        return pow(n-1)[0][0].toInt()
    }

}
```
- 행렬의 거듭제곱을 이용하는 방식이다.
- (an aN-1) = ((1 1)(1 0)) ^ n-1 (a1 a0) 이므로
- an = `(1, 1)(1,0) ^ n-1 [0]` 이다.
- 행렬의 거듭제곱은 분할정복으로 계산 가능하고 시간복잡도는 이 방식으로 풀 경우 O(log N) 이 된다.

---
