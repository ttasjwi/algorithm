# 문제
- 플랫폼 : 백준
- 번호 : 01037
- 제목 : 약수
- 난이도 : Bronze 1
- 1과 n을 제외한 n의 약수들이 주어질 때 n을 구하시오.
- 문제 : <a href="https://www.acmicpc.net/problem/1037" target="_blank">링크</a>

---

# 필요 지식
- 수학

---

# 풀이
```kotlin
fun main() {
    var x = i()
    var min = 1_000_001
    var max = 1
    var input: Int
    while (x -- > 0) {
        input = i()
        if (input > max) max = input
        if (input < min) min = input
    }
    print(max * min)
}
```
- 최소, 최대를 구하고 곱하면 된다.