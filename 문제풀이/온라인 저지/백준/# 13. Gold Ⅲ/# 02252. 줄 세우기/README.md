# 문제
- 플랫폼 : 백준
- 번호 : 02252
- 제목 : 줄 세우기
- 난이도 : Gold 3
- 학생들을 앞에서부터 줄을 세운 결과를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2252" target="_blank">링크</a>

---

# 필요 지식
- 위상 정렬

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val m = i()

    val graph = Array(n + 1) { ArrayList<Int>() }
    val inDegree = IntArray(n + 1)

    var from: Int
    var to: Int

    repeat(m) {
        from = i()
        to = i()
        graph[from].add(to)
        inDegree[to]++
    }

    val st = IntArray(n)
    var size = 0
    for (i in 1..n) {
        if (inDegree[i] == 0) {
            st[size++] = i
            ws(i)
        }
    }

    var cur: Int
    while (size > 0) {
        cur = st[--size]
        for (next in graph[cur]) {
            inDegree[next]--
            if (inDegree[next] == 0) {
                st[size++] = next
                ws(next)
            }
        }
    }
    flushBuffer()
}
```
- 준비
  - 정점의 갯수
  - 인접 그래프 : 각 정점에서 나오는 간선 목록
  - 진입차수 배열(in) : 기본적으로 0으로 초기화한다.
  - 결과 배열 : 위상정렬의 결과를 담은 배열 또는 StringBuilder
- 간선 순회
  - 출발, 도착 간선이 있을 경우 도착 노드의 진입차수를 1 증가시킨다.
  - 인접 그래프에 시작점에서 나오는 간선을 삽입한다.
  - 이 때 단방향임에 유의한다.
- 정점 순회 : 진입차수가 0인 정점들
  - 배열 또는 StringBuilder에 삽입한다.
  - 정점을 스택에 삽입한다.
- 스택이 빌 때까지 반복
  - 정점을 꺼낸다.(진입차수가 0인 정점들)
  - 연결된 정점들에 대하여
    - 진입차수를 1씩 차감한다.
    - 진입차수가 0인 요소들을
      - 배열 또는 StringBuilder에 삽입힌다.
      - 정점을 스택에 삽입한다.
- 이렇게 구해진 결과 배열 또는 StringBuilder를 기반으로 결과를 출력한다.

---
