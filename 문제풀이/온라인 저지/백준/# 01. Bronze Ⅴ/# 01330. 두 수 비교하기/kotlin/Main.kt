import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readln())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    print(
        when {
            a > b -> ">"
            a < b -> "<"
            else -> "=="
        }
    )
}
