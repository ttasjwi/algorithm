fun main() {
    val n = i()
    if (n == 1) {
        print(1)
        return
    }
    var a = 1
    var b = 2
    for (i in 3..n) b = ((a+b)%15746).also { a = b }
    print(b)
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while (System.`in`.read().also { c = it } > 47)
    return v
}
