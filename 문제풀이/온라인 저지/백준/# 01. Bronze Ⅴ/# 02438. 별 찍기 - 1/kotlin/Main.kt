import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {

    val st = StringTokenizer(readln())
    val sb = StringBuilder()
    for (i in 1..st.nextToken().toInt()) {
        repeat(i) {
            sb.append('*')
        }
        sb.append('\n')
    }
    print(sb)
}

