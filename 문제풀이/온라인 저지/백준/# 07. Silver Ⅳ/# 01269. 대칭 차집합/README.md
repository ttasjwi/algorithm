# 문제
- 플랫폼 : 백준
- 번호 : 01269
- 제목 : 대칭 차집합
- 난이도 : Silver 4
- 대칭 차집합의 원소의 개수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1269" target="_blank">링크</a>

---

# 필요 지식
- 해시

---

# 풀이
```kotlin
fun main() {
    var na = i()
    var nb = i()

    val set = HashSet<Int>()
    var cnt = 0
    while (na --> 0) {
        set.add(i())
        cnt ++
    }
    var tmp: Int
    while (nb --> 0) {
        tmp = i()
        if (set.contains(tmp)) cnt -- else cnt ++
    }
    print(cnt)
}
```
- 첫번째 입력 원소들은 HashSet에 삽입(카운팅도 함께 함)
- 두번째 입력 원소들은 set에 이미 있을 경우 cnt 감소, set에 없을 경우 cnt 증가
- 최종적으로 cnt를 반환하면 됨

---
