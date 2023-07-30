fun main() {
    val n = readInt()
    val k = readInt()

    var result = 0
    var cnt = 0

    for (i in 1..n) {
        if (n % i == 0) {
            cnt ++
            if (cnt == k) {
                result = i
                break
            }
        }
    }
    print(result)
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