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