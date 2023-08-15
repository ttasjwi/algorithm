# 문제
- 플랫폼 : 백준
- 번호 : 09012
- 제목 : 괄호
- 난이도 : Silver 4
- 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/9012" target="_blank">링크</a>

---

# 필요 지식
- 스택

---

# 풀이
```kotlin
fun main() {
    var t = i()
    var p: Int
    val stack = CharArray(50)
    val sb = StringBuilder()
    loop@while (t-- > 0) {
        s()
        p = 0
        for (ch in rsb) {
            if (ch == '(') {
                stack[p++] = ch
            } else if (p == 0) {
                sb.append("NO\n")
                continue@loop
            } else {
                p--
            }
        }
        sb.append(if (p ==0) "YES\n" else "NO\n")
    }
    print(sb)
}
```
- 배열을 이용해 스택 구현
- 열린 괄호는 무조건 삽입한다.
- 닫힌 괄호가 들어오면 기존의 열린 괄호를 하나 제거한다. 이 때 스택이 비어있다면 NO
- 최종적으로 스택이 비어있으면 NO, 비어있지 않으면 YES

---
