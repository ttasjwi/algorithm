# 문제
- 플랫폼 : 백준
- 번호 : 01753
- 제목 : 최단경로
- 난이도 : Gold 4
- 방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/1753" target="_blank">링크</a>

---

# 필요 지식
- 다익스트라 알고리즘

## 조건 읽기
- 정점 수 V = 20000
- 간선 수 E = 300000
- 일반 다익스트라 -> O(V^2) -> 400_000_000
- 우선순위 큐 다익스트라 -> O(ElogE) -> 5_458_380
- 우선순위 큐 다익스트라가 압도적으로 빠르고, 이 경우 일반 다익스트라로 시간 초과가 발생할 것 같다.

---

# 풀이
```kotlin
fun main() {
    val v = i()
    val e = i()
    val inf = 3_000_001
    val graph = Array(v + 1) { ArrayList<IntArray>() }
    val start = i()
    for (i in 0 until e) {
        graph[i()] += intArrayOf(i(), i())
    }
    val heap = Heap(e)
    val check = BooleanArray(v+1)
    val costs = IntArray(v + 1) { inf }
    heap.push(intArrayOf(start, 0))
    costs[start] = 0
    var cur: IntArray
    var alt: Int
    while (heap.s != 0) {
        cur = heap.pop()
        if (check[cur[0]]) continue
        check[cur[0]] = true
        for (next in graph[cur[0]]) {
            alt = cur[1] + next[1]
            if (costs[next[0]] < alt) continue
            costs[next[0]] = alt
            heap.push(intArrayOf(next[0], alt))
        }
    }
    val sb = StringBuilder()
    for (x in 1..v) {
        sb.append(if (costs[x] == inf) "INF" else costs[x]).append('\n')
    }
    print(sb)
}

class Heap(c: Int) {
    val heap = arrayOfNulls<IntArray>(c + 1)
    var s = 0

    fun pop() : IntArray {
        val e = heap[1]!!
        heap[1] = heap[s]
        heap[s--] = null
        var i = 1
        var lt = i shl 1
        var rt = lt + 1
        var small = i
        while (true) {
            if (lt <= s && heap[lt]!![1] < heap[small]!![1]) small = lt
            if (rt <= s && heap[rt]!![1] < heap[small]!![1]) small = rt
            if (small == i) break
            heap[small] = heap[i].also { heap[i] = heap[small] }
            i = small
            lt = i shl 1
            rt = lt + 1
            small = i
        }
        return e
    }

    fun push(e: IntArray) {
        heap[++s] = e
        var i = s
        var p = i shr 1
        while (p > 0) {
            if (heap[p]!![1] > heap[i]!![1]) {
                heap[i] = heap[p].also { heap[p] = heap[i] }
                i = p
                p = i shr 1
            } else {
                break
            }
        }
    }
}
```
- 우선순위 큐는 배열을 기반으로 한 최소힙을 통해 구현하였다.
  - 힙에 삽입하는 요소 : (도착지, 누적비용)
- 간선에 관한 정보는 배열로 구현하였다. (도착지, 비용)
- 우선순위 큐 다익스트라를 구현하였다.
- 힙이 빌 때까지 다음을 반복한다.
  - 힙에서 (도착지, 누적비용) 을 추출한다.
  - 만약 도착지가 체크되어 있다면 다음 반복으로 continue 한다.
  - 이 시점에서 도착지에서의 비용이 최종 갱신된다. 도착지를 체크한다.
  - 도착지에서 출발하는 모든 간선에 대해서
    - 연결된 노드의 도착 비용보다 현재 도착지에서 출발했을 때의 누적 비용이 저렴하면 힙에 (다음 도착지, 누적비용) 삽입한다.
    - 비용을 갱신한다.
- 최종적으로 도착지별 비용을 출력하면 된다. 

---
