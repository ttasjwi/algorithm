fun main() {
    System.`in`.read(B, 0, S)
    var n = i()
    var name: String
    var command: String
    val people = sortedMapOf<String, Boolean>(reverseOrder())

    while (n-- > 0) {
        name = s()
        command = s()
        people[name] = command == "enter"
    }
    val sb = StringBuilder()
    for (entry in people.entries) {
        if (entry.value) {
            sb.append(entry.key).append('\n')
        }
    }
    print(sb)
}

const val S = 12000008
private val B = ByteArray(S)
private var p = 0
fun i(): Int {
    var v = 0
    var c = B[p++]
    do v = v * 10 + c - 48 while (B[p++].also { c = it } > 47)
    return v
}

fun s(): String {
    val f = p
    var l = 0
    while (B[p++] > 64) l++
    return String(B, f, l)
}
