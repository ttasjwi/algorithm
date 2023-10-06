# 문제
- 플랫폼 : 백준
- 번호 : 10974
- 제목 : 모든 순열
- 난이도 : Silver 3
- 첫째 줄부터 N!개의 줄에 걸쳐서 모든 순열을 사전순으로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10974" target="_blank">링크</a>

---

# 필요 지식
- 백트래킹

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val check = BooleanArray(n+1)
    val items = IntArray(n)

    fun dfs(depth: Int) {
        if (depth == n) {
            for (item in items) {
                writeInt(item)
                writeSpace()
            }
            writeN()
            return
        }
        for (i in 1..n) {
            if (!check[i]) {
                check[i] = true
                items[depth] = i
                dfs(depth + 1)
                check[i] = false
            }
        }
        return
    }

    dfs(0)
    flushBuffer()
}
```
- 1,2,3,... 으로 시작해서 가지치기를 해야한다.
- 각 시작점을 방문처리하고 배열의 현재 깊이에 자신을 기록한다. 다음 깊이로 이동하여 동일한 가지 치기를 반복한다.
- 깊이가 배열의 크기가 되면 요소를 하나씩 전부 출력하고 반환한다.

---
