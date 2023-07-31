# 문제
- 플랫폼 : 백준
- 번호 : 09506
- 제목 : 약수들의 합
- 난이도 : Bronze 1
- n이 완전수인지 아닌지 판단해주는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/9506" target="_blank">링크</a>

---

# 필요 지식
- 배열
- 수학

---

# 풀이
## Kotlin
```kotlin
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
```
- 1부터 n의 거듭제곱까지 반복한다.
  - 약수이면 sum에 합산하고, frontFactors에 저장한다.
  - 짝에 해당하는 약수도 sum에 합산하고 backFactors에 저장한다.
- 출력
  - 앞의 약수들을 순서대로 문자열에 결합
  - 뒤의 약수는 역순으로 문자열에 결합

---
