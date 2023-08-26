# 문제
- 플랫폼 : 백준
- 번호 : 15652
- 제목 : N과 M (4)
- 난이도 : Silver 3
- 1부터 N까지 자연수 중에서 M개를 비내림차순으로 중복을 허용하여 고른 수열을 사전 순으로 증가하는 순으로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/15652" target="_blank">링크</a>

---

# 필요 지식
- 백트래킹(DFS)

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val m = i()
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val arr = CharArray(2 * m) {' '}
    arr[2 * m - 1] = '\n'

    fun bt(idx: Int, start: Int) {
        if (idx == m) { bw.write(arr);return}
        for (i in start..n) {
            arr[idx * 2] = (i + 48).toChar()
            bt(idx + 1, i)
        }
    }
    bt(0, 1)
    bw.flush()
}


private const val S = 4
private val iS = java.io.DataInputStream(System.`in`)
private val b = ByteArray(S)
private var c = 0
private var l = 0

private fun i(): Int {
    var v = 0
    var c = r()
    do v = v * 10 + c - 48 while (r().also { c = it } > 47)
    return v
}
```
- DFS를 이용한 백트래킹을 사용했다.
- 이전 자리 이상의 수만 올 수 있다.
- 각 자리를 순서대로 채우고, 다음 인덱스부터 재귀적으로 반복한다.
- idx가 최대 범위가 되는 순간 bw에 write 한다.

---
