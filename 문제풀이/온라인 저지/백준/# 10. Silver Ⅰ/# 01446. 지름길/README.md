# 문제
- 플랫폼 : 백준
- 번호 : 01446
- 제목 : 지름길
- 난이도 : Silver 1
- 세준이가 운전해야하는 거리의 최솟값을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1446" target="_blank">링크</a>

---

# 필요 지식
- 다이나믹 프로그래밍
- 다익스트라

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val d = i()
    val inf = 10001
    val dp = IntArray(d+1) {inf}
    dp[0] = 0
    val graph = HashMap<Int, ArrayList<IntArray>>()

    var from: Int
    var to: Int
    var cost: Int
    for (i in 0 until n) {
        from = i()
        to = i()
        cost = i()
        if (to > d) continue
        if (!graph.containsKey(from)) {
            graph[from] = ArrayList()
        }
        graph[from]!!.add(intArrayOf(to, cost))
    }

    var alt: Int
    for (i in 0 until d) {
        if (dp[i+1] > dp[i] + 1) {
            dp[i+1] = dp[i] + 1
        }
        if (graph.containsKey(i)) {
            for (edge in graph[i]!!) {
                alt = dp[i] + edge[1]
                if (dp[edge[0]] > alt) {
                    dp[edge[0]] = alt
                }
            }
        }
    }
    writeInt(dp[d])
    flushBuffer()
}
```
- 이 문제 상황은 무조건 작은 쪽에서 큰 쪽으로 이동된다.
- 다이나믹 프로그래밍을 이용해 풀면 O(d)으로 충분히 간단한 방법으로 해결이 가능할 듯 하여 다이나믹 프로그래밍으로 풀었다.

---
