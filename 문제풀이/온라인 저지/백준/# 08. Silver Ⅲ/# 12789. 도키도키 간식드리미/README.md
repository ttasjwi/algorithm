# 문제
- 플랫폼 : 백준
- 번호 : 12789
- 제목 : 도키도키 간식드리미
- 난이도 : Silver 3
- 승환이가 무사히 간식을 받을 수 있으면 "Nice"(따옴표는 제외)를 출력하고 그렇지 않다면 "Sad"(따옴표는 제외)를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/12789" target="_blank">링크</a>

---

# 필요 지식
- 스택

---

# 풀이
```kotlin
fun main() {
    var n = i()
    val stack = IntArray(n)
    var v: Int
    var p = 0
    var target = 1
    while (n-- > 0) {
        v = i()
        if (v == target) {
            target++
            while (p > 0 && stack[p - 1] == target) {
                target += 1
                p--
            }
        } else {
            stack[p++] = v
        }
    }
    println(if (p > 0) "Sad" else "Nice")
}
```
- 한 명씩 설 수 있는 공간 : 스택
- 입력이 들어올 때, 현재 순서에 해당하는 사람이 들어오면 식사를 시킨다.(target 증가)
  - 그 후 스택에 남아있는 요소를 마지막 요소부터 순서대로 순회하면서 target과 같으면 식사를 보내고 taget을 증가시킨다
- 현재 순서가 아니면 스택에 삽입시킨다.
- 마지막 시점, 스택에 요소가 남아있으면 Sad 아니면 Nice

---
