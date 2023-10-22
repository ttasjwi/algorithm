# 문제
- 플랫폼 : 프로그래머스
- 번호 : 154538
- 제목 : 숫자 변환하기
- 난이도 : Level 2
- 자연수 x, y, n이 매개변수로 주어질 때, x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/154538" target="_blank">링크</a>

---

# 필요 지식
- BFS

---

# 풀이
```kotlin
import java.util.*

class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        if (x == y) return 0
        val q: Queue<Int> = LinkedList()
        val check = BooleanArray(y+1)
        q.offer(x)
        check[x] = true
        var depth = -1
        var size: Int
        var cur: Int
        var next: Int
        while (q.isNotEmpty()) {
            depth ++
            size = q.size
            while (size-- > 0) {
                cur = q.poll()
                for (i in 0 until 3) {
                    if (i == 0) next = cur + n
                    else if (i == 1) next = cur shl 1
                    else next = cur * 3
                    if (next == y) return depth + 1
                    else if (next < y && !check[next]) {
                        check[next] = true
                        q.offer(next)
                    }
                }
            }
        }
        return -1
    }
}
```
- x, y가 전달됐을 때 두 값이 같으면 바로 0 반환
- BFS를 수행하여, x에서 y로 만들 때까지의 최단 연산 횟수를 구하면 된다.
- 큐가 빌 때까지 최단 연산 횟수를 구하지 못 했다면 -1을 반환한다.
