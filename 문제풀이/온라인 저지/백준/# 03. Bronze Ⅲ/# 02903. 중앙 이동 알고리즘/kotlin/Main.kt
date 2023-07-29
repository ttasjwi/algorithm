import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = (2 shl n-1) + 1 // 2의 n제곱 + 1
    print(m * m)
}