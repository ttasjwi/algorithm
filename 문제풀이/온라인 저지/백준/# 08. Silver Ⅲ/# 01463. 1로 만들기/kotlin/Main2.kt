fun main() {
    val n = i()
    fun recur(n: Int, cnt: Int): Int {
        return if (n in 0..1) cnt
               else minOf(recur(n/2, cnt+1+n%2), recur(n/3, cnt+1+n%3))
    }
    print(recur(n, 0))
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while (System.`in`.read().also { c = it } > 47)
    return v
}
