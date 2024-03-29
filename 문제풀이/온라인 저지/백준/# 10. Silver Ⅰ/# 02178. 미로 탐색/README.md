# 문제
- 플랫폼 : 백준
- 번호 : 02178
- 제목 : 미로 탐색
- 난이도 : Silver 1
- 미로의 (1,1)에서 (N,M)까지 지나야 하는 최소의 칸 수를 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/2178" target="_blank">링크</a>

---

# 필요 지식
- BFS(너비 우선 탐색)

---

## 풀이
```kotlin
fun main() {
    val dr = intArrayOf(0, 1, 0, -1)
    val dc = intArrayOf(1, 0, -1, 0)

    val mr = i()
    val mc = i()
    val c = mr * mc + 1
    val q = arrayOfNulls<IntArray>(c)
    val flag = Array(mr) { BooleanArray(mc) }
    for (i in 0 until mr) {
        for (j in 0 until mc) {
            flag[i][j] = r() >= 49
        }
        r()
    }
    var f = 0
    var r = 1
    var s = 1
    flag[0][0] = false
    q[1] = intArrayOf(0, 0)

    var size: Int
    var cur: IntArray
    var nr: Int
    var nc: Int
    var depth = 0
    loop@ while (s > 0) {
        size = s
        depth += 1
        while (size-- > 0) {
            cur = q[((f + 1 + c) % c).also { f = it }]!!
            q[f] = null
            s--
            for (i in 0..3) {
                nr = cur[0] + dr[i]
                nc = cur[1] + dc[i]
                if (nr == mr - 1 && nc == mc - 1) {
                    depth += 1
                    break@loop
                }
                if ((nr in 0 until mr) && (nc in 0 until mc) && flag[nr][nc]) {
                    q[((r+1+c)%c).also { r = it }] = intArrayOf(nr, nc)
                    s++
                    flag[nr][nc] = false
                }
            }
        }
    }
    print(depth)
}
```
- 목적지까지의 거리를 구할 때 가능한 빨리 찾아내는 것이 중요하므로 BFS를 통해 탐색한다.
- 다음을 큐가 빌 때까지 반복한다.
  - 큐의 요소 수를 세고, depth을 증가시킨다. 요소의 수 만큼 다음을 반복한다.
  - 큐에서 요소를 꺼낸다.
  - 사방을 탐색하여, 갈 수 있는 곳들 중 안 간 곳을 찾는다.
    - 목적지이면 여기서 탈출한다.(level +1)
  - 위치를 큐에 삽입하고, 해당 위치를 갈 수 없는 곳으로 마킹한다.

---
