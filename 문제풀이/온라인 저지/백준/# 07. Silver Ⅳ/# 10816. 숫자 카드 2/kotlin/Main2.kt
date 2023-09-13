import java.util.Arrays

fun main() {
    val n = i()
    val arr = IntArray(n)
    for (i in 0 until n) {
        arr[i] = i()
    }
    Arrays.sort(arr)
    var m = i()
    val sb = StringBuilder()
    var t: Int
    var lb = 0
    var ub = 0
    fun lb(t: Int) {
        var lt = 0
        var rt = n - 1
        var mid: Int
        lb = -1
        while (lt <= rt) {
            mid = (lt + rt) shr 1
            if (arr[mid] == t) {
                lb = mid
                rt = mid - 1
            } else if (arr[mid] > t) {
                rt = mid - 1
            } else {
                lt = mid + 1
            }
        }
    }

    fun ub(t: Int) {
        var lt = 0
        var rt = n - 1
        var mid: Int
        ub = -1
        while (lt <= rt) {
            mid = (lt + rt) shr 1
            if (arr[mid] == t) {
                ub = mid
                lt = mid + 1
            } else if (arr[mid] > t) {
                rt = mid - 1
            } else {
                lt = mid + 1
            }
        }
    }
    while (m-- > 0) {
        t = i()
        lb(t)
        if (lb == -1) {
            sb.append(0).append(' ')
        } else {
            ub(t)
            sb.append(ub - lb + 1).append(' ')
        }
    }
    print(sb)
}

private fun i(): Int {
    var v = 0
    var c = System.`in`.read()
    val n = c == 45
    c = if (n) System.`in`.read() else c
    do v = v * 10 + c - 48 while (System.`in`.read().also { c = it } > 47)
    return if (n) -v else v
}
