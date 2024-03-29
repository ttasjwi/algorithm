# 문제
- 플랫폼 : 백준
- 번호 : 01931
- 제목 : 회의실 배정
- 난이도 : Silver 1
- 최대 사용할 수 있는 회의의 최대 개수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1931" target="_blank">링크</a>

---

# 필요 알고리즘
- 정렬
- 그리디 알고리즘

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val cons = Array(n) { Con(i(), i()) }
    Arrays.sort(cons)
    var current = 0
    var answer = 0
    for (con in cons) {
        if (con.isPossible(current)) {
            current = con.end
            answer++
        }
    }
    print(answer)
}
```
- 정렬 순서가 중요하다.
  - 종료시간 순으로 오름차순 정렬하면, 일찍 종료하는 순서대로 대기실을 바로 예약시킬 수 있고 최대한 많은 사용자를 예약시킬 수 있다.
  - 종료시간이 같을 경우 시작순서 대로 오름차순 정렬을 해야한다.
    - 예를 들어 (2,3), (8,8), (3,8) 순과 같이 정렬되면 앞에서 8,8 로 current가 갱신되어 (3,8)을 포함시킬 수 없기 때문이다.

---
