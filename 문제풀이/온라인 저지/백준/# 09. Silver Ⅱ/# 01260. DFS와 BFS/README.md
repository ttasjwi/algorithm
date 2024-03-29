# 문제
- 플랫폼 : 백준
- 번호 : 01260
- 제목 : DFS와 BFS
- 난이도 : Silver 2
- 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1260" target="_blank">링크</a>

---

# 필요 알고리즘
- DFS(깊이 우선 탐색)
- BFS(너비 우선 탐색)

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val m = i()
    val v = i()
    val g = Array(n + 1) { ArrayList<Int>() }
    val dq = DQ(m)
    val check = BooleanArray(n + 1)
    val sb = StringBuilder()

    var a: Int
    var b: Int
    for (i in 1..m) {
        a = i()
        b = i()
        g[a].add(b)
        g[b].add(a)
    }
    for (i in 1..n) g[i].sort()

    dq.eq(v)
    var x: Int
    while (dq.isNotEmpty()) {
        x = dq.dqLast()
        if (check[x]) continue
        check[x] = true
        sb.append(x).append(' ')
        for (i in g[x].size - 1 downTo 0) {
            if (check[g[x][i]]) continue
            dq.eq(g[x][i])
        }
    }
    sb.append('\n')

    for (i in 1..n) check[i] = false

    dq.eq(v)
    check[v] = true
    sb.append(v).append(' ')
    while (dq.isNotEmpty()) {
        x = dq.dq()
        for (next in g[x]) {
            if (check[next]) continue
            dq.eq(next)
            check[next] = true
            sb.append(next).append(' ')
        }
    }
    sb.append('\n')
    print(sb)
}

class DQ(cap: Int) {
    var f = 0
    var r = 0
    var s = 0
    val c = cap + 1
    val arr = IntArray(c + 1)
    fun eq(e: Int) {
        arr[((r + 1 + c) % c).also { r = it }] = e
        s++
    }
    fun dqLast() = arr[r.also { r = (it - 1 + c) % c; s-- }]
    fun dq() = arr[((f + 1 + c) % c).also { f = it; s-- }]
    fun isNotEmpty() = s > 0
}
```
- DFS는 스택, BFS는 큐를 기반으로 동작시켜야한다.
- 이 두가지를 모두 가능하게 할수 있는 자료구조는 덱이 있다.
- 배열로 원형 덱을 구현하고 DFS, BFS를 수행했다.

---
