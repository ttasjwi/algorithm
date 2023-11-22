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

private const val EOF = -1
private const val ASCII_n: Byte = 10
private const val ASCII_0: Byte = 48
private val din = java.io.DataInputStream(System.`in`)
private val dout = java.io.DataOutputStream(System.out)
private val inbuffer = ByteArray(65536)
private var inbufferpointer = 0
private var bytesread = 0
private val outbuffer = ByteArray(65536)
private var outbufferpointer = 0
private val bytebuffer = ByteArray(20)
private val rsb = StringBuilder()

private fun i(): Int {
    var v = 0
    var c = r()
    do v = v * 10 + c - 48 while (isDigit(r().also { c = it }))
    return v
}

private fun s(): String {
    var c = r()
    do rsb.append(c.toChar()) while (!isN(r().also { c = it }))
    val s = rsb.toString()
    rsb.setLength(0)
    return s
}

private fun r(): Byte {
    if (inbufferpointer == bytesread) fillBuffer()
    return if (bytesread == EOF) EOF.toByte() else inbuffer[inbufferpointer++]
}

private fun fillBuffer() {
    bytesread = din.read(inbuffer, 0.also { inbufferpointer = it }, inbuffer.size)
}

private fun writeStr(s: String) {
    for (ch in s) {
        writeByte(ch.toByte())
    }
}


private fun writeInt(i: Int) {
    var i = i
    if (i == 0) {
        writeByte(ASCII_0)
    } else {
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

private fun isN(b: Byte) = b <= ASCII_n
private fun isDigit(b: Byte) = b >= ASCII_0
