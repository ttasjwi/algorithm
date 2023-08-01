import java.lang.StringBuilder
import kotlin.math.sqrt

fun main() {
    var n = readInt()
    if (n == 1) {
        return
    }
    val check = BooleanArray(n + 1)
    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (!check[i]) {
            for (j in 2 * i..n step (i)) {
                check[j] = true
            }
        }
    }
    val sb = StringBuilder()
    for (i in 2..n) {
        if (check[i]) continue
        while (n % i == 0) {
            sb.append(i).append('\n')
            n /= i
        }
        if (n == 1) {
            break
        }
    }
    print(sb)
}

private fun readInt(): Int {
    var value = 0
    var input: Int
    while (true) {
        input = System.`in`.read()
        when (input) {
            10, 32 -> return value // 공백이나 개행자
            else -> value = value * 10 + (input - 48)
        }
    }
}
