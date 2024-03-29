# 문제
- 플랫폼 : 백준
- 번호 : 18352
- 제목 : 특정 거리의 도시 찾기
- 난이도 : Silver 2
- 최단 거리가 정확히 K인 모든 도시들의 번호를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/18352" target="_blank">링크</a>

---

# 필요 알고리즘
- 다익스트라 알고리즘

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val m = i()
    val k = i()
    val x = i()

    val inf = 1_000_000
    val heap = Heap(m)
    val check = BooleanArray(n+1)
    val cost = IntArray(n+1) { inf }
    val graph = Array(n+1) {ArrayList<Int>()}
    for (i in 0 until m) {
        graph[i()] += i()
    }
    cost[x] = 0
    heap.push(Edge(x, 0))

    var cur: Edge
    var alt: Int
    var find = false
    while(heap.isNotEmpty()) {
        cur = heap.pop()
        if (check[cur.to]) continue
        if (cur.cost > k) break
        else if (cur.cost == k) {
            if (!find) find = true
            writeInt(cur.to)
            writeN()
        }
        check[cur.to] = true
        for (next in graph[cur.to]) {
            alt = cur.cost + 1
            if (cost[next] > alt) {
                cost[next] = alt
                heap.push(Edge(next, alt))
            }
        }
    }
    if (!find) {
        writeInt(-1)
    }
    flushBuffer()
}

data class Edge(val to: Int, val cost: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge) =  (cost - other.cost).let { if (it == 0) to - other.to else it}
}

class Heap(cap: Int) {

    private var size = 0
    private var heap = arrayOfNulls<Edge>(cap + 1)

    fun push(e: Edge) {
        heap[++size] = e
        var i = size
        var p = i shr 1
        while (p > 0) {
            if (heap[i]!! < heap[p]!!) {
                heap[i] = heap[p].also { heap[p] = heap[i] }
                i = p
                p = i shr 1
            } else {
                break
            }
        }
    }

    fun pop(): Edge {
        val e = heap[1]!!
        heap[1] = heap[size]
        heap[size--] = null

        var i = 1
        var lt = i shl 1
        var rt = lt + 1
        var small = i

        while (true) {
            if (lt <= size && heap[lt]!! < heap[small]!!) small = lt
            if (rt <= size && heap[rt]!! < heap[small]!!) small = rt
            if (small == i) break
            heap[small] = heap[i].also { heap[i] = heap[small] }
            i = small
            lt = i shl 1
            rt = lt + 1
        }
        return e
    }

    fun isNotEmpty() = size != 0
}
```
- 간선(Edge) : Comparable 구현
  - 비용이 작을 수록 우선순위 높음
  - 비용이 같다면 정점 번호가 작을 수록 우선순위 높음
- 배열로 최소 힙을 구현했다.
- 최소힙을 사용하여 다익스트라를 수행한다.
  - 큐에서 꺼낸 간선의 비용이 k보다 커지는 시점에서 반복을 탈출시켜 불필요한 반복을 최소화했다.
  - 큐에서 꺼낸 간선의 비용이 k일 경우
    - 최초로 k가 됐다면 find를 true로 갱신한다.
    - 출력에 추가
- 최종적으로 find가 false 이면 -1을 출력하면 된다.

---
