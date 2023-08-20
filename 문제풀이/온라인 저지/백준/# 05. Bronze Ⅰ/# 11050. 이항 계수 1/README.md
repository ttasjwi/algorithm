# 문제
- 플랫폼 : 백준
- 번호 : 11050
- 제목 : 이항 계수 1
- 난이도 : Bronze 1
- nCk 출력
- 문제 : <a href="https://www.acmicpc.net/problem/11005" target="_blank">링크</a>

---

# 필요 지식
- 수학

---

# 풀이
```kotlin
fun main() {
    factorial[0] = 1
    factorial[1] = 1

    val n = i()
    val k = i()
    print(factorial(n)/factorial(k)/factorial(n-k))
}

private fun factorial(x: Int): Int {
    if (factorial[x] >= 1) {
        return factorial[x]
    }
    factorial[x] = x * factorial(x-1)
    return factorial[x]
}
```
- Comb(n,k) = n! / k! * (n-k)!
- 배열에 팩토리얼 연산 결과를 캐싱함

---
