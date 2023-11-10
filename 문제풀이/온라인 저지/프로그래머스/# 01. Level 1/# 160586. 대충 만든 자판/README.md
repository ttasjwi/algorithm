# 문제
- 플랫폼 : 프로그래머스
- 번호 : 160586
- 제목 : 대충 만든 자판
- 난이도 : Level 1
- 문자열을 작성하기 위해 키를 최소 몇 번씩 눌러야 하는지 순서대로 배열에 담아 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/160586" target="_blank">링크</a>

---

# 필요 지식
- 해시

---

# 풀이
```kotlin
class Solution {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        val costs = HashMap<Char, Int>()
        for (str in keymap) {
            for (i in str.indices) {
                if (!costs.containsKey(str[i])) {
                    costs[str[i]] = i+1
                } else {
                    costs[str[i]] = minOf(costs[str[i]]!!, i+1)
                }
            }
        }
        val answer = IntArray(targets.size)
        for (i in targets.indices) {
            for (j in targets[i].indices) {
                if (costs.containsKey(targets[i][j])) {
                    answer[i] += costs[targets[i][j]]!!
                } else {
                    answer[i] = -1
                    break
                }
            }
        }
        return answer
    }
}
```
- 알파벳 문자 별로, 최소로 입력 가능한 비용을 해싱한다
- targets 배열의 요소를 읽고, 위의 비용을 합산해나간다. 등록되있지 않은 문자를 발견하면 -1로 바꾸고 탈출한다.
- 반환

---
