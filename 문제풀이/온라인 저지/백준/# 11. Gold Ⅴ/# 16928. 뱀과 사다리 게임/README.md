# 문제
- 플랫폼 : 백준
- 번호 : 16928
- 제목 : 뱀과 사다리 게임
- 난이도 : Gold 5
- 100번 칸에 도착하기 위해 주사위를 최소 몇 번 굴려야 하는지 출력
- 문제 : <a href="https://www.acmicpc.net/problem/16928" target="_blank">링크</a>

---

# 필요 지식
- BFS

---

# 풀이
```kotlin
fun main() {
    val c = 101
    val visit = BooleanArray(c)
    val warp = IntArray(c) { it }

    var n = i()
    var m = i()

    while (n-- > 0) warp[i()] = i()
    while (m-- > 0) warp[i()] = i()

    val q = IntArray(c)
    var f = 0
    var r = 1
    var s = 1
    q[1] = 1
    visit[1] = true
    var size: Int
    var cnt = -1
    var cur: Int
    var next: Int
    loop@while (s > 0) {
        cnt++
        size = s
        while (size-- > 0) {
            cur = q[((f + 1 + c)%c).also { f = it }]
            s --
            for (i in 1..6) {
                next = cur + i
                if (next == 100) {
                    cnt ++
                    break@loop
                }
                if (next >= c || visit[next]) continue
                visit[next] = true
                if (warp[next] != next) {
                    next = warp[next]
                    if (visit[next]) continue
                    visit[next] = true
                }
                q[((r+1+c)%c).also { r = it }] = next
                s ++
            }
        }
    }
    print(cnt)
}
```
- warp 배열 : 어느 지점으로 워프할 지 저장하는 배열
  - 인덱스와 같은 값이면 점프하지 않음
  - 인덱스와 다르면 사다리이거나 뱀이다. 즉 다른 지점으로 순간이동? 하는 칸
- 배열로 큐를 구현하여 BFS를 구현했다.
- 1~6까지 주사위를 던졌을 때 범위가 100 이하이고 방문하지 않았다면 방문한다.
  - 해당 위치가 warp 가능한 위치이면 warp한뒤 해당 위치를 방문처리한다.
  - 이때 warp 위치가 방문되어있다면 그냥 다음 반복으로 넘어간다.
- 다음 위치를 큐에 삽입하고 반복한다.
- 이렇게 순회하면서 최소 이동횟수를 구하고 출력한다.

---
