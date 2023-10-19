# 문제
- 플랫폼 : 프로그래머스
- 번호 : 064065
- 제목 : 튜플
- 난이도 : Level 2
- 특정 튜플을 표현하는 집합이 담긴 문자열 s가 매개변수로 주어질 때, s가 표현하는 튜플을 배열에 담아 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/64065" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리
- 구현

---

# 풀이
```kotlin
class Solution {

    fun solution(s: String): IntArray {
        val items = ArrayList<ArrayList<Int>>()

        var idx = -1
        var v = 0
        for (i in 1..s.length - 2) {
            if (s[i] in '0'..'9') {
                v = v * 10 + s[i].toInt() - 48
            } else {
                if (s[i] == '{') {
                    idx++
                    items.add(ArrayList())
                } else if ((s[i] == ',' || s[i] == '}') && v != 0) {
                    items[idx].add(v)
                    v = 0
                }
            }
        }
        items.sortBy { it.size }

        val set = LinkedHashSet<Int>()
        for (arr in items) {
            for (e in arr) {
                set += e
            }
        }
        return set.toIntArray()
    }

}
```
- 원소가 i개인 배열에서는 반드시 튜플의 i번째 요소에 해당하는 요소가 출연한다.
- 따라서 문자열을 파싱하여 집합단위로 끊되, 리스트의 크기 순으로 정렬해야한다.

---
