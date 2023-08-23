fun main() {
    var a = 1L
    for (i in 2..i()) a *= i
    print(a)
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while(System.`in`.read().also { c = it } > 47)
    return v
}
