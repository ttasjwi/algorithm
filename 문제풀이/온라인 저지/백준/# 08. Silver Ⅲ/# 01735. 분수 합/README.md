# 문제
- 플랫폼 : 백준
- 번호 : 01735
- 제목 : 분수 합
- 난이도 : Silver 3
- 첫째 줄에 구하고자 하는 기약분수의 분자와 분모를 뜻하는 두 개의 자연수를 빈 칸을 사이에 두고 순서대로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1735" target="_blank">링크</a>

---

# 필요 지식
- GCD/LCM

---

# 풀이
```kotlin
fun main() {
    val a1 = i()
    val b1 = i()
    val a2 = i()
    val b2 = i()

    val a = a1 * b2 + a2 * b1
    val b = b1 * b2
    val gcd = if (a>=b) gcd(a,b) else gcd(b,a)
    val sb = StringBuilder()
    sb.append(a/gcd).append(' ').append(b/gcd)
    print(sb)
}

fun gcd(a: Int, b: Int): Int {
    val r = a % b
    return if (r == 0) b else gcd(b, r)
}
```
- 통분하여 합하기 (분모,분자를 곱하여 통분하고 분모 분자를 구한다)
- 약분하기 (분모, 분자의 최대공약수로 각각을 나눈다)

---
