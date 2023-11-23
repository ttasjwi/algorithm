# 문제
- 플랫폼 : 백준
- 번호 : 01246
- 제목 : 온라인 판매
- 난이도 : Silver 4
- 경래가 책정한 가격과 이 가격으로 올릴 수 있는 수익을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1246" target="_blank">링크</a>

---

# 필요 지식
- 그리디 알고리즘
- 정렬

---

# 풀이
```kotlin
import java.util.*

fun main() {
    val n = i()
    val m = i()
    val costs = IntArray(m)

    for (i in 0 until m) {
        costs[i] = i()
    }
    Arrays.sort(costs)

    val head = minOf(n, m)

    var answerCost = 0
    var answerSum = 0
    var alt: Int
    for (i in 1..head) {
        alt = i * costs[costs.size-i]
        if (answerSum < alt) {
            answerCost = costs[costs.size-i]
            answerSum = alt
        }
    }

    writeInt(answerCost)
    writeByte(ASCII_space)
    writeInt(answerSum)
    flushBuffer()

}
```
- head : 최대한 팔 수 있는 사람 수(m, n 중 최솟값)
- costs 배열에 사람들이 부르는 가격을 받아 넣고 정렬한다.(내림차순 정렬해야하는데, 기본배열은 오름차순 정렬만 가능하다...)
- 비싼 가격부터 순서대로, 순회하며 그 시점까지 사람 수만큼 곱했을 때 가격이 최대 이익인지 판단한다. 이 과정에서 최대 이익, 그 시점 가격을 저장한다.
- 최종적으로 최대 이익을 내는 가격과 이익을 출력한다.

---
