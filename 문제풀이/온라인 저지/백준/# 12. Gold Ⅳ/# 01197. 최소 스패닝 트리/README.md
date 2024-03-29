# 문제
- 플랫폼 : 백준
- 번호 : 01197
- 제목 : 최소 스패닝 트리
- 난이도 : Gold 4
- 그래프가 주어졌을 때, 그 그래프의 최소 스패닝 트리를 구하고, 최소 스패닝 트리의 가중치를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1197" target="_blank">링크</a>

---

# 필요 지식
- 크루스칼 알고리즘 -> 최소 스패닝 트리(MST)

---

# 풀이
```kotlin
fun main() {
    val v = i()
    val e = i()
    val parent = IntArray(v + 1) { it }
    val edges = arrayOfNulls<Edge>(e)
    for (i in 0 until e) {
        edges[i] = Edge(i(), i(), i())
    }
    Arrays.sort(edges)

    fun find(x: Int): Int {
        if (parent[x] == x) {
            return x
        }
        parent[x] = find(parent[x])
        return parent[x]
    }

    fun union(a:Int, b:Int) {
        val aRoot = find(a)
        val bRoot = find(b)
        if (aRoot < bRoot) parent[bRoot] = aRoot
        else if (aRoot > bRoot) parent[aRoot] = bRoot
    }
    var totalCost = 0
    var cnt = 0
    for (edge in edges) {
        if (find(edge!!.from) != find(edge.to)) {
            union(edge.from, edge.to)
            totalCost += edge.cost
            cnt ++
            if (cnt == v-1) break
        }
    }
    print(totalCost)
}


data class Edge(val from: Int, val to: Int, val cost: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int = cost - other.cost
}
```
- find 함수 : 루트 노드를 찾아내고 현재 부모를 루트 노드로 갱신
- union 함수 : 두 노드의 부모를 통일
- 간선들을 비용 순으로 오름차순 정렬한다. 
- 모든 간선을 순회하면서, 사이클이 없을 경우(부모가 서로 다를 경우)에 한하여 union하고 가중치를 더해 나간다.
- cnt를 세고 모든 노드들을 순회할 필요 없이, cnt가 v-1(노드-1)일 때 바로 탈출할 수 있다.

---
