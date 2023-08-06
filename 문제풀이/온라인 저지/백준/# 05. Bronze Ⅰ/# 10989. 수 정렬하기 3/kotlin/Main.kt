import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    var n = readInt()
    val counter = IntArray(10001)
    while (n -- > 0) {
        counter[readInt()] ++
    }
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var line: String
    for (i in 1..10000) {
        if (counter[i] == 0) {
            continue
        }
        line = "$i\n"
        while (counter[i]-- >0) {
            bw.write(line)
        }
    }
    bw.flush()
}

private fun readInt(): Int {
    var value = 0
    var input: Int
    while (true) {
        input = System.`in`.read()
        when (input) {
            10, 32 -> return value
            else -> value = value * 10 + (input - 48)
        }
    }
}
