# 문제
- 플랫폼 : 백준
- 번호 : 11444
- 제목 : 피보나치 수 6
- 난이도 : Gold 4
- n번째 피보나치 수를 1,000,000,007으로 나눈 나머지를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/11444" target="_blank">링크</a>

---

# 필요 지식
- 행렬의 거듭제곱
- 분할 정복

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val c = 1_000_000_007L
    fun multiply(a: Array<LongArray>, b: Array<LongArray>): Array<LongArray> {
        val result = Array(2) { LongArray(2) }
        for (i in 0 until 2) {
            for (j in 0 until 2) {
                for (k in 0 until 2) {
                    result[i][j] += a[i][k] * b[k][j]
                    result[i][j] %= c
                }
            }
        }
        return result
    }
    fun pow(array: Array<LongArray>, n: Long): Array<LongArray> {
        if (n == 0L || n == 1L) return array
        if (n == 2L) return multiply(array, array)
        return if (n % 2 == 0L)
            pow(pow(array, n / 2), 2)
        else {
            multiply(pow(pow(array, n / 2), 2), array)
        }
    }
    print(pow(arrayOf(longArrayOf(1, 1), longArrayOf(1, 0)), n - 1)[0][0])
}
```
- n >= 2 일 때 다음 식이 성립한다.
  - `f(n) = 1 * f(n-1) + 1 * f(n-2)`
  - `f(n-1) = 1 * f(n-1) + 0 * f(n-2)`
- 이를 행렬로 표현하면 다음과 같다
    ```
    f(n)   =  1  1    f(n-1)
    f(n-1)    1  0    f(n-2)
    ```
    ```
    f(n)     =  1   1  ^ n-1     f(1) = 1
                              *
    f(n-1)      1   0            f(0) = 0
    ```
- ((1, 1) (1, 0)) 의 n-1 거듭제곱 행렬을 구하고 ((1) (0)) 에 곱한 뒤 0행 0열의 요소를 구하면 우리가 구하는 답이다

---
