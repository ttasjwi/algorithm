# 문제
- 플랫폼 : 백준
- 번호 : 11404
- 제목 : 플로이드
- 난이도 : Gold 4
- 모든 도시의 쌍 (A, B)에 대해서 도시 A에서 B로 가는데 필요한 비용의 최솟값을 구하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/11404" target="_blank">링크</a>

---

# 필요 지식
## 플로이드 워셜 알고리즘
- 시간복잡도 : O(N^3)
- 모든 정점으로부터 다른 정점으로의 최단거리들을 모두 구해야할 때, 그리고 이들 중 특정 구간에서 음의 사이클이 발생하는 경우를 감지할 때
사용하는 알고리즘
- 자기 자신으로 오는 비용은 0으로 초기화한다.
- 3중 for문을 통해, 어떤 중간점 m, 그리고 이 중간점으로 오는 모든 경우 s, e를 잡아 s에서 e로 갈 때와, s에서 m을 거쳐 e로 갈 때의 비용을
비교하여 더 작은 값을 갱신한다.
  - s, m, e 중 두개 이상이 같으면 같으면 의미 없으므로 스킵
  - s에서 m까지 비용, m부터 e까지 비용이 무한이면 계산하지 않음
- 음의 간선이 포함될 경우 s,m,e가 중 적어도 하나가 같더라도 갱신될 수 있다. 음의 사이클의 존재 여부를 판단할 때
이렇게 판단하다가 i행 i열의 임의의 노드에서, 자기 자신으로 도착하는 비용이 음수로 갱신되는 지를 판단한다.

---

# 풀이

## 풀이
```kotlin
fun main() {
    val n = i()
    var bus = i()
    val inf = 10_000_000
    val cost = Array(n) { i -> IntArray(n) { j -> if (i == j) 0 else inf } }
    var a: Int
    var b: Int
    var c: Int
    while (bus -- > 0) {
       a = i() - 1
       b = i() - 1
       c = i()
       if (cost[a][b] > c) cost[a][b] = c
    }
    var alt: Int
    for (m in 0 until n) {
        for (s in 0 until n) {
            if (s == m || cost[s][m] == inf) continue
            for (e in 0 until n) {
                if (s == e || m == e || cost[m][e] == inf) continue
                alt = cost[s][m] + cost[m][e]
                if (cost[s][e] > alt) cost[s][e] = alt
            }
        }
    }
    for (s in 0 until n) {
        for (e in 0 until n) {
            writeInt(cost[s][e].let { if (it == inf) 0 else it })
            writeByte(ASCII_space)
        }
        writeByte(ASCII_n)
    }
    flushBuffer()
}
```
- 플로이드 워셜 알고리즘을 통해 3중 for문을 돌며 비용을 갱신하고, 결과를 출력한다.
  - 중간점 m / 시작점 s /  종점 e 순으로 반복해야 한다.
- 비용이 무한이면 0으로 바꿔서 출력한다.
- i에서 j로 갈 수는 없는 경우 0으로 출력하라고 되어 있는 조건을 확인해보면
  - 비용이 무한이면 문제의 제약조건 대로 0으로 바꿔 출력한다.
  - 나머지는 그냥 자신의 비용을 그대로 문자열로 바꿔 출력하면 된다.
    - 자기 자신으로 가는 비용은 0이고, 자기 자신으로 갈 수 없다는 제약 조건이 있지만 결국 무한과 동일하게 출력된다.

---
