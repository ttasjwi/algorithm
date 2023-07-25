fun main() = with(System.`in`.bufferedReader()) {
    readln()
    var sum = 0
    readln().forEach {
        sum += (it - 48).code
    }
    print(sum)
}
