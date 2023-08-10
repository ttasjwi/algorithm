# 문제
- 플랫폼 : 백준
- 번호 : 13241
- 제목 : 최소공배수
- 난이도 : Silver 5
- A와 B의 최소공배수를 한 줄에 출력
- 문제 : <a href="https://www.acmicpc.net/problem/13241" target="_blank">링크</a>

---

# 필요 지식
- GCD/LCM

---

# 풀이
```kotlin
fun main() {
    val a = l()
    val b = l()
    print(if (a >= b) lcm(a, b) else lcm(b, a))
}

private fun lcm(a:Long, b:Long) : Long {
    return a * b / gcd(a,b)
}

private fun gcd(a:Long, b:Long) : Long {
    val r = a % b
    return if (r == 0L) b else gcd(b, r)
}
```
- gcd, lcm 알고리즘을 통해 최소공배수를 구해 출력한다

---
