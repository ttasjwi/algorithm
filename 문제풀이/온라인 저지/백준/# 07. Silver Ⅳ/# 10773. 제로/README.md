# 문제
- 플랫폼 : 백준
- 번호 : 10773
- 제목 : 제로
- 난이도 : Silver 4
- 정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다. 이런 방식으로 최종적으로 모안 수들의 합 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/10773" target="_blank">링크</a>

---

# 필요 지식
- 스택

---

# 풀이
```kotlin
fun main() {
    var k = i()
    var input: Int
    val stack = IntArray(k)
    var p = 0
    var sum = 0
    while (k-- > 0) {
        input = i()
        if (input == 0) {
            sum -= stack[--p]
        } else {
            sum += input
            stack[p++] = input
        }
    }
    print(sum)
}
```
- 스택을 배열로 구현하고, 삽입/제거가 일어날 때 sum도 함께 계산

---
