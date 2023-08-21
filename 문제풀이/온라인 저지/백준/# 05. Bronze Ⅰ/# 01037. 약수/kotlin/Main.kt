fun main() {
    var x = i()
    var min = 1_000_001
    var max = 1
    var input: Int
    while (x -- > 0) {
        input = i()
        if (input > max) max = input
        if (input < min) min = input
    }
    print(max * min)
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while(System.`in`.read().also { c = it } > 47)
    return v
}