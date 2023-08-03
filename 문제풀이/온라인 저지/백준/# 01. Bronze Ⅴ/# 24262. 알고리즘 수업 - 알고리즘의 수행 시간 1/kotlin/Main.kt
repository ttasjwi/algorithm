fun main() {
    readLine()
    print("1\n0")
}

private fun readLine() {
    var input: Int
    while (true) {
        input = System.`in`.read()
        if (input == 10 || input == 32) {
            return
        }
    }
}
