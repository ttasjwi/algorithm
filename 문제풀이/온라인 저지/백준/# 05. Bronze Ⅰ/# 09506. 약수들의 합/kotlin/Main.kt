import java.lang.StringBuilder
import kotlin.math.sqrt

fun main() {
    var n: Int
    var frontFactors: MutableList<Int>
    var backFactors: MutableList<Int>
    var sum: Int
    val sb = StringBuilder()
    while (true) {
        n = readInt()
        sum = 0
        if (n == -1) break
        frontFactors = mutableListOf() // 앞의 약수
        backFactors = mutableListOf() // 뒤에 있는 약수

        for (i in 1..sqrt(n.toDouble()).toInt()) { // 거듭제곱근까지만 반복
            if (n % i == 0) {
                frontFactors.add(i) // 앞의 약수 저장
                sum += i

                if (i > 1 && n / i != i) {
                    backFactors.add(n / i) // 뒤의 약수 저장
                    sum += n/i
                }
            }
        }
        if (n == sum) {
            // 완전수이면
            sb.append(n).append(" = ")

            // 앞의 약수들
            for (factor in frontFactors) {
                if (factor == 1) {
                    sb.append(1)
                } else{
                    sb.append(" + ").append(factor)
                }
            }

            // 뒤의 약수들
            for (i in backFactors.size -1 downTo 0) {
                sb.append(" + ").append(backFactors[i])
            }
            sb.append('\n')
        } else {
            // 완전수가 아니면
            sb.append(n).append(" is NOT perfect.\n")
        }
    }
    print(sb)
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