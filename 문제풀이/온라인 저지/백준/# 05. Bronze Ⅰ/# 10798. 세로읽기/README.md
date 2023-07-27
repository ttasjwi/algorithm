# 문제
- 플랫폼 : 백준
- 번호 : 10798
- 제목 : 세로읽기
- 난이도 : Bronze 1
- 영석이가 세로로 읽은 순서대로 글자들을 출력한다. 이때, 글자들을 공백 없이 연속해서 출력한다.
- 문제 : <a href="https://www.acmicpc.net/problem/10798" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
## Kotlin
```kotlin
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var line: String
    val arr = Array(5) { CharArray(15) { ' ' } }
    for (i in arr.indices) {
        line = br.readLine()
        for (j in line.indices) {
            arr[i][j] = line[j]
        }
    }

    val sb = StringBuilder()
    for (j in arr[0].indices) { // 열
        for (i in arr.indices) { // 행
            if (arr[i][j] == ' ') continue
            sb.append(arr[i][j])
        }
    }
    print(sb)
}
```
- 행단위로 배열을 채운다.
- 열단위로 이중 for문을 돌면서 StringBuilder 에 append 한다.

---
