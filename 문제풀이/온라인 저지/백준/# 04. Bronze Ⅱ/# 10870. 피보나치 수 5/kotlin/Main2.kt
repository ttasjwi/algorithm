private val p = IntArray(21)

fun main() {
    print(p(i()))
}

private fun p(x: Int): Int {
    if (x == 0 || p[x] > 0) {
        return p[x]
    }
    if (x == 1) {
        p[x] = 1
        return p[x]
    }
    p[x] =  p(x-2) + p(x-1)
    return p[x]
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while (System.`in`.read().also { c = it } > 47)
    return v
}