# 문제
- 플랫폼 : 백준
- 번호 : 01697
- 제목 : 숨바꼭질
- 난이도 : Silver 1
- 수빈이가 동생을 찾는 가장 빠른 시간을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1697" target="_blank">링크</a>

---

# 필요 지식
- BFS
- DP

---

# 풀이
## 풀이1: BFS
```kotlin
fun main() {
    val n = i()
    val m = i()
    if (n >= m) {
        print(n - m)
        return
    }
    val c = 2 * m + 1
    val check = BooleanArray(c)
    val q = IntArray(c)
    var f = 0
    var r = 1
    var s = 1
    q[1] = n
    check[n] = true
    var size: Int
    var cur: Int
    var next: Int
    var depth = -1
    loop@while(s > 0) {
        size = s
        depth ++
        while (size -->0) {
            cur = q[((f+1+c)%c).also { f = it }]
            s --
            for (i in 0..2) {
                next = when (i) {
                    0 -> cur - 1
                    1 -> cur + 1
                    else -> cur * 2
                }
                if (next == m) {depth += 1; break@loop}
                if (next in 0..c-1 && !check[next]) {
                    check[next] = true
                    q[((r + 1 + c)%c).also {r = it}] = next
                    s++
                }
            }
        }
    }
    print(depth)
}
```
- 시작 위치를 기준으로 bfs로 탐색하여 k까지 갈 수 있는 최대 depth를 찾는 방식

## 풀이2: DP
```kotlin
fun main() {
    val n = i()
    val m = i()
    if (n >= m) {
        print(n - m)
        return
    }
    val dp = IntArray(2*m+1)
    for (i in dp.indices) {
        dp[i] = -1
    }

    /**
     * n에서 m까지 가는데 필요한 시간
     */
    fun dp(m:Int) : Int {
        when {
            dp[m] >= 0 -> return dp[m]
            n >= m -> {
                // m이 n보다 작거나 같으면 역방향 이동하므로 두 위치 차만큼 이동해야함
                dp[m] = n-m
                return dp[m]
            }
            // n < m

            // m == 1일 때
            m == 1 -> {
                dp[m] = 1
                return dp[m]
            }

            // m이 짝수 : 텔레포트 해오기 vs 앞에서 걸어오기
            m%2 == 0 -> {
                dp[m] = Math.min(m-n , dp(m/2) + 1)
                return dp[m]
            }
            // m이 홀수 : 앞에서 걸어오기 vs 뒤에서 걸어오기
            else -> {
                dp[m] = Math.min(dp(m-1), dp(m+1)) + 1
                return dp[m]
            }
        }
    }
    print(dp(m))
}
```
- 거리를 계산하고 저장해가면서 재귀적으로 탐색하는 방식이다.
- n이 m보다 크거나 같으면 n에서 m에 갈 때는 1씩 빼면서 갈 수밖에 없으므로 바로 n-m를 반환한다.
- n이 m보다 작으면
  - k == 1 일 때 : 0에서 1로 가는 비용 (이 부분을 계산해두지 않으면 RecursionError가 발생한다.)
  - 그 외의 경우
    - k가 짝수 : 자기 앞에서 텔레포트 해온 경우, 걸어온 거리 중 최솟값이다.
    - k가 홀수 : 자기 앞에서 걸어서 경우, 그리고 자기 뒤에서 걸어서 온 경우 중에서 하나를 택하면 된다.

---
