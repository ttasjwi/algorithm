import kotlin.math.roundToInt

fun main() {
        val n = i()
        val counter = IntArray(8001)
        var v: Int
        var avg = 0
        var min = 4001
        var max = -4001
        for (i in 1..n) {
            v = i()
            counter[v + 4000] ++
            avg += v
            if (max < v) max = v
            if (min > v) min = v
        }
        avg = (avg/n.toDouble()).roundToInt()


        var cnt = 0
        var mode = -4001
        var modeCnt = 0
        var duplicate = false
        var mid = 4001
        for (i in min+4000..max+4000) {
            if (counter[i] > 0) {
                cnt += counter[i]
                if (mid == 4001 && cnt > n/2) {
                    mid = i - 4000
                }
                if (counter[i] > modeCnt) {
                    mode = i - 4000
                    modeCnt = counter[i]
                    duplicate = false
                } else if (counter[i] == modeCnt && !duplicate) {
                    mode = i - 4000
                    duplicate = true
                }
            }
        }
        val sb = StringBuilder()
        sb.append(avg).append('\n')
            .append(mid).append('\n')
            .append(mode).append('\n')
            .append(max-min)
        print(sb)
    }
    private const val S = 65536
    private val iS = java.io.DataInputStream(System.`in`)
    private val b = ByteArray(S)
    private var c = 0
    private var l = 0

    private fun i(): Int {
        var v = 0
        var c = r()
        val n = c.toInt() == 45
        c = if (n) r() else c
        do { v = v * 10 + c - 48 } while (r().also { c = it } > 47)
        return if (n) -v else v
    }

    private fun r(): Byte {
        if (c == l) {
            l = iS.read(b, 0.also { c = it }, S)
            if (l == -1) b[0] = -1
        }
        return b[c++]
    }