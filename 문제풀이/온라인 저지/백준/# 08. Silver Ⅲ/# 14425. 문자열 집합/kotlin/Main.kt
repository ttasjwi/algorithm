fun main() {
    System.`in`.read(B,0,S)
    var n = i()
    var m = i()
    val s = HashSet<String>()
    while (n-->0) s.add(s())
    var c = 0
    while (m -->0) if (s() in s) c++
    print(c)
}

const val S=10020012
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


