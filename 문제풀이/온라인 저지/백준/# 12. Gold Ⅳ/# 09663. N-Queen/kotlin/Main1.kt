import kotlin.math.abs

var n = 0
var answer = 0
lateinit var columns: IntArray // i번쨰 행에서 퀸이 놓인 column 번호

fun main() {
    n = i()
    columns = IntArray(n)
    back(0)
    print(answer)
}

private fun back(r: Int) {
    if (r == n) {
        answer ++
        return
    }
    loop@for (c in 0..n-1) {
        for (x in 0..r-1) {
            if (columns[x] == c) {
                continue@loop
            } else if (r-x == abs(c - columns[x])) {
                continue@loop
            }
        }
        columns[r] = c
        back(r+1)
    }
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while(System.`in`.read().also { c = it } > 47)
    return v
}
