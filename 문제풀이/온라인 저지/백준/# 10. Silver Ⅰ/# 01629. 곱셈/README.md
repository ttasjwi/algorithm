# 문제
- 플랫폼 : 백준
- 번호 : 01629
- 제목 : 곱셈
- 난이도 : Silver 1
- 자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.
- 문제 : <a href="https://www.acmicpc.net/problem/1629" target="_blank">링크</a>

---

# 필요 지식
- 분할 정복

---

# 풀이
```kotlin
fun main() {
    val a = i()
    val b = i()
    val c = i().toLong()

    fun div(x: Int): Long {
        if (x == 0)
            return 1
        if (x == 1)
            return a % c

        val t = div(x / 2)

        return if (x % 2 == 0)
            (t * t) % c
        else
            ((t * t) % c * a % c)%c
    }
    print(div(b))
}
```
- b가 짝수 일 때 (a^b)%c == (a^b/2 % c * a^b/2 %c) % c
- b가 홀수 일 때 (a^b)%c == (a^b/2 % c * a^b/2 %c * a%c) % c
를 이용하여 재귀적으로 분할정복 한다

---
