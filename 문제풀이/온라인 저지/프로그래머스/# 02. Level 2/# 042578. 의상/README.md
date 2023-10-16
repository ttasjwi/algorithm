# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042578
- 제목 : 의상
- 난이도 : Level 2
- 서로 다른 옷의 조합의 수를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42578" target="_blank">링크</a>

---

# 필요 지식
- 해시

---

# 풀이
```kotlin
class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val map = HashMap<String, Int>()
        for (arr in clothes) {
            if (!map.containsKey(arr[1])) {
                map[arr[1]] = 1
            } else {
                map[arr[1]] = map[arr[1]]!! + 1
            }
        }
        var answer = 1
        for (v in map.values) {
            answer *= (v+1)
        }
        return answer - 1
    }
}
```
- 키에 포함되어 있지 않으면 카운트를 1로 초기화
- 키에 포함되어 있으면 카운트 증가
- 맵의 value를 순회하면서, 곱함(독립이므로 곱의 법칙, 선택 안 하는 경우도 있으므로 +1 해서 곱함)
- 아무것도 안 입은 경우는 제해야하므로 1 차감
- 반환

---
