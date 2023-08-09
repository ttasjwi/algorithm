// 음수 포함o 정수 입력
private fun readInt(): Int {
    var value = 0
    var negative = false
    var input: Int
    while (true) {
        input = System.`in`.read()
        when (input) {
            10, 32 -> return if (negative) -value else value
            45 -> negative = true
            else -> value = value * 10 + (input - 48)
        }
    }
}

// 음수 포함x 정수 입력
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


const val S=10500007
private val B=ByteArray(S)
private var p=0
fun i():Int{
    var v=0
    var c=B[p++]
    do v=v*10+c-48 while(B[p++].also{c=it}>47)
    return v
}
private val rsb = StringBuilder()
fun s(): String {
    var c = B[p++]
    do {
        rsb.append(c.toChar())
    } while (B[p++].also { c = it } > 47)
    val s = rsb.toString()
    rsb.setLength(0)
    return s
}

fun main()=System.out.bufferedWriter().run{
    System.`in`.read(B,0,S)