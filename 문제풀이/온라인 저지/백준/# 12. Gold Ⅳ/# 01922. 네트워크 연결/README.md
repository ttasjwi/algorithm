# 문제
- 플랫폼 : 백준
- 번호 : 01922
- 제목 : 네트워크 연결
- 난이도 : Gold 4
- 모든 컴퓨터를 연결하는데 필요한 최소비용을 첫째 줄에 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1922" target="_blank">링크</a>

---

# 필요 지식
- 크루스칼 알고리즘
- 최소 스패닝 트리(MST)

---

# 풀이

## 간선
```kotlin
data class Edge(val from: Int, val to: Int, val cost: Int) : Comparable<Edge> {

    override fun compareTo(other: Edge): Int = this.cost - other.cost
}
```
- from : 시점
- to : 종점
- cost : 비용

## 최소 힙
```kotlin


class Heap(capacity: Int) {
    private val edges = arrayOfNulls<Edge>(capacity + 1)
    var size = 0

    fun push(e: Edge) {
        edges[++size] = e
        var i = size
        var p = i shr 1
        var tmp: Edge
        while (p > 0) {
            if (edges[i]!! < edges[p]!!) {
                tmp = edges[i]!!
                edges[i] = edges[p]
                edges[p] = tmp
                i = p
                p = i shr 1
            } else {
                break
            }
        }
    }

    fun pop(): Edge {
        val e = edges[1]!!
        edges[1] = edges[size]
        edges[size--] = null
        var i = 1
        var lt = i shl 1
        var rt = lt + 1
        var small = i
        var tmp: Edge
        while (true) {
            if (lt <= size && edges[lt]!! < edges[small]!!) small = lt
            if (rt <= size && edges[rt]!! < edges[small]!!) small = rt
            if (small == i) break
            tmp = edges[i]!!
            edges[i] = edges[small]
            edges[small] = tmp
            i = small
            lt = i shl 1
            rt = lt + 1
        }
        return e
    }
}
```
- 간선의 비용이 작을 수록 최소인 최소힙을 구현했다

```kotlin
fun main() {
    val n = i()
    val e = i()
    val parent = IntArray(n + 1) { it }
    val heap = Heap(e)
    repeat(e) { heap.push(Edge(i(), i(), i())) }

    fun find(x: Int): Int {
        if (parent[x] == x) return x
        parent[x] = find(parent[x])
        return parent[x]
    }

    fun union(a: Int, b: Int): Boolean {
        val aRoot = find(a)
        val bRoot = find(b)
        if (aRoot == bRoot) return false
        if (aRoot < bRoot) parent[bRoot] = aRoot
        else parent[aRoot] = bRoot
        return true
    }

    var cnt = 0
    var costSum = 0

    var edge: Edge
    while (heap.size > 0) {
        edge = heap.pop()
        if (union(edge.from, edge.to)) {
            cnt++
            costSum += edge.cost
            if (cnt == n - 1) {
                break
            }
        }
    }
    print(costSum)
}
```
- 간선들을 입력받고 힙에 삽입한다.
- 간선에서 비용이 적은 것을 꺼내가면서 union - find한다.(크루스칼 알고리즘)
- 이 과정을 거치면서 모든 간선을 연결하면 최소 스패닝 트리가 구성된다.

---
