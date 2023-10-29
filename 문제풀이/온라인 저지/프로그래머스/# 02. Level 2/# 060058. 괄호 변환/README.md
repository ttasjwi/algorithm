# 문제
- 플랫폼 : 프로그래머스
- 번호 : 060058
- 제목 : 괄호 변환
- 난이도 : Level 2
- 소스 코드에 작성된 모든 괄호를 뽑아서 올바른 순서대로 배치된 괄호 문자열을 반환
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/60058" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리

---

# 풀이
```kotlin
private const val EMPTY_STRING = ""
private const val OPEN_CHAR = '('
private const val CLOSE_CHAR = ')'

class Solution {

    fun solution(p: String): String {
        if (p == EMPTY_STRING) return p
        val split = split(p)
        val u = split.first
        val v = split.second

        val sb = StringBuilder()
        if (isRight(u)) {
            sb.append(u)
            sb.append(solution(v))
            return sb.toString()
        }
        sb.append(OPEN_CHAR)
        sb.append(solution(v))
        sb.append(CLOSE_CHAR)
        for (i in 1..u.length - 2) {
            if (u[i] == OPEN_CHAR) sb.append(CLOSE_CHAR)
            else sb.append(OPEN_CHAR)
        }
        return sb.toString()
    }

    private fun split(w: String): Pair<String, String> {
        var i = 0
        var open = 0
        var close = 0
        while (i < w.length) {
            if (w[i] == OPEN_CHAR) open++
            else close++
            if (open == close) break
            i++
        }
        return Pair(w.substring(0, i + 1), if (i + 1 == w.length) EMPTY_STRING else w.substring(i + 1))
    }

    private fun isRight(u: String): Boolean {
        var open = 0
        for (ch in u) {
            if (ch == OPEN_CHAR) open++
            else if (open == 0) return false
            else open--
        }
        return open == 0
    }
}
```
- 문제에서 시키는 대로 하면 된다.
- 올바른 괄호 문자열인지 판별하는 부분만 주의하면 되는데, 이 부분은 굳이 스택을 만들지 않더라도 여는 괄호의 갯수를 open 변수로 누적시켜가면서, ')' 를 만날 때 차감시키면 된다.
- 여는 괄호가 0개인데 닫는 괄호가 등장하면 틀린 문자열이므로 바로 false를 반환하고, 최종적으로 여는 괄호가 남아있어도 false를 반환하면 된다.
- 문자열 결합에 있어 StringBuilder를 쓰는 것이 좋다.

---
