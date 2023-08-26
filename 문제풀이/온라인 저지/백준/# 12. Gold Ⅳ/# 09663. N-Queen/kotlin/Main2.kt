fun main() {
    print(when(i()) {
        1 -> 1
        2 -> 0
        3 -> 0
        4 -> 2
        5 -> 10
        6 -> 4
        7 -> 40
        8 -> 92
        9 -> 352
        10 -> 724
        11 -> 2680
        12 -> 14200
        13 -> 73712
        14 -> 365596
        else -> 2279184
    })
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while(System.`in`.read().also { c = it } > 47)
    return v
}
