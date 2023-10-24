# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042839
- 제목 : 소수 찾기
- 난이도 : Level 2
- 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42839" target="_blank">링크</a>

---

# 필요 지식
- 수학
- 에라토스테네스의 체
- DFS

---

# 풀이
```kotlin
import kotlin.math.sqrt

class Solution {
    fun solution(numbers: String): Int {
        val max = (1).let{
            var result = it
            repeat(numbers.length) { result *= 10 }
            result 
        }
        val isPrime = BooleanArray(max) {true}
        isPrime[0] = false
        isPrime[1] = false
        for (i in 2..sqrt(max.toDouble()).toInt()) {
            if (isPrime[i]) {
                for (j in 2*i until max step i) {
                    isPrime[j] = false
                }
            }
        }
        val set = HashSet<Int>()
        val check = BooleanArray(numbers.length)
        fun dfs(v: Int, cnt: Int) {
            var next: Int
            for (i in numbers.indices) {
                if (!check[i]) {
                    check[i] = true
                    next = v * 10 + numbers[i].code - 48
                    if (isPrime[next]) set += next
                    if (cnt + 1 < numbers.length) dfs(next, cnt + 1)
                    check[i] = false
                }
            }
        }
        dfs(0, 0)
        return set.size
    }
    
    
}
```
- 문자열이 들어오면 문자열의 길이를 확인한다. 예를 들어 6자리 문자열이면, 1~999999 까지 소수를 판정하면 된다. (여기서 약간 시간을 더들여서 가장 큰 숫자(0,1,2,...9)를 찾으면 좀 더 범위를 줄일 수 있을 것 같긴한데 이정도로도 문제를 풀 수 있을 것 같아서 거기까지 하진 않았다.)
- 소수 판별을 매번 하기 보다, 미리 소수임을 체크해두고 계산하는 것이 더 편리하다. 특정 범위의 소수들을 찾아내는데 최적화된 에라토스테네스의 체를 사용했다.
- 배열을 순서대로 탐색하면서 DFS를 수행한다. (v: 현재값, cnt: 사용한 숫자 개수)
  - 방문 배열을 순서대로 순회하면서 체크되지 않았다면 체크하고, 현재 숫자를 뒤에 붙인 값을 구한다.(next)
  - next가 소수인지 판별한 뒤 set에 추가한다.
  - next까지 추가했을 때 numbers의 모든 숫자를 다 사용하지 않았다면 dfs 함수를 재귀호출한다
  - 체크배열에서 현 인덱스를 체크 해제한다.
- 이렇게 만들어진 set의 size를 구한다.

---
