# 문제
- 플랫폼 : 백준
- 번호 : 04134
- 제목 : 다음 소수
- 난이도 : Silver 4
- 각각의 테스트 케이스에 대해서 n보다 크거나 같은 소수 중 가장 작은 소수를 한 줄에 하나씩 출력
- 문제 : <a href="https://www.acmicpc.net/problem/4134" target="_blank">링크</a>

---

# 필요 지식
- 소수 판별

---

# 풀이
```kotlin
import kotlin.math.sqrt

fun main() {
    var t = i()
    while (t-- >0) {
        writeLong(goePrimeNumber(i()))
        writeByte(ASCII_n)
    }
    flushBuffer()
}

fun goePrimeNumber(i: Long): Long {
    var num = i
    while (true) {
        if (isPrimeNumber(num)) {
            break
        }
        num ++
    }
    return num
}

fun isPrimeNumber(num: Long): Boolean {
    if (num == 0L) return false
    if (num == 1L) return false
    for (i in 2..sqrt(num.toDouble()).toInt()) {
        if (num%i == 0L) return false
    }
    return true
}
```
- 어떤 수가 소수인지 판별하는 것은 그 수의 거듭제곱까지만 따지면 된다.