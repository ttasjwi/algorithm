fun main() {
    System.`in`.read(B, 0, S)
    val n = i()
    var m = i()
    val arr = arrayOfNulls<String>(n + 1)
    val map = HashMap<String, Int>()
    var word: String
    for (i in 1..n) {
        word = s()
        arr[i] = word
        map[word] = i
    }
    while (m-- > 0) {
        word = s()
        wsb.append(if (word[0].isDigit()) arr[word.toInt()] else map[word]).append('\n')
    }
    print(wsb)
}

private val rsb = StringBuilder()
private val wsb = StringBuilder()

const val S = 4200014
private val B = ByteArray(S)
private var p = 0
fun i(): Int {
    var v = 0
    var c = B[p++]
    do v = v * 10 + c - 48 while (B[p++].also { c = it } > 47)
    return v
}

fun s(): String {
    var c = B[p++]
    do {
        rsb.append(c.toChar())
    } while (B[p++].also { c = it } > 47)
    val s = rsb.toString()
    rsb.setLength(0)
    return s
}
