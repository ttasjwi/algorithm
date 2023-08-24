var k = 0
lateinit var a: IntArray
lateinit var tmp: IntArray

fun main() {
    a = IntArray(i())
    tmp = IntArray(a.size)
    k = i()
    for (i in a.indices) a[i] = i()
    mergeSort(0, a.size - 1)

    // k번 삽입이 일어나지 않았을 경우 여기까지 옴
    print(-1)
}

private fun mergeSort(p: Int, r: Int) {
    val q: Int
    if (p < r) {
        q = (p + r) / 2

        // 분할 후 재귀적으로 각각 병합정렬
        mergeSort(p, q)
        mergeSort(q + 1, r)

        // 병합
        merge(p, q, r)
    }
}

private fun merge(p: Int, q: Int, r: Int) {
    var i = p
    var j = q + 1
    var t = 0
    // tmp에 양쪽 배열의 작은 것을 순서대로 삽입
    while (i<= q && j <= r) tmp[t++] = if (a[i] <= a[j]) a[i++] else a[j++]
    // 한쪽이라도 먼저 끝났으면 나머지를 연이어서 계속 삽입
    while (i <=q) tmp[t++] = a[i++]
    while (j<=r) tmp[t++] = a[j++]

    // tmp의 요소를 p번 인덱스부터 순차적으로 copy
    i = p
    t = 0
    while (i<=r) {
        a[i++] = tmp[t++]
        if (--k == 0) {
            // k번째 copy가 일어나면 출력
            print(a[i-1])
            System.exit(0)
        }
    }
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
