import java.util.HashMap
import java.util.TreeSet

fun main() {
    var n = i()
    val m = i()
    var s: String
    val map = HashMap<String, Int>()
    while (n-- > 0) {
        s = s()
        if (s.length < m) continue
        if (map.containsKey(s)) {
            map[s] = map[s]!! + 1
        } else {
            map[s] = 1
        }
    }
    val set = TreeSet<Str>()
    for (key in map.keys) {
        set.add(Str(key, map[key]!!))
    }
    for (str in set) {
        sb.append(str.s).append('\n')
    }
    print(sb)
}

data class Str(val s: String, val c: Int) : Comparable<Str> {

    override fun compareTo(other: Str): Int {
        var tmp = other.c - this.c
        if (tmp != 0) {
            return tmp
        }
        tmp = other.s.length - s.length
        if (tmp != 0) {
            return tmp
        }
        return s.compareTo(other.s)
    }

}

private const val S = 65536
private val iS = java.io.DataInputStream(System.`in`)
private val b = ByteArray(S)
private var c = 0
private var l = 0
private val sb = StringBuilder()

private fun i(): Int {
    var v = 0
    var c = r()
    do v = v * 10 + c - 48 while (r().also { c = it } > 47)
    return v
}

private fun s(): String {
    var c = r()
    do sb.append(c.toChar()) while (r().also { c = it } > 32)
    val s = sb.toString()
    sb.setLength(0)
    return s
}

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}
