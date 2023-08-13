import kotlin.math.sqrt

fun main() {
    val n = i()
    val answer = sqrt(n.toDouble()).toInt()
    print(answer)
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while(System.`in`.read().also { c = it } > 47)
    return v
}
