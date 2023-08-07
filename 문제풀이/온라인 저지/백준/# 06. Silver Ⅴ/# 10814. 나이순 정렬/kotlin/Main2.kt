import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    var n = st.nextToken().toInt()
    val counter = arrayOfNulls<StringBuilder>(201)

    var age: Int
    var name: String
    while (n -- > 0) {
        st = StringTokenizer(br.readLine())
        age = st.nextToken().toInt()
        name = st.nextToken()
        counter[age] = counter[age] ?: StringBuilder()
        counter[age]!!.append(age).append(' ').append(name).append('\n')
    }

    val sb = StringBuilder()
    for (s in counter) {
        if (s !== null) {
            sb.append(s)
        }
    }
    print(sb)
}
