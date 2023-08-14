# 문제
- 플랫폼 : 백준
- 번호 : 28278
- 제목 : 스택 2
- 난이도 : Silver 4
- 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/28278" target="_blank">링크</a>

---

# 필요 지식
- 스택

---

# 풀이
```kotlin
fun main() {
    val s = Stack<Int>()
    var n = i()
    val sb = StringBuilder()
    while (n-- > 0) {
        when (i()) {
            1 -> s.push(i())
            2 -> sb.append(if (s.isEmpty()) "-1" else s.pop()).append('\n')
            3 -> sb.append(s.size).append('\n')
            4 -> sb.append(if (s.isEmpty()) "1\n" else "0\n")
            5 -> sb.append(if (s.isEmpty()) "-1" else s.peek()).append('\n')
        }
    }
    print(sb)
}
```
- 주어진 요청대로 스택에 데이터를 담고 빼고, 조회하면 된다.

---
