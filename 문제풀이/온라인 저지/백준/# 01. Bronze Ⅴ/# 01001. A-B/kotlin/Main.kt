import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readln())
    print(st.nextToken().toInt() - st.nextToken().toInt())
}
