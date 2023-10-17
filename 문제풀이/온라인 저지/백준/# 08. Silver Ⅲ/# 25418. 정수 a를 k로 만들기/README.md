# 문제
- 플랫폼 : 백준
- 번호 : 25418
- 제목 : 정수 a를 k로 만들기
- 난이도 : Silver 3
- 양의 정수 A를 양의 정수 K로 만들기 위해 필요한 최소 연산 횟수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/25418" target="_blank">링크</a>

---

# 필요 알고리즘
- BFS
- DP

---

# 풀이
## 풀이1: BFS
```kotlin
fun main() {
    val a = i()
    val k = i()
    val queue = Queue(k - a + 1)
    val check = BooleanArray(k - a + 1)
    var cur: Int
    queue.enQueue(a)

    var cost = -1
    var size: Int
    var next: Int
    check[0] = true
    loop@ while (queue.isNotEmpty()) {
        cost++
        size = queue.size
        while (size-- > 0) {
            cur = queue.deQueue()
            next = cur + 1
            if (next == k) {
                cost++
                break@loop
            } else if (next < k && !check[next - a]) {
                check[next - a] = true
                queue.enQueue(next)
            }
            next = cur * 2
            if (next == k) {
                cost++
                break@loop
            } else if (next < k && !check[next - a]) {
                check[next - a] = true
                queue.enQueue(next)
            }
        }
    }
    writeInt(cost)
    flushBuffer()
}

class Queue(cap: Int) {
    var size = 0
    private var f = 0
    private var r = 0
    private val c = cap + 1
    private val arr = IntArray(c)
    fun enQueue(e: Int) {
        size++
        arr[((r + 1 + c) % c).also { r = it }] = e
    }

    fun deQueue(): Int {
        size--
        return arr[((f + 1 + c) % c).also { f = it }]
    }

    fun isNotEmpty() = size != 0
}
```
- 최단거리의 기본 아이디어인 BFS 를 통해 문제를 풀 수 있다.

## 풀이2: 다이나믹 프로그래밍
```kotlin
fun main() {
    val a = i()
    val k = i()
    val dp = IntArray(k + 1)
    var next: Int
    for (i in a until k) {
        next = i + 1
        if (dp[next] == 0) dp[next] = dp[i] + 1
        next = i * 2
        if (next <=k && dp[next] == 0) dp[next] = dp[i] + 1
    }
    writeInt(dp[k])
    flushBuffer()
}
```
- dp를 통해서도 해결할 수 있다.
- 매순간 그 지점에 도착했을 때는 자신의 최단거리가 계산됐음을 전제로 한다.
- 다음 지점의 최단거리가 0이면 아직 계산인 안 됐으므로 현재 비용에 1을 더함

---
