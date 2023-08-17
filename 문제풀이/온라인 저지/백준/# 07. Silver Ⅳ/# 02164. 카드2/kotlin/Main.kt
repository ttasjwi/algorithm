fun main() {
    val n = i()
    val c = n + 1
    val q = IntArray(c)
    var f = 0
    var r = n
    var s = n
    for (i in 1..n) q[i] = i

    while (s > 1) {
        f = (f + 2 + c) % c
        r = (r + 1 + c) % c
        q[r] = q[f]
        s --
    }
    print(q[r])
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while(System.`in`.read().also { c = it } > 47)
    return v
}