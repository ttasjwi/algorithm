# 문제
- 플랫폼 : 프로그래머스
- 번호 : 092335
- 제목 : k진수에서 소수 개수 구하기
- 난이도 : Level 2
- n을 k진수로 바꿨을 때, 변환된 수 안에서 찾을 수 있는 위 조건에 맞는 소수의 개수를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/92335" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리
- 수학

---

# 풀이
```kotlin
import kotlin.math.sqrt

class Solution {
    fun solution(n: Int, k: Int): Int {
        val s = n.toString(k)
        var answer = 0
        var v = 0L
        for (i in 0.. s.length) {
            if (i == s.length || s[i] == '0') {
                if (v > 0) {
                    if (isPrime(v)) answer ++
                    v = 0
                }
            } else {
                v = v * 10 + s[i].code - 48
            }
        }
        return answer
    }
}

private fun isPrime(num: Long):Boolean {
    if (num == 1L) {
        return false
    }
    for (i in 2L..sqrt(num.toDouble()).toLong()) {
        if (num%i == 0L) {
            return false
        }
    }
    return true
}
```