# 문제
- 플랫폼 : 프로그래머스
- 번호 : 131701
- 제목 : 연속 부분 수열 합의 개수
- 난이도 : Level 2
- 원형 수열의 연속 부분 수열 합으로 만들 수 있는 수의 개수를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/131701" target="_blank">링크</a>

---

# 필요 지식
- 브루트포스

---

# 풀이
```kotlin
class Solution {
    fun solution(elements: IntArray): Int {
        var rt: Int
        var sum: Int
        val set = HashSet<Int>()
        val size = elements.size
        for (lt in 0 until size) {
            sum = 0
            rt = lt
            do {
                sum += elements[rt]
                set += sum
                rt = (rt + 1 + size)%size
            } while (rt != lt)
        }
        return set.size
    }
}
```
- 시작점, 끝점을 0번 인덱스, 1번 인덱스, ... 마지막 인덱스에 두고
- 끝점를 하나씩 다음으로 이동시켜가다가 처음 지점으로 돌아올 때까지 합을 계속 set에 추가

---
