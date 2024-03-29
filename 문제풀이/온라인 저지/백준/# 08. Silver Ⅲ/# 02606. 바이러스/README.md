# 문제
- 플랫폼 : 백준
- 번호 : 02606
- 제목 : 바이러스
- 난이도 : Silver 3
- 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를
출력하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/2606" target="_blank">링크</a>

---

# 필요 알고리즘
- DFS
- BFS
---

# 풀이
```kotlin
fun main() {
    val n = i()
    val check = BooleanArray(n+1)
    val graph = Array(n+1) {ArrayList<Int>()}

    var m = i()
    val c = m+1
    val q = IntArray(c)
    var f = 0
    var r = 0
    var s = 0
    var a:Int
    var b:Int
    while (m -- > 0) {
        a = i()
        b = i()
        graph[a].add(b)
        graph[b].add(a)
    }
    fun eq(e:Int) {
        q[((r+1+c)%c).also { r = it }] = e
        s ++
    }
    fun dq(): Int {
        s--
        return q[((f + 1 + c) % c).also { f = it }]
    }

    check[1] = true
    eq(1)
    var x: Int
    var answer = 0
    while (s != 0) {
        x = dq()
        for (next in graph[x]) {
            if (!check[next]) {
                check[next] = true
                answer ++
                eq(next)
            }
        }
    }
    print(answer)
}
```
- 배열기반 원형큐로 BFS를 구현했다.
- 큐에 삽입하기 전에, 도착 지점을 감염시키고 삽입한다.

---
