# 문제
- 플랫폼 : 백준
- 번호 : 25206
- 제목 : 너의 평점은
- 난이도 : Silver 5
- 치훈이의 전공평점을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/25206" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
## Kotlin
```kotlin
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    var sum = 0.0
    var scoreSum = 0.0

    var score: Double
    var grade: String
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st: StringTokenizer

    for (i in 1..20) {
        st = StringTokenizer(br.readLine())
        st.nextToken()
        score = st.nextToken().toDouble()
        grade = st.nextToken()
        if (grade == "P") continue
        sum += score * when(grade) {
            "A+" -> 4.5
            "A0" -> 4.0
            "B+" -> 3.5
            "B0" -> 3.0
            "C+" -> 2.5
            "C0" -> 2.0
            "D+" -> 1.5
            "D0" -> 1.0
            else -> 0.0
        }
        scoreSum += score
    }
    print(sum/scoreSum)
}
```
- 매 라인마다 읽을 때
  - 첫 토큰은 의미 없다.
  - 두번째 입력값은 학점이므로 변수에 저장한다.
  - 세번째 입력값은 등급인데 'P'이면 continue 한다
  - 점수 합에다 학점 * 과목평점(등급 변환값) 을 더한다.
  - 학점 합에 학점을 더한다.
- 최종적으로 점수합을 학점합으로 나누어 출력한다.

---