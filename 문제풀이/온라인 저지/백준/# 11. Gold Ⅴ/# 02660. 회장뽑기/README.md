# 문제
- 플랫폼 : 백준
- 번호 : 02660
- 제목 : 회장뽑기
- 난이도 : Gold 5
- 첫째 줄에는 회장 후보의 점수와 후보의 수를 출력하고, 두 번째 줄에는 회장 후보를 오름차순으로 모두 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2660" target="_blank">링크</a>

---

# 필요 지식
- 플로이드 워셜

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val inf = 50
    val cost = Array(n+1) { IntArray(n+1) { inf } }
    var a: Int
    var b: Int
    while(true) {
        a = i()
        b = i()
        if (a == - 1) break
        cost[a][b] = 1
        cost[b][a] = 1
    }

    var alt: Int
    for (m in 1..n) {
        for (s in 1..n) {
            if (cost[s][m] == inf) continue
            for (e in 1..n) {
                if (s == e || cost[m][e] == inf) continue
                alt = cost[s][m] + cost[m][e]
                if (cost[s][e] > alt) {
                    cost[s][e] = alt
                }
            }
        }
    }
    var size = 0
    val stack = IntArray(inf)
    var minScore = inf
    var currentMaxScore: Int
    for (r in n downTo 1) {
        currentMaxScore = 0
        for (c in n downTo 1) {
            if (cost[r][c] != inf && currentMaxScore < cost[r][c]) {
                currentMaxScore = cost[r][c]
            }
        }
        if (currentMaxScore != 0 && currentMaxScore <= minScore) {
            if (currentMaxScore < minScore) {
                size = 0
                minScore = currentMaxScore
            }
            stack[size++] = r
        }
    }
    writeInt(minScore)
    writeInt(size)
    writeByte(ASCII_n)
    while(size > 0) {
        writeInt(stack[--size])
    }
    flushBuffer()
}
```
- 우선 플로이드 워셜로 각 회원별 최단거리를 계산한다
- 하나의 회원의 점수는 그 사람의 다른 회원까지의 최단 거리 중 최댓값을 의미한다.(무한인 경우 제외) 이를 currentMaxScore라고 하자.
- 점수의 최솟값을 minScore라 하자.
- n번째 회원부터 1번째 회원까지 역으로 탐색하면서
  - 각 회원별 currentMaxScore를 확인하고, minScore와 비교했을 때
  - 더 작으면 스택을 비우고 삽입한다.
  - 같으면 스택에 삽입한다.
- minScore, 스택의 사이즈를 출력하고, 스택에서 요소를 하나씩 꺼내가면서 출력한다.(오름차순)

---
