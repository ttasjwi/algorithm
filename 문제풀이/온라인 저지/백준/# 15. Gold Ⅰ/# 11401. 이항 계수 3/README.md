# 문제
- 플랫폼 : 백준
- 번호 : 11401
- 제목 : 이항 계수 3
- 난이도 : Gold 1
- nCk 를 1,000,000,007로 나눈 나머지를 출력한다. (1<=n <=4_000_000, 0<=K<=N)
- 문제 : <a href="https://www.acmicpc.net/problem/11401" target="_blank">링크</a>

---

# 필요 지식
- 정수론
- 조합론
- 분할 정복
- 모듈러 곱셈 역원
- 페르마의 소정리
- 분할정복을 이용한 거듭제곱

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val k = i()
    val c = 1_000_000_007
    when (k) {
        n, 0 -> {
            print(1)
        }
        1, n - 1 -> {
            print(n)
        }
        else -> {
            var top = 1L
            var bottom = 1L

            for (i in 1..n) {
                top = (top * i) % c
                if (i == n - k) bottom *= top
                if (i == k) bottom *= top
            }
            bottom %= c
            fun div(x: Int): Long {
                if (x == 0)
                    return 1
                if (x == 1)
                    return bottom % c
                val t = div(x shr 1)

                return if (x % 2 == 0)
                    (t * t) % c
                else
                    (t * t) % c * bottom % c
            }
            print(top * div(c - 2) % c)
        }
    }

}
```
- 1_000_000_007을 c라 하자
- `nCk % c` 는 `(n! / r! (n-r)!)%c` 이다.
- 그러나 n의 범위는 4_000_000까지이고 이것을 팩토리얼 연산을 통해 구하면 시간 초과가 발생하게 된다
- 1_000_000_007은 소수인데 페르마의 소정리를 적용하면 `(r!(n-r)!)^-1 % c == (r!(n-r)!)^(c-2) % c`와 같다
- 따라서 구하는 것은 (n!%c * (r!(n-r)!)^c-2 %c) %c 와 같다
- 위의 c-2 거듭제곱부는 분할 정복을 이용한 거듭제곱 방식으로 구한다

---
