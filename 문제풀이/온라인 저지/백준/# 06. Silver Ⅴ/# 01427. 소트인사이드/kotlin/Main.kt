fun main() {
    val counter = IntArray(10)
    countNums(counter)
    val sb = StringBuilder()
    for (i in counter.indices.reversed()) {
        while (counter[i] --> 0) {
            sb.append(i)
        }
    }
    print(sb)
}

private fun countNums(counter: IntArray) {
    var input: Int
    while (true) {
        input = System.`in`.read()
        when (input) {
            10, 32 -> return
            else -> counter[input - 48] ++
        }
    }
}
