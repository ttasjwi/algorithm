# 문제
- 플랫폼 : 백준
- 번호 : 26069
- 제목 : 붙임성 좋은 총총이
- 난이도 : Silver 4
- 마지막 기록 이후 무지개 댄스를 추는 사람의 수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/26069" target="_blank">링크</a>

---

# 필요 지식
- 해시

---

# 풀이
```kotlin
fun main() {
    var n = i()
    val set = HashSet<String>()
    set += "ChongChong"
    var a: String
    var b: String
    while (n-- > 0) {
        a = s()
        b = s()

        if (a in set) {
            set += b
        } else if (b in set) {
            set += a
        }
    }
    print(set.size)
}


private const val S = 65536
private val iS = java.io.DataInputStream(System.`in`)
private val b = ByteArray(S)
private var c = 0
private var l = 0
private val rsb = StringBuilder()

private fun i(): Int {
    var v = 0
    var c = r()
    do v = v * 10 + c - 48 while (r().also { c = it } > 47)
    return v
}

private fun s(): String {
    var c = r()
    do rsb.append(c.toChar()) while (r().also { c = it } > 32)
    val s = rsb.toString()
    rsb.setLength(0)
    return s
}

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}
```
- Set에 "ChongChong"을 넣는다.
- 입력 라인이 들어올 때마다, 둘 중 하나가 set에 있으면 반대쪽도 set에 삽입한다.
- 마지막에 set의 size를 출력한다.

---
