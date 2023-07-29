# 문제
- 플랫폼 : 백준
- 번호 : 01193
- 제목 : 분수찾기
- 난이도 : Silver 5
- 첫째 줄에 분수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1193" target="_blank">링크</a>

---

# 필요 지식
- 수학

---

# 풀이
## Kotlin
```kotlin
fun main() {
    val x = readInt()
    var cursor = 1
    var line = 0

    while (true) {
        cursor += line
        line += 1
        if (cursor <= x && x < cursor + line) break // x가 속한 line 찾기
    }
    // 아래에서 후술
```
- 대각선의 방향이 바뀌는 단위로 라인을 구분한다.
  - 1번 라인 : 1/1
  - 2번 라인 : 1/2, 2/1
  - 3번 라인 : 3/1, 2/2, 1/3
- 각 라인의 규칙을 분석하면 다음과 같다.
  - i번 라인에는 i개의 분수가 있다.
  - 짝수 라인은 분자 증가, 분모 감소하고, 홀수 라인은 분자 감소, 분모 증가한다.
  - i번 라인의 분자, 분모의 합은 line + 1과 같다
- 우선 while문을 돌면서 x가 속한 line을 찾는다. x는 cursor보다 크거나 같고, cursor + line(다음 라인의 첫번째 위치)보다 작아야한다.
  - cursor : 찾고자하는 라인의 첫번째 숫자
  - line : x가 소속된 라인
```
    val a: Int // 분자
    val b: Int // 분모
    if (line % 2 == 0) {
        // 짝수라인 : 분자 증가, 분모 감소
        a = (x - cursor) + 1
        b = line - a + 1
    } else {
        // 홀수라인 : 분모 증가, 분자 감소
        b = (x - cursor) + 1
        a = line - b + 1
    }
    val sb = StringBuilder()
    sb.append(a).append('/').append(b)
    print(sb)
}
```
- x가 속한 line을 찾았다면 cursor와 x의 차이에 따라 a, b를 쉽게 구할 수 있다.

---

