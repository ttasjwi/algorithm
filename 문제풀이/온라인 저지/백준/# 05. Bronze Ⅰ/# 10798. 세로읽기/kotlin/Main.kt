import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var line: String
    val arr = Array(5) { CharArray(15) { ' ' } }
    for (i in arr.indices) {
        line = br.readLine()
        for (j in line.indices) {
            arr[i][j] = line[j]
        }
    }

    val sb = StringBuilder()
    for (j in arr[0].indices) { // 열
        for (i in arr.indices) { // 행
            if (arr[i][j] == ' ') continue
            sb.append(arr[i][j])
        }
    }
    print(sb)
}
