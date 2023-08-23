fun main() {
    print(f(i()))
}

fun f(i: Int) : Long {
    return if (i == 0 || i == 1) 1L else i * f(i-1)
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while(System.`in`.read().also { c = it } > 47)
    return v
}
