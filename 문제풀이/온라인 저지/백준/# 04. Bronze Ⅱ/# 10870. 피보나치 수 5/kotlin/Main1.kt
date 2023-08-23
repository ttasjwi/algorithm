fun main() {
    var a = 0
    var b = 1
    val x = i()
    if (x == 0 || x == 1) {
        print(x)
    }
    else {
        var tmp: Int
        for (i in 2..x) {
            tmp = b
            b += a
            a = tmp
        }
        print(b)
    }
}


private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while(System.`in`.read().also { c = it } > 47)
    return v
}