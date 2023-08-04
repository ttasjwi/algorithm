# 문제
- 플랫폼 : 백준
- 번호 : 19532
- 제목 : 수학은 비대면강의입니다
- 난이도 : Bronze 2
- 문제의 답인 x와 y를 공백으로 구분해 출력한다.
- 문제 : <a href="https://www.acmicpc.net/problem/19532" target="_blank">링크</a>

---

# 필요 지식
- 수학
- 브루트 포스

---

# 풀이

## 풀이1
- 모든 케이스에 대해서 무차별 대입

## 풀이2
```kotlin
fun main() {
    val a = readInt()
    val b = readInt()
    val c = readInt()
    val d = readInt()
    val e = readInt()
    val f = readInt()

    val div = (a * e - b * d)
    val x = (e * c - b * f) / div
    val y = (a * f - c * d) / div

    val sb = StringBuilder()
    sb.append(x).append(' ').append(y)
    print(sb)
}
```
- 연립 일차 방정식의 해가 유일함이 보장되는 상황이다
- 연립 일차방정식의 유일해는 다음과 같다.
  - x = (ce-bf) / (ae-bd)
  - y = (af-cd) / (ae-bd)
- 문제에서는 유일해가 보장되므로 ae-bd는 0이 아닐 수밖에 없다.

---
