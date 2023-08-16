fun main() {
    var line: String
    val sb = StringBuilder()
    val stack = CharArray(100)
    var p: Int
    var isValid: Boolean
    while(s().also { line = it } != ".") {
        p = 0
        isValid = true
        for (ch in line) {
            if (ch == '(' || ch == '[') stack[p++] = ch
            else if (ch == ')') {
                if (p == 0 || stack[p-1] == '[') {
                    isValid = false
                    break
                } else {
                    p--
                }
            } else if (ch == ']') {
                if (p == 0 || stack[p-1] == '(') {
                    isValid = false
                    break
                } else {
                    p--
                }
            }
        }
        sb.append(if (isValid && p == 0) "yes\n" else "no\n")
    }
    print(sb)
}

private const val S = 65536
private val iS = java.io.DataInputStream(System.`in`)
private val b = ByteArray(S)
private var c = 0
private var l = 0
private val rsb = StringBuilder()

private fun s(): String {
    var c = r()
    do rsb.append(c.toChar()) while (r().also { c = it } > 13)
    val s = rsb.toString()
    rsb.setLength(0)
    return s
}

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}
