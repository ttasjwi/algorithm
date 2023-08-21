# 문제
- 플랫폼 : 백준
- 번호 : 01010
- 제목 : 다리 놓기
- 난이도 : Silver 5
- 다리를 놓되 서로 교차하지 않게 놓는 방법의 수 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/1010" target="_blank">링크</a>

---

# 필요 지식
- 수학(조합론)
- 다이나믹 프로그래밍

---

# 풀이
- 오른쪽 도시에서 n개를 택하면, 다리를 놓는 방법은 위부터 순서대로 놓아진다.
- m개 중 n개를 택하는 조합수를 구하면 된다.

## 풀이
```kotlin
private val comb = Array(31) { IntArray(31) }

fun main() {
    var t = i()
    var n: Int
    var m: Int
    val sb = StringBuilder()
    while (t-- > 0) {
        n = i()
        m = i()
        sb.append(comb(m,n)).append('\n')
    }
    print(sb)
}

private fun comb(n: Int, r: Int): Int {
    if (comb[n][r] > 0) {
        return comb[n][r]
    }
    if (r == 0 || r == n) {
        comb[n][r] = 1
        comb[r][n] = comb[n][r]
        return comb[n][r]
    }
    if (r == 1 || r == n-1) {
        comb[n][r] = n
        comb[r][n] = comb[n][r]
        return comb[n][r]
    }
    comb[n][r] = comb(n-1, r-1) + comb(n-1, r)
    comb[n][n-r] = comb[n][r]
    return comb[n][r]
}
```
- comb(n,r) 을 구하는 방법은 다음과 같다
  - comb(n, 0), comb(n, n) = 1
  - comb(n, 1), comb(n, n-1) = n
  - 그 외 : comb(n, r) = comb(n-1, r) + comb(n-1, r-1)
- 조합 계산은 한번 수행할 때마다 캐싱하면 이후 빠르게 배열 조회만으로 값을 다시 계산하지 않고 재사용할 수 있다.

---
