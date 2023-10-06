# 문제
- 플랫폼 : 백준
- 번호 : 06497
- 제목 : 전력난
- 난이도 : Gold 4
- 각 테스트 케이스마다 한 줄에 걸쳐 절약할 수 있는 최대 비용을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/6497" target="_blank">링크</a>

---

# 필요 지식
- 크루스칼 알고리즘
- 최소 스패닝 트리(MST)

---

# 풀이

## 간선
```kotlin
class Edge(val from: Int, val to: Int, val cost: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge) = this.cost - other.cost
}
```
- from : 시점
- to : 종점
- cost : 비용

## 최소 힙
```kotlin
class Heap(cap: Int) {
    private val arr = arrayOfNulls<Edge>(cap + 1)
    private var size = 0

    fun push(e: Edge) {
        arr[++size] = e
        var i = size
        var p = i shr 1
        while (p > 0) {
            if (arr[i]!! < arr[p]!!) {
                arr[p] = arr[i].also { arr[i] = arr[p] }
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
            arr[small] = arr[i].also { arr[i] = arr[small] }
            i = small
            lt = i shl 1
            rt = lt + 1
        }
        return e
    }

    fun isNotEmpty() = size != 0
}
```
- 간선의 비용이 작을 수록 최소인 최소힙을 구현했다

```kotlin
fun main() {
    var m: Int
    var n: Int
    var parent = IntArray(0)
    var heap: Heap
    var saveCost: Int
    var cnt: Int
    var cur: Edge
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
    while (true) {
        m = i()
        n = i()
        if (m == 0 && n == 0) {
            break
        }
        parent = IntArray(m) { it }
        heap = Heap(n)
        repeat(n) { heap.push(Edge(i(), i(), i())) }
        cnt = 0
        saveCost = 0
        while (heap.isNotEmpty()) {
            cur = heap.pop()
            if (cnt == m - 1) {
                saveCost += cur.cost
                continue
            }
            if (union(cur.from, cur.to)) {
                cnt++
            } else {
                saveCost += cur.cost
            }
        }
        writeInt(saveCost)
    }
    flushBuffer()
}
```
- 간선들을 입력받고 힙에 삽입한다.
- 간선에서 비용이 적은 것을 꺼내가면서 union - find한다.(크루스칼 알고리즘)
  - 이미 병합된 도로는 불필요한 도로이므로 절약비용에 합계를 더한다.
  - 이렇게 반복하다가 n-1개 도로 병합이 끝나면 그 이후 남은 도로들은 비용을 전부 절약비용에 누적한다.
  - 이 과정을 거치면서 모든 간선을 연결하면 최대절약비용이 나온다.
- 출력

---
