# 문제
- 플랫폼 : 프로그래머스
- 번호 : 181879
- 제목 : 길이에 따른 연산
- 난이도 : Level 0
- 리스트의 길이가 11 이상이면 리스트에 있는 모든 원소의 합을 10 이하이면 모든 원소의 곱을 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181879" target="_blank">링크</a>

---

# 필요 지식
- 없음

---

# 풀이
```kotlin
class Solution {
    fun solution(num_list: IntArray): Int {
        var answer: Int
        if (num_list.size <= 10) {
            answer = 1
            for (num in num_list) {
                answer *= num
            }
        } else {
            answer = 0
            for (num in num_list) {
                answer += num
            }
        }
        return answer
    }
}
```
- 분기처리함
- for문을 두번 작성하긴 했지만 처음 한 번 분기처리하는게 매번 조건 확인을 안하므로 좀 더 부하가 적을 것 같았다.

---
