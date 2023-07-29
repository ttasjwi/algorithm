import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() {
    val x = readInt()
    var cursor = 1
    var line = 0

    while (true) {
        cursor += line
        line += 1
        if (cursor <= x && x < cursor + line) break
    }
    val a: Int // 분자
    val b: Int // 분모
    if (line % 2 == 0) {
        // 짝수라인 : 분자 증가, 분모 감소
        a = (x - cursor) + 1
        b = line - a + 1
    } else {
        // 홀수라인 : 분모 증가, 분자 감소
        b = (x - cursor) + 1
        a = line - b + 1
    }
    val sb = StringBuilder()
    sb.append(a).append('/').append(b)
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
