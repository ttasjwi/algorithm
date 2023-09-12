# 문제
- 플랫폼 : 백준
- 번호 : 10830
- 제목 : 행렬 제곱
- 난이도 : Gold 4
- 첫째 줄부터 N개의 줄에 걸쳐 행렬 A를 B제곱한 결과를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10830" target="_blank">링크</a>

---

# 필요 지식
- 분할 정복

---

# 풀이
```kotlin
fun main() {
    val c = 1000
    val n = i()
    val b = l()
    val a = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        for (j in 0 until n) {
            a[i][j] = i() % c
        }
    }
    fun multiply(x: Array<IntArray>, y: Array<IntArray>): Array<IntArray> {
        val result = Array(n) { IntArray(n) }
        for (i in 0 until n) {
            for (j in 0 until n) {
                for (k in 0 until n) {
                    result[i][j] += x[i][k] * y[k][j]
                    result[i][j] %= c
                }
            }
        }
        return result
    }

    fun pow(arr: Array<IntArray>, x: Long): Array<IntArray> {
        if (x == 1L) return arr
        if (x == 2L) return multiply(arr, arr)
        return if (x % 2 == 0L)
            pow(pow(arr, x / 2), 2)
        else
            multiply(pow(pow(arr, x / 2), 2), arr)
    }

    val result = pow(a, b)
    val sb = StringBuilder()
    for (i in 0 until n) {
        for (j in 0 until n) {
            sb.append(result[i][j]).append(' ')
        }
        sb.append('\n')
    }
    print(sb)
}
```
- b번 계속 제곱하는 것은 시간 초과
- 재귀적으로 분할해서 해결해야한다(반제곱, 반제곱 쪼개기)

---
