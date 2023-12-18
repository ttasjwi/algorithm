# 문제
- 플랫폼 : 백준
- 번호 : 21756
- 제목 : 지우개
- 난이도 : Bronze 2
- 홀수번째 요소를 지워나가면서, 축소시키고, 마지막으로 남는 수를 한 줄에 출력
- 문제 : <a href="https://www.acmicpc.net/problem/21756" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
```kotlin
fun main() {
    val n = i()
    var arr = IntArray(n)

    for (i in 0 until n) {
        arr[i] = i + 1
    }

    var newArr: IntArray
    while (arr.size > 1) {
        newArr = IntArray(arr.size / 2)
        for (i in 1 until arr.size step 2) {
            newArr[i / 2] = arr[i]
        }
        arr = newArr
    }
    writeInt(arr[0])
    flushBuffer()
}

private const val EOF = -1
private const val ASCII_minus: Byte = 45
private const val ASCII_0: Byte = 48
private val din = java.io.DataInputStream(System.`in`)
private val dout = java.io.DataOutputStream(System.out)
private val inbuffer = ByteArray(65536)
private var inbufferpointer = 0
private var bytesread = 0
private val outbuffer = ByteArray(65536)
private var outbufferpointer = 0
private val bytebuffer = ByteArray(20)

private fun i(): Int {
    var v = 0
    var c = r()
    do v = v * 10 + c - 48 while (isDigit(r().also { c = it }))
    return v
}

private fun r(): Byte {
    if (inbufferpointer == bytesread) fillBuffer()
    return if (bytesread == EOF) EOF.toByte() else inbuffer[inbufferpointer++]
}

private fun fillBuffer() {
    bytesread = din.read(inbuffer, 0.also { inbufferpointer = it }, inbuffer.size)
}

private fun writeInt(i: Int) {
    var i = i
    if (i == 0) {
        writeByte(ASCII_0)
    } else {
        if (i < 0) {
            writeByte(ASCII_minus)
            i = -i
        }
        var index = 0
        while (i > 0) {
            bytebuffer[index++] = (i % 10 + ASCII_0).toByte()
            i /= 10
        }
        while (index-- > 0) {
            writeByte(bytebuffer[index])
        }
    }
}

private fun writeByte(b: Byte) {
    if (outbufferpointer == outbuffer.size) flushBuffer()
    outbuffer[outbufferpointer++] = b
}

private fun flushBuffer() {
    if (outbufferpointer != 0) {
        dout.write(outbuffer, 0, outbufferpointer)
        outbufferpointer = 0
    }
}

private fun isDigit(b: Byte) = b >= ASCII_0
```
- 배열의 홀수 인덱스를 반복적으로 복사해서 새로운 배열에 할당하길 반복했다.

---
