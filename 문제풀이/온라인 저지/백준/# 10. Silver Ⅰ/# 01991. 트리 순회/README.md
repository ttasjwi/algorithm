# 문제
- 플랫폼 : 백준
- 번호 : 01991
- 제목 : 트리 순회
- 난이도 : Silver 1
- 이진 트리가 주어질 때 첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1991" target="_blank">링크</a>

---

# 필요 알고리즘
- DFS
- 트리

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val child = Array(n+1){IntArray(2)}
    var p: Int
    var lt: Int
    var rt: Int
    for (i in 0 until n) {
        p = r() - 64
        r()
        lt = r() - 64
        r()
        rt = r() - 64
        r()
        if (lt >= 1) child[p][0] = lt
        if (rt >= 1) child[p][1] = rt
    }
    val sb = StringBuilder()
    fun first(node: Int) {
        sb.append((node+64).toChar())
        if (child[node][0] >= 1) first(child[node][0])
        if (child[node][1] >= 1) first(child[node][1])
    }
    fun mid(node: Int) {
        if (child[node][0] >= 1) mid(child[node][0])
        sb.append((node+64).toChar())
        if (child[node][1] >= 1) mid(child[node][1])
    }
    fun last(node: Int) {
        if (child[node][0] >= 1) last(child[node][0])
        if (child[node][1] >= 1) last(child[node][1])
        sb.append((node+64).toChar())
    }
    first(1)
    sb.append('\n')
    mid(1)
    sb.append('\n')
    last(1)
    print(sb)
}
```
- 전위 순회 : 루트 - 왼쪽 - 오른쪽
- 중위 순회 : 왼쪽 - 루트 - 오른쪽
- 후위 순회 : 왼쪽 - 오른쪽 - 루트

---
