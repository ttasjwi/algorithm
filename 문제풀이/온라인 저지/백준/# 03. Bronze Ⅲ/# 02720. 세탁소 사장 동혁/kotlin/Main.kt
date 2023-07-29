import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var c: Int
    val units = intArrayOf(25, 10, 5, 1)
    val sb = StringBuilder()

    repeat(br.readLine().toInt()) {
        c = br.readLine().toInt()

        for (unit in units) {
            sb.append(c/unit)
            sb.append(' ')
            c %= unit
        }
        sb.append('\n')
    }
    print(sb)
}
