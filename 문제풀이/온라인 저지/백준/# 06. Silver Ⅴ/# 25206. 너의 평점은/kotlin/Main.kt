import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    var sum = 0.0
    var scoreSum = 0.0

    var score: Double
    var grade: String
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st: StringTokenizer

    for (i in 1..20) {
        st = StringTokenizer(br.readLine())
        st.nextToken()
        score = st.nextToken().toDouble()
        grade = st.nextToken()
        if (grade == "P") continue
        sum += score * when(grade) {
            "A+" -> 4.5
            "A0" -> 4.0
            "B+" -> 3.5
            "B0" -> 3.0
            "C+" -> 2.5
            "C0" -> 2.0
            "D+" -> 1.5
            "D0" -> 1.0
            else -> 0.0
        }
        scoreSum += score
    }
    print(sum/scoreSum)
}
