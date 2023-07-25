fun main() {
    val n = readInt()
    val m = readInt()

    val numbers = IntArray(n)
    for (i in 0 until n) {
        numbers[i] = readInt()
    }

    print(solution(numbers, n, m))
}

private fun solution(numbers: IntArray, n: Int, m: Int): Int {
    var max = 0
    var sum: Int
    for (i in 0 until n - 2) {
        if (numbers[i] > m) continue // 제한보다 크면 다음으로 skip
        for (j in i + 1 until n - 1) {
            if (numbers[i] + numbers[j] > m) continue // 제한보다 크면 다음으로 skip
            for (k in j + 1 until n) {
                sum = numbers[i] + numbers[j] + numbers[k]
                if (sum == m) return sum // 제한과 같으면 바로 반환
                if (sum in (max + 1) until m) max = sum // 제한보다 작으면서 기존 최댓값보다 크면 최댓값 갱신
            }
        }
    }
    return max // 최댓값 반환
}

private fun readInt(): Int {
    var value = 0
    var input: Int
    while (true) {
        input = System.`in`.read() // 한글자 읽기
        when (input) {
            10, 32 -> return value // 공백이나 개행자면 입력을 멈추고 반환
            else -> value = value * 10 + (input - 48) // 기존값에 10을 곱하고 입력값을 숫자로 변환해서 합산
        }
    }
}
