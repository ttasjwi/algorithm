fun main() {
    var value = 0
    var input: Int
    while (true) {
        input = System.`in`.read()
        value += when (input){
            10, 32 -> {
                break
            }
            in 65..79 -> (input-65)/3 + 3
            in 80..83 -> 8
            in 84..86 -> 9
            else -> 10
        }
    }
    println(value)
}
