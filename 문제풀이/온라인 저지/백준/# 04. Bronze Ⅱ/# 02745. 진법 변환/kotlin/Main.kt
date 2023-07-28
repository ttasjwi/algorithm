import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken()
    val b = st.nextToken().toInt()
    var answer = 0
    for (ch in n) {
        answer = answer * b + (if (ch.isDigit()) ch - '0' else ch - 'A' + 10)
    }
    print(answer)
}
