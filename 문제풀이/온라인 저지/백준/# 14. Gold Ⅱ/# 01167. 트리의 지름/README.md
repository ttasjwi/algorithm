# 문제
- 플랫폼 : 백준
- 번호 : 01167
- 제목 : 트리의 지름
- 난이도 : Gold 2
- 트리의 지름을 구하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/1167" target="_blank">링크</a>

---

# 필요 지식
- 트리

---

# 풀이
```kotlin
fun main() {
    val v = i()
    val graph = Array(v+1) {ArrayList<IntArray>()}
    var from: Int
    var to: Int
    var cost: Int
    for (i in 0 until v) {
        from = i()
        while(true) {
            to = i()
            if (to == -1) break
            cost = i()
            graph[from].add(intArrayOf(to, cost))
        }
    }

    var maxDistance = 0
    var maxNode = -1
    fun dfs(start: Int) {
        val check = BooleanArray(v+1)
        val st = arrayOfNulls<IntArray>(v)
        var size = 1
        st[0] = intArrayOf(start, 0)
        check[start] = true
        var cur: IntArray
        while (size > 0) {
            cur = st[--size]!!
            if (cur[1] > maxDistance) {
                maxNode = cur[0]
                maxDistance = cur[1]
            }
            for (next in graph[cur[0]]) {
                if (!check[next[0]]) {
                    check[next[0]] = true
                    st[size++] = intArrayOf(next[0], cur[1] + next[1])
                }
            }
        }
    }
    dfs(1)
    dfs(maxNode.also{maxNode = -1; maxDistance = 0})
    println(maxDistance)
}
```
- 트리의 지름을 구하는 방법
  - 임의의 점에서 출발하여 가장 먼 점을 찾는다.
  - 해당 점은 트리의 지름 양 끝 중 한 노드이다.
  - 이 위치에서 가장 먼 노드까지의 거리가 트리의 지름이다.
- 한 노드에서 가장 먼 거리를 구하는 것은 DFS를 이용한다.

---
