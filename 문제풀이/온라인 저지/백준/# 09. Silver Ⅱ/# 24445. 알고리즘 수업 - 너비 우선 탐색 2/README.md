# 문제
- 플랫폼 : 백준
- 번호 : 24445
- 제목 : 알고리즘 수업 - 너비 우선 탐색 2
- 난이도 : Silver 2
- 너비 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력(내림차순)
- 문제 : <a href="https://www.acmicpc.net/problem/24445" target="_blank">링크</a>

---

# 필요 알고리즘
- BFS

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val c = IntArray(n + 1)
    val g = Array(n + 1) { ArrayList<Int>() }

    var m = i()
    val q = IntArray(m+1)
    q[1] = i()
    var f = 0
    val cap = m
    var r = 1
    var s = 1

    var o = 0

    var a: Int
    var b: Int
    while (m-- > 0) {
        a = i()
        b = i()
        g[a].add(b)
        g[b].add(a)
    }
    for (i in 1..n) if (!g[i].isEmpty()) Collections.sort(g[i])

    var x: Int
    while (s != 0) {
        s--
        x = q[((f + 1 + cap) % cap).also { f = it }]
        if (c[x] > 0) continue
        c[x] = ++o
        for (i in g[x].size -1 downTo 0) {
            if (c[g[x][i]] == 0) {
                q[((r++) + 1 + cap) % cap] = g[x][i]
                s ++
            }
        }
    }
    val sb = StringBuilder()
    for (i in 1..n) {
        sb.append(c[i]).append('\n')
    }
    print(sb)
}
```
- 배열 기반 원형 큐로, 너비 우선 탐색을 구현했다.
- 내림차순으로 방문해함에 주의한다.

---
