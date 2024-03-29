# 문제
- 플랫폼 : 백준
- 번호 : 01181
- 제목 : 단어 정렬
- 난이도 : Silver 5
- N개의 단어가 들어오면, 길이가 짧은 것부터, 길이가 같으면 사전 순으로 정렬
- 문제 : <a href="https://www.acmicpc.net/problem/1181" target="_blank">링크</a>

---

# 필요 지식
- 정렬

---

# 풀이
```kotlin
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().toInt()
    val words = sortedSetOf<MyWord>()
    while (n --> 0) {
        words.add(MyWord(br.readLine()))
    }
    val sb = StringBuilder()
    for (word in words) {
        sb.append(word.word).append('\n')
    }
    print(sb)
}

data class MyWord(val word: String) : Comparable<MyWord> {

    override fun compareTo(other: MyWord): Int {
        return if (word.length == other.word.length) {
            word.compareTo(other.word)
        } else {
            word.length - other.word.length
        }
    }
}
```
- 중복 허용 x, 정렬필요 -> SortedSet
- Comparable 구현

---
