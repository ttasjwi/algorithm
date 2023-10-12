# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042842
- 제목 : 카펫
- 난이도 : Level 2
- 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42842" target="_blank">링크</a>

---

# 필요 지식
- 브루트 포스
- 수학

---

# 풀이
```kotlin
import kotlin.math.sqrt

class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        val s = brown + yellow

        var a: Int
        var answer: IntArray? = null
        for (b in 3..sqrt(s.toDouble()).toInt()) {
            if (s%b ==0) {
                a = s/b
                if ((a-2) * (b-2) == yellow) {
                    answer = intArrayOf(a,b)
                    break
                }
            }
        }
        return answer!!
    }
}
```
- 전체 면적(s) = yellow + white
- s의 긴 길이를 b, 짧은 길이를 a라 하자.(a, b는 정수 -> 따라서 s의 약수를 구해가면서 계산해야함)
- 이때 (a-2) * (b-2) = yellow 가 성립한다.
- 3부터 s의 거듭제곱(이하)까지 순회하면서 b가 s의 약수이면 쌍에 해당하는 a를 구한다.
- 위의 식이 성립하는지 확인하고, 성립하면 그대로 바로 반환하면 된다.

---
