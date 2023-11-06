# 문제
- 플랫폼 : 프로그래머스
- 번호 : 072412
- 제목 : 순위 검색
- 난이도 : Level 2
- 각 문의조건에 해당하는 사람들의 숫자를 순서대로 배열에 담아 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/72412" target="_blank">링크</a>

---

# 필요 지식
- DFS
- 해시
- 정렬
- 이분탐색

---

# 풀이
```kotlin
class Solution {

    private val map = HashMap<String, MutableList<Int>>()
    private val items = Array(4) { "" }

    fun solution(info: Array<String>, query: Array<String>): IntArray {
        for (i in info.indices) dfs(info[i].split(' '), 0)
        for (list in map.values) list.sort()

        var q: List<String>
        var key: String
        var score: Int
        val answer = IntArray(query.size)
        for (i in query.indices) {
            q = query[i].split(' ')
            key = makeKey(q)
            score = q[7].toInt()
            answer[i] = if (!map.containsKey(key)) 0 else countGoe(map[key]!!, score)
        }
        return answer
    }

    private fun dfs(source: List<String>, idx: Int) {
        if (idx == 4) {
            val key = makeKeyFromItems()
            if (!map.containsKey(key)) map[key] = ArrayList()
            map[key]!! += source[4].toInt()
            return
        }
        items[idx] = "-"
        dfs(source, idx + 1)
        items[idx] = source[idx]
        dfs(source, idx + 1)
    }

    private fun makeKeyFromItems() = StringBuilder().append(items[0]).append(items[1]).append(items[2]).append(items[3]).toString()
    private fun makeKey(q: List<String>) = StringBuilder().append(q[0]).append(q[2]).append(q[4]).append(q[6]).toString()

    private fun countGoe(list: List<Int>, min: Int): Int {
        var lt = 0
        var rt = list.lastIndex
        var mid: Int
        var minIdx = -1
        while (lt <= rt) {
            mid = (lt + rt) shr 1
            if (list[mid] >= min) {
                minIdx = mid
                rt = mid - 1
            } else {
                lt = mid + 1
            }
        }
        return if (minIdx >= 0) list.size - minIdx else 0
    }
}
```
- info 배열의 요소 문자열에서 점수를 제외한 나머지 정보를 토대로, 해당 요소로 검색될 수 있는 모든 문자열을 만든다. 이걸 key로 한다.
- map의 key에 대해, value로는 리스트를 두고 리스트에 점수를 추가한다.
- 각 list를 모두 정렬한다.
- 매번 query가 들어올 때 key와 점수를 추출하고, key를 통해 리스트에 접근한다.
- score보다 크거나 같은 점수의 갯수를 구해야하는데 이 과정에는 이분탐색을 사용한다.

---
