# 문제
- 플랫폼 : 프로그래머스
- 번호 : 181950
- 제목 : 문자열 반복해서 출력하기
- 난이도 : Level 0
- str이 n번 반복된 문자열을 만들어 출력하는 코드를 작성
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181950" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```kotlin
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val str = st.nextToken()
    var n = st.nextToken().toInt()
    val sb = StringBuilder()
    while(n --> 0) {
        sb.append(str)
    }
    print(sb)
}
```
