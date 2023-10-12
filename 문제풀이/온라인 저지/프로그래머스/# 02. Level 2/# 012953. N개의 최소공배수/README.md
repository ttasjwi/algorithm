# 문제
- 플랫폼 : 프로그래머스
- 번호 : 012953
- 제목 : N개의 최소공배수
- 난이도 : Level 2
- n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12953" target="_blank">링크</a>

---

# 필요 지식
- 수학
- GCD, LCM

---

# 풀이
```kotlin
class Solution {
    fun solution(arr: IntArray): Int {
        fun gcd(a:Int, b:Int) : Int {
            var max: Int
            var min: Int
            if (a >= b) {
                max = a
                min = b
            } else {
                max = b
                min = a
            }
            var r: Int
            while ((max % min).also { r =it } != 0) {
                max = min
                min = r
            }
            return min
        }
        fun lcm(a:Int, b:Int) = a * b / gcd(a,b)
        var lcm = arr[0]
        for (i in 1 until arr.size) {
            lcm = lcm(lcm, arr[i])
        }
        return lcm
    }
}
```
- N개의 최소공배수는 두개의 숫자의 최소공배수를 구하고, 그 다음 다른 수와 최소공배수 연산을 연쇄적으로 해서 구해도 된다.

---
