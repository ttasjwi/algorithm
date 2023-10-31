class Solution {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        val inf = 20_000_000
        val graph = Array(N+1){ArrayList<Edge>()}
        val heap = Heap(road.size)
        val cost = IntArray(N+1) { inf }
        for (r in road) {
            graph[r[0]] += Edge(r[1], r[2])
            graph[r[1]] += Edge(r[0], r[2])
        }
        heap.push(Edge(1, 0))
        cost[1] = 0
        var cur: Edge
        var alt: Int
        var answer = 0
        while (heap.isNotEmpty()) {
            cur = heap.pop()
            if (cost[cur.node] < cur.cost) continue
            if (cur.cost <= k) answer ++
            for (edge in graph[cur.node]) {
                alt = cur.cost + edge.cost
                if (cost[edge.node] > alt) {
                    cost[edge.node] = alt
                    heap.push(Edge(edge.node, alt))
                }
            }
        }
        return answer
    }
}

class Edge(val node: Int, val cost: Int) : Comparable<Edge> {

    override fun compareTo(other: Edge): Int {
        return this.cost - other.cost
    }
}

class Heap(cap: Int) {

    private val arr = arrayOfNulls<Edge>(cap + 1)
    private var size = 0

    fun push(e: Edge) {
        arr[++size] = e
        var i = size
        var p = i shr 1
        while (p > 0) {
            if (arr[i]!! < arr[p]!!) {
                arr[i] = arr[p].also{arr[p] = arr[i]}
                i = p
                p = i shr 1
            } else {
                break
            }
        }
    }

    fun pop(): Edge {
        val e = arr[1]!!
        arr[1] = arr[size]
        arr[size--] = null

        var i = 1
        var lt = i shl 1
        var rt = lt + 1
        var small = i
        while (true) {
            if (lt <= size && arr[lt]!! < arr[small]!!) small = lt
            if (rt <= size && arr[rt]!! < arr[small]!!) small = rt
            if (i == small) break
            arr[i] = arr[small].also{arr[small] = arr[i]}
            i = small
            lt = i shl 1
            rt = lt + 1
        }
        return e
    }

    fun isNotEmpty() = size != 0
}
