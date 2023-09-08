# 문제
- 플랫폼 : 백준
- 번호 : 13305
- 제목 : 주유소
- 난이도 : Silver 3
- 표준 출력으로 제일 왼쪽 도시에서 제일 오른쪽 도시로 가는 최소 비용을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/13305" target="_blank">링크</a>

---

# 필요 지식
- 그리디 알고리즘

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val d = IntArray(n - 1)

    for (i in 0..n - 2) d[i] = i()
    val c = IntArray(n)
    for (i in 0..n - 2) c[i] = i()
    i()
    var lt = 0
    var rt: Int
    var answer = 0L
    while (lt < n - 1) {
        rt = lt + 1
        while (rt < n && c[lt] < c[rt]) {
            answer += c[lt].toLong() * d[rt - 1]
            rt++
        }
        answer += c[lt].toLong() * d[rt - 1]
        lt = rt
    }
    print(answer)
}
```
- lt, rt 포인터를 두고, rt는 lt의 다음 인덱스로 초기화한다
- rt에서의 주유비용이 lt에서 비용보다 작아질 때까지, lt에서 주요한다
- lt를 rt로 변경한다.
- 이 작업을 반복하면, 더 저렴한 비용의 주유소를 발견하는 지점까지만 주유하기를 반복할 수 있기 때문에 최선이다

---
