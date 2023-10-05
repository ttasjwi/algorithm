# 문제
- 플랫폼 : 백준
- 번호 : 14567
- 제목 : 선수과목(Prerequisite)
- 난이도 : Gold 5
- 1번 과목부터 N번 과목까지 차례대로 최소 몇 학기에 이수할 수 있는지를 한 줄에 공백으로 구분하여 출력
- 문제 : <a href="https://www.acmicpc.net/problem/14567" target="_blank">링크</a>

---

# 필요 지식
- 위상 정렬

---

# 풀이
```kotlin
fun main() {
    val n = i()
    var m = i()

    val inDegree = IntArray(n + 1)
    val counter = IntArray(n + 1)
    val graph = Array(n + 1) { ArrayList<Int>() }
    val q = Queue(n)

    var from: Int
    var to: Int
    while (m-- > 0) {
        from = i()
        to = i()
        graph[from] += to
        inDegree[to]++
    }

    for (i in 1..n) {
        if (inDegree[i] == 0) {
            q.enQueue(i)
        }
    }
    var cur: Int
    var size: Int
    var depth = 0
    while (q.isNotEmpty()) {
        size = q.size
        depth ++
        while (size -- > 0) {
            cur = q.deQueue()
            counter[cur] = depth
            for (next in graph[cur]) {
                inDegree[next] --
                if (inDegree[next] == 0) {
                    q.enQueue(next)
                }
            }
        }
    }

    for (i in 1..n) {
        writeInt(counter[i])
    }
    flushBuffer()
}

class Queue(cap: Int) {
    private val c = cap + 1
    private val arr = IntArray(c)
    private var f = 0
    private var r = 0
    var size = 0

    fun enQueue(e: Int) {
        size ++
        arr[((r+1+c)%c).also { r = it }] = e
    }
    fun deQueue() : Int {
        size --
        return arr[((f+1+c)%c).also { f = it }]
    }

    fun isNotEmpty() = size != 0
}
```
- depth는 0으로 초기화
- 진입차수가 0인 것들을 모두 큐에 삽입한다. 
- 큐가 빌 때까지 다음을 반복한다.
  - depth 를 1 증가시킨다.
  - 큐의 size만큼 요소를 꺼낸 뒤 카운터에 현 위치의 depth를 기록한다.
  - 연결된 노드들의 진입차수를 1 차감시킨다. 진입차수가 0이 된 것들은 큐에 삽입한다.
- 이 과정을 거치면 각 과목별 학기 수가 기록되고, 이들을 출력하면 된다.
