# 문제
- 플랫폼 : 프로그래머스
- 번호 : 135807
- 제목 : 숫자 카드 나누기
- 난이도 : Level 2
- 어느 한쪽이 자신의 모든 숫자를 나눌 수 있고 상대방이 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 최대의 양의 정수 구하기
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/135807" target="_blank">링크</a>

---

# 필요 지식
- 최대공약수
- 수학

---

# 풀이
```kotlin
class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        val gcdA = gcdOf(arrayA)
        val gcdB = gcdOf(arrayB)

        var resultA = 0
        var resultB = 0
        if (gcdA != 1 && cannotDivide(arrayB, gcdA)) resultA = gcdA
        if (gcdB != 1 && cannotDivide(arrayA, gcdB)) resultB = gcdB
        return maxOf(resultA, resultB)
    }

    private fun gcdOf(arr: IntArray): Int {
        var gcd = arr[0]
        for (i in 1 until arr.size) {
            gcd = gcd(gcd, arr[i])
        }
        return gcd
    }

    private fun cannotDivide(arr: IntArray, div: Int): Boolean {
        for (e in arr) {
            if (e% div == 0) return false
        }
        return true
    }

    private fun gcd(a: Int, b: Int): Int {
        val max: Int
        val min: Int
        if (a >= b) {
            max = a
            min = b
        } else {
            max = b
            min = a
        }
        val r = max % min
        return if (r == 0) min else gcd(min, r)
    }

}
```
- 배열A, 배열B 각각 최대공약수를 구한다.
- 배열A의 최대공약수로 배열 B의 모든 원소를 나눠보고, 모두 나눌 수 없으면 그 값을 resultA로 삼는다.(없으면 0)
- 배열B의 최대공약수로 배열 A의 모든 원소를 나눠보고, 모두 나눌 수 없으면 그 값을 resultB로 삼는다.(없으면 0)
- 둘 중 큰 값을 답으로 삼는다.

---
