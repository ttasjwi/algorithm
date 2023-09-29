# 문제
- 플랫폼 : 백준
- 번호 : 09372
- 제목 : 상근이의 여행
- 난이도 : Silver 4
- 상근이가 모든 국가를 여행하기 위해 타야 하는 비행기 종류의 최소 개수
- 문제 : <a href="https://www.acmicpc.net/problem/9372" target="_blank">링크</a>

---

# 필요 지식
- 그래프 이론

---

# 풀이
```kotlin
fun main() {
    val sb = StringBuilder()
    repeat (i()) {
        sb.append(i() - 1).append('\n')
        repeat(i()) {
            i()
            i()
        }
    }
    print(sb)
}
```
- 이 문제의 조건에서 '연결 그래프'라는 부분을 잘 확인해야하는데, 이 말은 임의의 두 점을 선택했을 때 반드시 그 둘을 잇는 경로가
존재함을 의미한다.
- 모든 정점이 연결되어있다는 것을 의미하는데, 이 경우 모든 정점을 순회하는 최단 거리는 정점의 갯수 -1 과 같다.

---

