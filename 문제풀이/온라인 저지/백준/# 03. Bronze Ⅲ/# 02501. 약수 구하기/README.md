# 문제
- 플랫폼 : 백준
- 번호 : 02501
- 제목 : 약수 구하기
- 난이도 : Bronze 3
- N의 약수들 중 K번째로 작은 수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2501" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
## Kotlin
```kotlin
fun main() {
    val n = readInt()
    val k = readInt()

    var result = 0
    var cnt = 0

    for (i in 1..n) {
        if (n % i == 0) {
            cnt ++
            if (cnt == k) {
                result = i
                break
            }
        }
    }
    print(result)
}
```
- result에 0을 담는다.
- 1부터 n까지 순서대로 탐색하면서, k번째 약수를 result에 담은 뒤 반복을 탈출한다.
- result를 출력한다

---
