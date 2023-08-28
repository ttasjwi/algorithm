fun main() {
    val n = i()
    val sumRow = IntArray(n)
    val sumColumn = IntArray(n)
    var result = Integer.MAX_VALUE
    var sumTotal = 0
    var num: Int

    for (i in 0 until n) {
        for (j in 0 until n) {
            num = i()
            sumTotal += num
            sumRow[i] += num
            sumColumn[j] += num
        }
    }

    val mid = n/2
    var diff: Int
    fun back(idx: Int, cnt: Int, sumTotal: Int) {
        // idx : 현재 인덱스
        // cnt : 몇 번째 선택?
        if (cnt == mid) {
            diff = Math.abs(sumTotal) // 이 시점의 sumDiff 절댓값은 팀A, 팀B의 점수 차와 같다
            if (diff == 0) {
                print(0)
                System.exit(0)
            }
            if (result > diff) {
                result = diff
            }
            return
        }
        if (idx == n) {
            // idx 값이 n이 되도록 충분히 조합을 못 채웠을 때
            return
        }
        // 현재 요소를 조합에 포함시킬 때
        back(idx + 1, cnt +1, sumTotal - sumRow[idx] - sumColumn[idx])
        // 현재 요소를 조합에 포함시키지 않을 때
        back(idx + 1, cnt, sumTotal)
    }

    back(0, 0, sumTotal)
    print(result)
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