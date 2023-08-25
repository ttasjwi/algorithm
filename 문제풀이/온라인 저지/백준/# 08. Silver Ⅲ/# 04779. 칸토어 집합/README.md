# 문제
- 플랫폼 : 백준
- 번호 : 04779
- 제목 : 칸토어 집합
- 난이도 : Silver 3
- 입력으로 주어진 N에 대해서, 해당하는 칸토어 집합의 근사를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/4779" target="_blank">링크</a>

---

# 필요 지식
- 재귀
- 분할 정복

---

# 풀이
```kotlin
import java.io.BufferedReader
import java.io.InputStreamReader

val sb = StringBuilder()
val ssb = StringBuilder()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n: Int
    var len: Int
    while (true) {
        n = br.readLine()?.toInt() ?: break
        len = Math.pow(3.0, n.toDouble()).toInt()
        for (i in 0 until len) ssb.append('-')
        foo(0, len)
        sb.append(ssb).append('\n')
        ssb.setLength(0)
    }
    print(sb)
}

fun foo(start: Int, len: Int) {
    if (len == 1) return
    if (len == 3) {ssb[start+1] = ' '; return}
    for (i in start+len/3 until start+(len*2)/3) ssb[i] = ' '
    foo(start, len/3)
    foo(start + (len*2)/3, len/3)
}
```
- 전체가 주어지면 가운데 1/3은 전부 비운다.
- 나머지 왼쪽 끝, 오른쪽 끝은 재귀적으로 처리하면 된다.
- 분할된 영역의 길이가 1일 때는 '-' 을 반환하면 된다.
---
