fun main() {
    val n = i()
    var lt = i()
    var rt = i()

    var diffSum = rt - lt
    var gcd = diffSum
    var currentDiff: Int
    for (i in 0 until n-2) {
        lt = rt
        rt = i()
        currentDiff = rt - lt
        diffSum += currentDiff
        gcd = if (gcd >= currentDiff) gcd(gcd, currentDiff) else gcd(currentDiff, gcd)
    }
    print(diffSum / gcd - (n - 1))
}

private fun gcd(a: Int, b: Int): Int {
    val r = (a % b)
    return if (r == 0) b else gcd(b, r)
}


private const val S = 65536
private val iS = java.io.DataInputStream(System.`in`)
private val b = ByteArray(S)
private var c = 0
private var l = 0

private fun i(): Int {
    var v = 0
    var c = r()
    do v = v * 10 + c - 48 while (r().also { c = it } > 47)
    return v
}

private fun r(): Byte {
    if (c == l) {
        l = iS.read(b, 0.also { c = it }, S)
        if (l == -1) b[0] = -1
    }
    return b[c++]
}
