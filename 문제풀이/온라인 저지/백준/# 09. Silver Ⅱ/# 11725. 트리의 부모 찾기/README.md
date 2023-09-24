# 문제
- 플랫폼 : 백준
- 번호 : 11725
- 제목 : 트리의 부모 찾기
- 난이도 : Silver 2
- N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/11725" target="_blank">링크</a>

---

# 필요 지식
- 트리
- BFS
- DFS

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val st = Stack(n)
    val graph = Array(n + 1) { ArrayList<Int>() }
    val parents = IntArray(n + 1) { -1 }

    var a: Int
    var b: Int
    for (i in 1..n-1) {
        a = i()
        b = i()
        graph[a].add(b)
        graph[b].add(a)
    }
    parents[1] = 0
    st.push(1)
    var cur: Int
    while (st.isNotEmpty()) {
        cur = st.pop()
        for (next in graph[cur]) {
            if (parents[next] >= 0) continue
            parents[next] = cur
            st.push(next)
        }
    }
    val sb = StringBuilder()
    for (i in 2..n) {
        sb.append(parents[i]).append('\n')
    }
    print(sb)
}

class Stack(cap: Int) {
    var p = 0
    val st = IntArray(cap)
    fun push(e: Int) {
        st[p++] = e
    }
    fun pop() = st[--p]
    fun isNotEmpty() = p != 0
}
```
- 배열로 스택을 구현했다.
- 1번 노드를 시작으로 하여 DFS를 수행하였고, 방문할 때마다 직속 부모를 배열에 기록한다.
- 이 때 부모가 존재하면 방문처리로 간주하기 때문에 한 번 방문한 노드에 다시 방문하지 않게 된다.
- 모든 간선의 갯수가 N-1개 이므로 시간 복잡도는 O(N)이 된다

---
