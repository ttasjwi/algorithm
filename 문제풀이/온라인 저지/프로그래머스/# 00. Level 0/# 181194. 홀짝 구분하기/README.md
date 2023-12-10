# 문제
- 플랫폼 : 프로그래머스
- 번호 : 181194
- 제목 : 홀짝 구분하기
- 난이도 : Level 0
- 자연수 n이 입력으로 주어졌을 때 만약 n이 짝수이면 "n is even"을, 홀수이면 "n is odd"를 출력
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181194" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```kotlin
fun main(args: Array<String>) {
    val a = readLine()!!.toInt()
    println("$a is ${if (a % 2 == 0) "even" else "odd"}")
}
```
