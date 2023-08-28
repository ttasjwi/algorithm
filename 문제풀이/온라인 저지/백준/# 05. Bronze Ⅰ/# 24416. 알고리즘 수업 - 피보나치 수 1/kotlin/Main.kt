fun main() {
    val n = i()
    var a = 1
    var b = 1
    for (i in 3..n) {
        b = (a+b).also { a = b }
    }
    print("$b ${n-2}")
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while(System.`in`.read().also { c = it } > 47)
    return v
}