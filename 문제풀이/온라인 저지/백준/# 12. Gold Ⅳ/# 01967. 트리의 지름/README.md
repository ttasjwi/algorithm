# 문제
- 플랫폼 : 백준
- 번호 : 01967
- 제목 : 트리의 지름
- 난이도 : Gold 4
- 트리의 지름을 구하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/1967" target="_blank">링크</a>

---

# 필요 지식
- 트리

---

# 풀이
```kotlin
fun main() {
    val n = i()
    if (n == 1) {
        print(0)
        return
    }
    val graph = Array(n+1) {ArrayList<IntArray>()}

    var a: Int
    var b: Int
    var c: Int
    for (i in 0 until n-1) {
        a = i()
        b = i()
        c = i()
        graph[a].add(intArrayOf(b, c))
        graph[b].add(intArrayOf(a, c))
    }
    var maxDistance = 0
    var maxNode = -1
    fun dfs(start: Int) {
        val st = arrayOfNulls<IntArray>(n-1)
        val check = BooleanArray(n+1)
        var size = 0
        check[start] = true
        st[size ++] = intArrayOf(start, 0)
        var cur: IntArray
        while (size > 0) {
            cur = st[--size]!!
            st[size] = null
            if (cur[1] > maxDistance) {
                maxDistance = cur[1]
                maxNode = cur[0]
            }
            for (next in graph[cur[0]]) {
                if (!check[next[0]]) {
                    check[next[0]] = true
                    st[size ++] = intArrayOf(next[0], cur[1] + next[1])
                }
            }
        }
    }
    dfs(1)
    maxDistance = 0
    dfs(maxNode)
    println(maxDistance)
}
```
- 트리의 지름을 구하는 방법
  - 임의의 점에서 출발하여 가장 먼 점을 찾는다.
  - 해당 점은 트리의 지름 양 끝 중 한 노드이다.
  - 이 위치에서 가장 먼 노드까지의 거리가 트리의 지름이다.
- 한 노드에서 가장 먼 거리를 구하는 것은 DFS를 이용한다.

---
