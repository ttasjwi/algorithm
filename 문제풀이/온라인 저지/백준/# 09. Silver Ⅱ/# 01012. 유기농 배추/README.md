# 문제
- 플랫폼 : 백준
- 번호 : 01012
- 제목 : 유기농 배추
- 난이도 : Silver 2
- 각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1012" target="_blank">링크</a>

---

# 필요 알고리즘
- DFS
- BFS

---

# 풀이
```kotlin
fun main() {
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    var t = i()

    var mx: Int
    var my: Int
    var k: Int
    var st: Array<IntArray?>
    var cabbage: Array<BooleanArray>
    var p = -1

    val sb = StringBuilder()
    var cnt:Int
    var cur: IntArray
    var nx:Int
    var ny:Int
    while (t-- > 0) {
        mx = i()
        my = i()
        k = i()
        st = arrayOfNulls(mx * my)
        cabbage = Array(mx) { BooleanArray(my) }

        while (k-- > 0) cabbage[i()][i()] = true
        cnt = 0
        for (i in 0 until mx) {
            for (j in 0 until my) {
                if (!cabbage[i][j]) continue
                cnt += 1
                cabbage[i][j] = false
                st[++p] = intArrayOf(i,j)
                while (p >=0) {
                    cur = st[p]!!.also { st[p--] = null }
                    for (a in 0..3) {
                        nx = cur[0] + dx[a]
                        ny = cur[1] + dy[a]
                        if ((nx in 0 until mx) && (ny in 0 until my) && cabbage[nx][ny]) {
                            cabbage[nx][ny] = false
                            st[++p] = intArrayOf(nx, ny)
                        }
                    }
                }
            }
        }
        sb.append(cnt).append('\n')
    }
    print(sb)
}
```
- DFS/BFS를 이용하여 배추가 연속된 영역의 갯수를 세고 출력한다.

---
