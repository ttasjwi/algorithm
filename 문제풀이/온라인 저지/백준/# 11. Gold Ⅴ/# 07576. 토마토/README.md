# 문제
- 플랫폼 : 백준
- 번호 : 07576
- 제목 : 토마토
- 난이도 : Gold 5
- 토마토가 모두 익을 때까지 최소 며칠이 걸리는지를 계산해서 출력
- 문제 : <a href="https://www.acmicpc.net/problem/7576" target="_blank">링크</a>

---

# 필요 지식
- BFS

---

# 풀이
```kotlin
fun main() {
    val dr = intArrayOf(0, 1, 0, -1)
    val dc = intArrayOf(1, 0, -1, 0)
    val mc = i()
    val mr = i()
    val board = Array(mr) { BooleanArray(mc) }
    val c = mc * mr + 1
    val q = arrayOfNulls<IntArray>(c)
    var notRipe = 0
    var f = 0
    var r = 0
    var s = 0
    for (i in 0 until mr) {
        for (j in 0 until mc) {
            i().also {
                when (it) {
                    0 -> {
                        notRipe++
                    }

                    1 -> {
                        board[i][j] = true
                        q[((r + 1 + c) % c).also { r = it }] = intArrayOf(i, j)
                        s++
                    }

                    else -> {
                        board[i][j] = true
                    }
                }
            }
        }
    }
    if (notRipe == 0 && s > 0) {
        print(0)
        return
    }
    var cur: IntArray
    var size: Int
    var day = -1
    var nr: Int
    var nc: Int
    while (s > 0) {
        day ++
        size = s
        while (size-- > 0) {
            cur = q[((f + 1 + c) % c).also { f = it }]!!
            s--
            for (i in 0..3) {
                nr = cur[0] + dr[i]
                nc = cur[1] + dc[i]
                if ((nr in 0 until mr) && (nc in 0 until mc) && !board[nr][nc]) {
                    board[nr][nc] = true
                    notRipe --
                    q[((r + 1 + c) % c).also { r = it }] = intArrayOf(nr, nc)
                    s++
                }
            }
        }
    }
    print(if (notRipe > 0) -1 else day)
}
```
- 입력을 받으면서
  - 익은 토마토는 큐에 삽입하고 그 자리를 체크
  - 안 익은 토마토는 갯수를 세기
  - 비어있는 칸은 체크 처리
- 익은 토마토가 하나라도 존재하고, 안 익은 토마토가 없으면 0을 출력하고 종료
- 큐가 빌 때까지 반복
  - day 증가
  - 큐에서 요소를 꺼내서 인접한 곳을 다시 큐에 전부 삽입하고 그 자리를 체크, 안 익은 토마토 갯수 차감
- 최종적으로 안 익은 토마토가 남아 있으면 -1 출력, 없으면 day 출력
