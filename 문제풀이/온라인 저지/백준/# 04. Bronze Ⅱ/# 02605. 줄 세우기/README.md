# 문제
- 플랫폼 : 백준
- 번호 : 02605
- 제목 : 줄 세우기
- 난이도 : Bronze 2
- 학생들이 처음에 줄을 선 순서대로 1번부터 번호를 매길 때, 첫째 줄에 학생들이 최종적으로 줄을 선 순서를 그 번호로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2605" target="_blank">링크</a>

---

# 필요 지식
- 자료 구조
- 연결 리스트

---

# 풀이
```kotlin
import java.util.LinkedList

fun main() {
    val n = i()
    val list = LinkedList<Int>()
    var distanceFromLast: Int
    for (e in 1..n) {
        distanceFromLast = i()
        list.add(list.size - distanceFromLast, e)
    }
    for (i in list) {
        writeInt(i)
    }
    flushBuffer()
}
```
- 문제 상황에서는 중간 삽입이 자주 일어난다.
- 배열 기반 자료구조보다는, 연결리스트 기반 자료구조가 좀 더 문제 해결에 유리하다.

---
