private val factorial: IntArray = IntArray(11)

fun main() {
    factorial[0] = 1
    factorial[1] = 1

    val n = i()
    val k = i()
    print(factorial(n)/factorial(k)/factorial(n-k))
}

private fun factorial(x: Int): Int {
    if (factorial[x] >= 1) {
        return factorial[x]
    }
    factorial[x] = x * factorial(x-1)
    return factorial[x]
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while(System.`in`.read().also { c = it } > 47)
    return v
}
