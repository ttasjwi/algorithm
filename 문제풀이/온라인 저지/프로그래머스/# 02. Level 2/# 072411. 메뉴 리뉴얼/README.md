# 문제
- 플랫폼 : 프로그래머스
- 번호 : 072411
- 제목 : 메뉴 리뉴얼
- 난이도 : Level 2
- 코스요리의 메뉴 구성을 문자열 형태로 배열에 담아 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/72411" target="_blank">링크</a>

---

# 필요 지식
- DFS
- 정렬

---

# 풀이
```kotlin
import java.util.*

class Menu(val id: String, var orderCnt: Int) : Comparable<Menu> {

    val size = id.length
    fun addCnt() { orderCnt++ }

    override fun compareTo(other: Menu): Int {
        return if (this.orderCnt == other.orderCnt) {
            this.id.compareTo(other.id)
        } else {
            other.orderCnt - this.orderCnt
        }
    }
}


class Solution {
    private val sb = StringBuilder()
    private val menus = HashMap<String, Menu>()
    private val candidates = HashMap<Int, ArrayList<Menu>>()
    private var maxCourse = 0
    private val charArray = CharArray(10)

    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        for (c in course) {
            candidates[c] = ArrayList()
        }
        maxCourse = course[course.lastIndex]

        for (order in orders) {
            dfs(0, 0, sortedString(order), BooleanArray(order.length))
        }
        for (menu in menus.values) {
            if (menu.orderCnt >= 2) {
                if (candidates[menu.size]!!.isNotEmpty()) {
                    if (candidates[menu.size]!![0].orderCnt < menu.orderCnt) {
                        candidates[menu.size]!!.clear()
                        candidates[menu.size]!! += menu
                    } else if (candidates[menu.size]!![0].orderCnt == menu.orderCnt) {
                        candidates[menu.size]!! += menu
                    }
                } else {
                    candidates[menu.size]!! += menu
                }
            }
        }
        val result = TreeSet<String>()
        for (list in candidates.values) {
            for (f in list) {
                result += f.id
            }
        }
        return result.toTypedArray()
    }

    private fun sortedString(original: String): String {
        val charArray = original.toCharArray()
        Arrays.sort(charArray)
        return String(charArray)
    }

    private fun makeString(size: Int): String {
        for (i in 0 until size) {
            sb.append(charArray[i])
        }
        val result = sb.toString()
        sb.setLength(0)
        return result
    }

    private fun dfs(depth: Int, startIndex: Int, order: String, check: BooleanArray) {
        if (candidates.containsKey(depth)) {
            val str = makeString(depth)
            val menu: Menu
            if (!menus.containsKey(str)) {
                menu = Menu(str, 1)
                menus[str] = menu
            } else {
                menu = menus[str]!!
                menu.addCnt()
            }
        }
        if (depth > maxCourse) return
        for (i in startIndex..order.lastIndex) {
            if (!check[i]) {
                check[i] = true
                charArray[depth] = order[i]
                dfs(depth + 1, i + 1, order, check)
                check[i] = false
            }
        }
    }
}
```
- menus : 가능한 메뉴들 목록
- candidates : 메뉴를 구성한 개수들별로 실제 후보가 될 수 있는 메뉴들
- 풀이
  - course를 순서대로 탐색하면서 키를 메뉴 구성 갯수, 값을 메뉴들의 리스트로 하는 해시테이블(candidates)을 생성한다.(메뉴를 구성한 요리 갯수별로 그룹핑)
    - 값으로 TreeSet을 사용한 이유는 메뉴의 등장 횟수별로 정렬하면서,  위함이다.
  - course의 마지막 값은 제일 길이가 긴 요리인데 이 값을 기억해둔다.
  - orders 배열을 순회하면서 dfs를 수행한다. (각 order에서 구해낼 수 있는 모든 메뉴 조합(가나다 순으로 정렬함)을 구성한다.)
    - 만들어진 조합이 candidates의 key로 존재하면 menus에 추가하고, menus에 이미 존재하면 주문 횟수를 증가시킨다.
  - menus를 순회하면서 주문 횟수가 2 이상이면, 기존 최대 주문량보다 크면 candidates 를 초기화하고 추가한다. (같으면 뒤에 붙인다)
  - 살아남은 모든 candidates들을 모아서 배열로 반환한다.
---
