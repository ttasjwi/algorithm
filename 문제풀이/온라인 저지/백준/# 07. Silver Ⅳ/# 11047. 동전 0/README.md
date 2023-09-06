# 문제
- 플랫폼 : 백준
- 번호 : 11047
- 제목 : 동전 0
- 난이도 : Silver 4
- 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 할 때 필요한 동전 개수의 최솟값
- 문제 : <a href="https://www.acmicpc.net/problem/11047" target="_blank">링크</a>

---

# 필요 지식
- 그리디 알고리즘

---

# 풀이
```kotlin
fun main() {
    val n = i()
    var k = i()
    val units = IntArray(n)
    for (i in 0..n-1) {
        units[n-1-i] = i()
    }
    var answer = 0
    for (unit in units) {
        if (k == 0) break
        k = (k%unit).also { answer += k/unit }
    }
    print(answer)
}
```
- 동전의 큰 단위가 각각 이전 작은 단위의 배수이므로, 가능한 큰 단위의 동전으로 교환할 수록 동전을 적게 사용할 수 있다.
- 큰 동전 단위부터 순서대로 환전해 나간다.

---
