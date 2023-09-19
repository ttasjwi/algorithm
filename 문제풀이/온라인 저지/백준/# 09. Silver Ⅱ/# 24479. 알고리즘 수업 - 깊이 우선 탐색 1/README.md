# 문제
- 플랫폼 : 백준
- 번호 : 24479
- 제목 : 알고리즘 수업 - 깊이 우선 탐색 1
- 난이도 : Silver 2
- 깊이 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/24479" target="_blank">링크</a>

---

# 필요 알고리즘
- DFS

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val c = IntArray(n + 1)
    val g = Array(n + 1) { ArrayList<Int>() }

    var m = i()
    val st = IntArray(m)
    st[0] = i()
    var p = 0
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
    while (p >= 0) {
        x = st[p--]
        if (c[x] > 0) continue
        c[x] = ++o
        for (i in g[x].size - 1 downTo 0) {
            if (c[g[x][i]] == 0) {
                st[++p] = g[x][i]
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
- 스택으로 깊이 우선 탐색을 구현했다.
- 재귀 방식과 달리 역순으로 삽입해야 사전순 방문이 가능하다.

---
