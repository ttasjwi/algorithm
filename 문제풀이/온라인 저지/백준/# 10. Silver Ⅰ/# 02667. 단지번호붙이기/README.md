# 문제
- 플랫폼 : 백준
- 번호 : 02667
- 제목 : 단지번호붙이기
- 난이도 : Silver 1
- 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2667" target="_blank">링크</a>

---

# 필요 알고리즘
- DFS

---

# 풀이
```kotlin
import java.util.*

fun main() {
    val dr = intArrayOf(0, 1, 0, -1)
    val dc = intArrayOf(1, 0, -1, 0)

    val n = i()
    val house = Array(n){BooleanArray(n)}
    for (i in 0 until n) {
        for (j in 0 until n ) {
            house[i][j] = r() >= 49
        }
        r()
    }

    val st = arrayOfNulls<IntArray>(n*n)
    var p = -1

    var cur: IntArray
    var nr: Int
    var nc: Int
    var cnt: Int
    val counts = ArrayList<Int>()
    for (i in 0..n-1) {
        for (j in 0..n-1) {
            if (!house[i][j]) continue
            cnt = 1
            st[++p] = intArrayOf(i,j)
            house[i][j] = false
            while (p >= 0) {
                cur = st[p]!!.also { st[p--] = null }
                for (k in 0..3) {
                    nr = cur[0] + dr[k]
                    nc = cur[1] + dc[k]
                    if ((0<=nr && nr <n) && (0 <= nc && nc < n) && house[nr][nc]) {
                        house[nr][nc] = false
                        st[++p] = intArrayOf(nr, nc)
                        cnt ++
                    }
                }
            }
            counts.add(cnt)
        }
    }
    Collections.sort(counts)
    val sb = StringBuilder()
    sb.append(counts.size).append('\n')
    for (x in counts) {
        sb.append(x).append('\n')
    }
    print(sb)
}
```
- DFS를 통해 연결된 단지수를 세고, 연결된 집의 수를 카운팅한다.
- 여기서는 스택을 이용해 DFS를 구현했다.
- BFS를 이용해 이 문제를 풀어도 된다.

---
