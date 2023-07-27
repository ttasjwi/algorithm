fun main() {
    val count = readInt()
    val isBlack = Array(100) { BooleanArray(100) }

    var x1:Int
    var y1:Int
    repeat(count) {
        x1 = readInt()
        y1 = readInt()
        for (y in y1 until y1+10) {
            for (x in x1 until x1+10) {
                isBlack[y][x] = true
            }
        }
    }
    var answer = 0
    for (x in 0..99) {
        for (y in 0..99) {
            if (isBlack[y][x]) answer ++
        }
    }
    print(answer)
}


private fun readInt(): Int {
    var value = 0
    var input: Int
    while (true) {
        input = System.`in`.read()
        when (input) {
            10, 32 -> return value // 공백이나 개행자
            else -> value = value * 10 + (input - 48)
        }
    }
}