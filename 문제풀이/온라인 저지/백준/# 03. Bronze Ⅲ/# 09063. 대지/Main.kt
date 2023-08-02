fun main() {
    var n = readInt()
    var minX = 10001
    var minY = 10001
    var maxX = -10001
    var maxY = -10001
    var x: Int
    var y: Int
    while (n-- > 0) {
        x = readInt()
        y = readInt()

        if (x < minX) minX = x
        if (x > maxX) maxX = x
        if (y < minY) minY = y
        if (y > maxY) maxY = y
    }
    print((maxX - minX) * (maxY - minY))
}

private fun readInt(): Int {
    var value = 0
    var negative = false
    var input: Int
    while (true) {
        input = System.`in`.read()
        when (input) {
            10, 32 -> return if (negative) -value else value
            45 -> negative = true
            else -> value = value * 10 + (input - 48)
        }
    }
}
