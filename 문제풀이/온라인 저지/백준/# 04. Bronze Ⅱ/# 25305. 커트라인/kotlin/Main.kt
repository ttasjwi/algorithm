fun main() {
    val check = IntArray(10001)
    var n = readInt()
    var k = readInt()
    while (n -- > 0) {
        check[readInt()] += 1
    }
    for (i in check.size -1 downTo 0) {
       if (check[i] >= 0) {
           k -= check[i]
           if (k <= 0) {
               print(i)
               return
           }
       }
    }
}

private fun readInt(): Int {
    var value = 0
    var input: Int
    while (true) {
        input = System.`in`.read()
        when (input) {
            10, 32 -> return value
            else -> value = value * 10 + (input - 48)
        }
    }
}
