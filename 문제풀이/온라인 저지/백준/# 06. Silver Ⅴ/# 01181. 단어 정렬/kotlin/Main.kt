import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().toInt()
    val words = sortedSetOf<MyWord>()
    while (n --> 0) {
        words.add(MyWord(br.readLine()))
    }
    val sb = StringBuilder()
    for (word in words) {
        sb.append(word.word).append('\n')
    }
    print(sb)
}

data class MyWord(val word: String) : Comparable<MyWord> {

    override fun compareTo(other: MyWord): Int {
        return if (word.length == other.word.length) {
            word.compareTo(other.word)
        } else {
            word.length - other.word.length
        }
    }
}
