# 문제
- 플랫폼 : 백준
- 번호 : 15702
- 제목 : 중간고사 채점
- 난이도 : Silver 5
- 가장 높은 점수를 얻은 학생의 번호와 점수를 공백으로 구분해 출력
- 문제 : <a href="https://www.acmicpc.net/problem/15702" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
## Kotlin
```kotlin
private const val O: Byte = 79

fun main() {
    val n = i()
    var m = i()
    val score = IntArray(n)
    for (i in 0 until n) {
        score[i] = i()
    }

    var answerId = 100001
    var answerSum = -1

    var id: Int
    var sum: Int
    var mark: Byte

    while (m-- > 0) {
        id = i()
        sum = 0
        for (i in 0 until n) {
            mark = r()
            r()
            if (mark == O) {
                sum += score[i]
            }
        }
        if (sum > answerSum) {
            answerSum = sum
            answerId = id
        } else if (sum == answerSum && answerId > id) {
            answerId = id
        }
    }
    writeInt(answerId)
    writeByte(ASCII_space)
    writeInt(answerSum)
    flushBuffer()
}
```
