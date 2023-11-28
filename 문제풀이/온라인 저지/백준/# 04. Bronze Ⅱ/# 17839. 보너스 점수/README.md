# 문제
- 플랫폼 : 백준
- 번호 : 17839
- 제목 : 보너스 점수
- 난이도 : Bronze 2
- 입력으로 들어온 OX표의 점수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/17839" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
```kotlin
private const val O: Byte = 79

fun main() {
    val n = i()
    var input: Byte
    var answer = 0
    var bonus = 0
    for (level in 1..n) {
        input = r()
        if (input == O) {
            answer += (level + (bonus++))
        } else {
            bonus = 0
        }
    }
    r()
    writeInt(answer)
    flushBuffer()
}
```
- 'O' 이면 레벨과 bonus 를 합산 후 bonus 증가
- 'X' 이면 bonus 초기화