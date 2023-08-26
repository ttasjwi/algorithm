# 문제
- 플랫폼 : 백준
- 번호 : 15651
- 제목 : N과 M (3)
- 난이도 : Silver 3
- 1부터 N까지 자연수 중에서 M개를 고른 수열, 같은 수를 여러 번 골라도 된다. 수열들을 사전순으로 증가하는 순으로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/15651" target="_blank">링크</a>

---

# 필요 지식
- 백트래킹(DFS)

---

# 풀이
```kotlin
import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val n = i()
    val m = i()
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val arr = CharArray(2 * m) {' '}
    arr[2 * m - 1] = '\n'

    fun bt(idx: Int) {
        if (idx == m) { bw.write(arr);return}
        for (i in 1..n) {
            arr[idx * 2] = (i + 48).toChar()
            bt(idx + 1)
        }
    }
    bt(0)
    bw.flush()
}
```
- DFS를 이용한 백트래킹을 사용했다.
- 모든 자리에 모든 수가 올 수 있는 중복 순열이다.
- 각 자리를 순서대로 채우고, 다음 인덱스부터 재귀적으로 반복한다.
- idx가 최대 범위가 되는 순간 bw에 write 한다.

---
