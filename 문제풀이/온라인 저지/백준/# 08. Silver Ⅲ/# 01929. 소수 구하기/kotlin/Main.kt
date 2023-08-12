import java.lang.StringBuilder
import kotlin.math.sqrt

fun main() {
    val m = i()
    val n = i()

    val check = BooleanArray(n+1)
    check[0] = true
    check[1] = true

    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (!check[i]) {
            for (j in 2*i..n step i) {
                check[j] = true
            }
        }
    }
    val sb = StringBuilder()
    for (i in m..n) {
        if (!check[i]) {
            sb.append(i).append('\n')
        }
    }
    print(sb)
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while(System.`in`.read().also { c = it } > 47)
    return v
}
