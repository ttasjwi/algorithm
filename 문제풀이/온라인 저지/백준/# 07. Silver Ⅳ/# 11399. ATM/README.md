# 문제
- 플랫폼 : 백준
- 번호 : 11399
- 제목 : ATM
- 난이도 : Silver 4
- 첫째 줄에 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/11399" target="_blank">링크</a>

---

# 필요 알고리즘
- 정렬
- 그리디 알고리즘

---

# 풀이
```kotlin
fun main() {
    var n = i()
    var sum = 0
    val counter = IntArray(1001)
    var min = 1000
    var max = 1
    while (n-- > 0) {
        counter[i().also {
            if (min > it) min = it
            if (max < it) max = it
        }] ++
    }
    var cur = 0
    for (i in min..max) {
        while (counter[i] > 0) {
            cur += i
            sum += cur
            counter[i] --
        }
    }
    print(sum)
}
```
- 적은 시간이 드는 사람을 빨리 처리하게 하고, 시간이 오래 걸리는 사람을 나중에 처리하면 공동체 전체의 시간 비용 합계에서는 이득이다.
- 정렬 대신 카운팅 정렬을 하면 좀 더 빠르게 처리할 수 있다
- 순서대로 시간을 누적합 시키고, 누적합을 계속 더해나간다.

---
