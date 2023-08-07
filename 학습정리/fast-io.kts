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


// System.`in`.read(B,0,S) 로 읽기
const val S=10500007
private val B=ByteArray(S)
private var p=0
fun i():Int{
    var v=0
    var c=B[p++]
    do v=v*10+c-48 while(B[p++].also{c=it}>47)
    return v
}
fun s():String{
    val f=p; var l=0
    while(B[p++]>64)l++
    return String(B,f,l)
}

fun main()=System.out.bufferedWriter().run{
    System.`in`.read(B,0,S)