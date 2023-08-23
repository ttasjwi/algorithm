# 문제
- 플랫폼 : 백준
- 번호 : 25501
- 제목 : 재귀의 귀재
- 난이도 : Bronze 2
- 각 테스트케이스마다, isPalindrome 함수의 반환값과 recursion 함수의 호출 횟수를 한 줄에 공백으로 구분하여 출력
- 문제 : <a href="https://www.acmicpc.net/problem/25501" target="_blank">링크</a>

---

# 필요 지식
- 재귀
- 투포인터

---

# 풀이
```kotlin
fun main() {
    var t = i()
    while (t-- > 0) s()
    print(sb)
}

private const val S = 65536
private val iS = java.io.DataInputStream(System.`in`)
private val b = ByteArray(S)
private var c = 0
private var l = 0
private val rsb = StringBuilder()
private val sb = StringBuilder()

private var lt = 0
private var rt = 0
private var pd = 0
private var cnt = 0

private fun i(): Int {
    var v = 0
    var c = r()
    do v = v * 10 + c - 48 while (r().also { c = it } > 47)
    return v
}

private fun s() {
    var c = r()
    do rsb.append(c.toChar()) while (r().also { c = it } > 32)
    lt = 0
    rt = rsb.length - 1
    cnt = 0
    pd = 1
    while (true) {
        cnt ++
        if (lt >= rt) break
        if (rsb[lt] != rsb[rt]) {pd = 0; break}
        lt ++
        rt --
    }
    sb.append(pd).append(' ').append(cnt).append('\n')
    rsb.setLength(0)
}

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}
```
- 양 끝부터, 투 포인터를 이용하여 반대쪽 문자가 같은지 체크진다
- 이 때 체크하는 횟수를 기록해야한다(양쪽 인덱스가 같은지, 문자가 같은지)

---
