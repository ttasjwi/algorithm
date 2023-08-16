# 문제
- 플랫폼 : 백준
- 번호 : 04949
- 제목 : 균형잡힌 세상
- 난이도 : Silver 4
- 각 줄마다 해당 문자열이 균형을 이루고 있으면 "yes"를, 아니면 "no"를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/4949" target="_blank">링크</a>

---

# 필요 지식
- 스택

---

# 풀이
```kotlin
fun main() {
    var line: String
    val sb = StringBuilder()
    val stack = CharArray(100)
    var p: Int
    var isValid: Boolean
    while(s().also { line = it } != ".") {
        p = 0
        isValid = true
        for (ch in line) {
            if (ch == '(' || ch == '[') stack[p++] = ch
            else if (ch == ')') {
                if (p == 0 || stack[p-1] == '[') {
                    isValid = false
                    break
                } else {
                    p--
                }
            } else if (ch == ']') {
                if (p == 0 || stack[p-1] == '(') {
                    isValid = false
                    break
                } else {
                    p--
                }
            }
        }
        sb.append(if (isValid && p == 0) "yes\n" else "no\n")
    }
    print(sb)
}
```
- 배열로 stack 을 구현했다
- 여는 괄호가 들어오면 스택에 삽입한다
- 닫는 괄호가 들어오면 짝이 맞는지 확인한다.
  - 짝이 맞지 않으면 잘못된 문자열이다
  - 짝이 맞으면 스택의 마지막 문자를 한 칸 비운다
- 최종적으로 스택이 비어있으면 옳은 문자열이다.

---
