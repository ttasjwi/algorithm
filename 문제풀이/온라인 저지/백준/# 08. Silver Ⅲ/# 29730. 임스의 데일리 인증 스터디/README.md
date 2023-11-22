# 문제
- 플랫폼 : 백준
- 번호 : 29730
- 제목 : 임스의 데일리 인증 스터디
- 난이도 : Silver 3
- 임스가 공부한 기록들을 주어진 규칙에 맞게 정렬 후 한 줄에 하나씩 출력
- 문제 : <a href="https://www.acmicpc.net/problem/29370" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리
- 정렬

---

# 풀이
```kotlin
private const val problemPrefix = "boj.kr/"
fun main() {
    var n = i()
    val studies = ArrayList<Study>()
    val problems = ArrayList<Int>()

    var input: String
    while (n -- > 0) {
        input = s()
        if (input.startsWith(problemPrefix)) {
            problems += input.substring(7).toInt()
        } else {
            studies += Study(input)
        }
    }
    studies.sort()
    problems.sort()

    for (study in studies) {
        writeStr(study.value)
        writeByte(ASCII_n)
    }
    for (problem in problems) {
        writeStr(problemPrefix)
        writeInt(problem)
        writeByte(ASCII_n)
    }
    flushBuffer()
}

class Study(val value: String): Comparable<Study> {
    override fun compareTo(other: Study): Int {
        val result = value.length - other.value.length
        if (result != 0) return result
        return value.compareTo(other.value)
    }
}
```
- 할 일 리스트, 문제 리스트 따로 관리
- 할 일 리스트는 길이순, 사전순 정렬
- 문제 리스트는 번호순 정렬
- 결과를 순서대로 출력
