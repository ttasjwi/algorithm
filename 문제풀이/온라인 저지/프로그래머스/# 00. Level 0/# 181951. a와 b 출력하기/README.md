# 문제
- 플랫폼 : 프로그래머스
- 번호 : 181951
- 제목 : a와 b 출력하기
- 난이도 : Level 0
- a, b 를 입력받고 형식화해서 출력
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181951" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```kotlin
fun main(args: Array<String>) {
    val a = i()
    val b = i()
    val sb = StringBuilder()
    sb.append('a').append(' ').append('=').append(' ').append(a).append('\n')
        .append('b').append(' ').append('=').append(' ').append(b)
    println(sb)
}


private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    val n = c == 45
    c = if (n) System.`in`.read() else c
    do { v = v * 10 + c - 48 } while (System.`in`.read().also { c = it } > 47)
    return if (n) -v else v
}
```
- 그대로 출력함
- 근데 프로그래머스에서는, 테스트 시간 통과만 된다면 속도는 약간 포기하고 쉽게 풀어도 되지 않을까 싶다.
