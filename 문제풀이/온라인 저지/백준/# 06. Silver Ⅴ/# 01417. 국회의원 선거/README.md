# 문제
- 플랫폼 : 백준
- 번호 : 01417
- 제목 : 국회의원 선거
- 난이도 : Silver 5
- 다솜이가 매수해야 하는 사람의 최솟값을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1417" target="_blank">링크</a>

---

# 필요 지식
- 그리디 알고리즘

---

# 풀이
```kotlin
fun main() {
    var n = i() - 1
    val dasom = i()
    var cnt = 0
    val heap = Heap(n)
    while (n-- > 0) heap.push(i())
    var cur: Int
    while (heap.isNotEmpty()) {
        cur = heap.pop()
        if (cur < dasom + cnt) break
        heap.push(cur - 1)
        cnt ++
    }
    writeInt(cnt)
    flushBuffer()
}
```
- 최대힙에 다른 후보들의 표수를 삽입하고 최대표수에서 1씩 차감하여 자신의 표수에 합산한다.
- 이렇게 반복하다가 자신의 표수가 최대이면 더 이상 표를 매수할 필요가 없다.