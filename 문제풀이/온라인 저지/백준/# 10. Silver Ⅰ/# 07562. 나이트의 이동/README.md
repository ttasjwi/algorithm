# 문제
- 플랫폼 : 백준
- 번호 : 07562
- 제목 : 나이트의 이동
- 난이도 : Silver 1
- 테스트 케이스마다 나이트가 최소 몇 번만에 이동할 수 있는지 출력
- 문제 : <a href="https://www.acmicpc.net/problem/7562" target="_blank">링크</a>

---

# 필요 지식
- BFS

---

# 풀이
```kotlin
val dr = intArrayOf(-1, 1, 2, 2, 1, -1, -2, -2)
val dc = intArrayOf(2, 2, 1, -1, -2, -2, 1, -1)
val sb = StringBuilder()

fun main() {
    var t = i()
    while (t-- > 0) {
        bfs(i(), i(), i(), i(), i())
    }
    print(sb)
}

class Point(val r: Int, val c: Int)

class Queue(cap: Int) {
    val c = cap + 1
    val q = arrayOfNulls<Point>(c)
    var f = 0
    var r = 0
    var s = 0

    fun eq(e: Point) {
        s++
        q[((r + 1 + c) % c).also { r = it }] = e
    }

    fun dq(): Point {
        s--
        return q[((f + 1 + c) % c).also { f = it }]!!
    }
    fun isEmpty() = s == 0
}

fun bfs(l: Int, sr: Int, sc: Int, tr: Int, tc: Int) {
    if (sr == tr && sc == tc) {
        sb.append('0').append('\n')
        return
    }
    val board = Array(l) {BooleanArray(l)}
    val q = Queue(l * l)
    var cur: Point
    var size: Int
    var nr: Int
    var nc: Int
    q.eq(Point(sr, sc))
    board[sr][sc] = true
    var cnt = -1
    while (!q.isEmpty()) {
        cnt++
        size = q.s
        while (size-- > 0) {
            cur = q.dq()
            for (i in 0..7) {
                nr = cur.r + dr[i]
                nc = cur.c + dc[i]
                if (tr == nr && tc == nc) {
                    sb.append(cnt+1).append('\n')
                    return
                }
                if ((nr in 0 until l) && (nc in 0 until l) && !board[nr][nc]) {
                    board[nr][nc] = true
                    q.eq(Point(nr, nc))
                }
            }
        }
    }
}
```
- BFS 로 순회하면서, 이동횟수를 계산한다

---
