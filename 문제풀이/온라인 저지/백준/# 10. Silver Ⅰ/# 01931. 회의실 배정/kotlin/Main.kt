import java.util.*

fun main() {
    val n = i()
    val cons = Array(n) { Con(i(), i()) }
    Arrays.sort(cons)
    var current = 0
    var answer = 0
    for (con in cons) {
        if (con.isPossible(current)) {
            current = con.end
            answer++
        }
    }
    print(answer)
}

data class Con(val start: Int, val end: Int) : Comparable<Con> {
    override fun compareTo(other: Con): Int {
        return if (end == other.end) start - other.start else end - other.end
    }

    fun isPossible(current: Int): Boolean {
        return start >= current
    }

}

private const val S = 65536
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

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}
