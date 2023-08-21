import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val str = st.nextToken()
    var n = st.nextToken().toInt()
    val sb = StringBuilder()
    while(n --> 0) {
        sb.append(str)
    }
    print(sb)
}
