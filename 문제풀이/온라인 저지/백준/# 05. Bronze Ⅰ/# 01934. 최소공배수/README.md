# 문제
- 플랫폼 : 백준
- 번호 : 01934
- 제목 : 최소공배수
- 난이도 : Bronze 1
- 첫째 줄부터 T개의 줄에 A와 B의 최소공배수를 입력받은 순서대로 한 줄에 하나씩 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1934" target="_blank">링크</a>

---

# 필요 지식
- GCD, LCM

---

# 풀이
```kotlin
fun main() {
    var t = i()
    val sb = StringBuilder()
    var a: Int
    var b: Int
    var tmp: Int
    while (t-- > 0) {
        a = i()
        b = i()
        if (a < b) {
            tmp = a
            a = b
            b = tmp
        }
        sb.append(lcm(a,b)).append('\n')
    }
    print(sb)
}

private fun lcm(a: Int, b: Int): Int {
    return a * b / gcd(a,b)
}

private fun gcd(a: Int, b: Int): Int {
    val r = a % b
    return if (r == 0) b else gcd(b, r)
}
```
- gcd
  - 두 수 중 큰 수를 a, b라 하고, a를 b로 나눈 나머지를 r이라 하자
  - r이 0일 경우 a,b의 최대 공약수는 r이다.
  - r이 0이 아닐 경우 b,r의 최대공약수가 최대 공약수다. (재귀)
- lcm
  - a, b의 곱을 최대공약수로 나눈 값이 최소공배수다
