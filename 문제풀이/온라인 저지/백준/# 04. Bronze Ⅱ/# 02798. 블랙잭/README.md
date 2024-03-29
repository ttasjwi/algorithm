# 문제
- 플랫폼 : 백준
- 번호 : 02798
- 제목 : 블랙잭
- 난이도 : Bronze 2
- N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2798" target="_blank">링크</a>

---

# 필요 지식
- 브루트 포스

---

# 풀이

## Kotlin
```kotlin
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
```
- 매번 더하면서 m이상인지 확인하고 반복을 스킵할 수 있으면 스킵하도록 함
- 합이 sum 이면 바로 반환하고 매번 최대합을 갱신함

## 입출력
```kotlin
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
```
- 빈번하게 숫자를 입력받아야하는데, readInt 메서드를 따로 빼서 작업했다.
