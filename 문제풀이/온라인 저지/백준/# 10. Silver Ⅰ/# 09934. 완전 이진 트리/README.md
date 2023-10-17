# 문제
- 플랫폼 : 백준
- 번호 : 09934
- 제목 : 완전 이진 트리
- 난이도 : Silver 1
- 상근이가 종이에 적은 순서가 모두 주어졌을 때, 각 레벨에 있는 빌딩의 번호를 구하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/9934" target="_blank">링크</a>

---

# 필요 지식
- 트리

---

# 풀이
```kotlin
fun main() {
    var k = i()
    val cap = 1 shl k
    val tree = IntArray(cap)

    fun search(x: Int) {
        val lt = x shl 1
        if (lt < cap && tree[lt] == 0) search(lt)
        tree[x] = i()
        val rt = lt + 1
        if (rt < cap && tree[rt] == 0) search(rt)
    }
    search(1)
    var start: Int
    var end = 0
    while (k-- > 0) {
        start = end + 1
        end = (start shl 1) - 1
        for (i in start..end) {
            writeInt(tree[i])
        }
        writeByte(ASCII_n)
    }
    flushBuffer()
}
```
- 완전 이진트리는 배열로 표현 가능하다.
- 1번 인덱스를 루트로 삼아서 시작하면, 왼쪽 자식노드는 부모 자식 노드 인덱스의 2배이며, 오른쪽 자식 노드는 왼쪽 자식 노드 + 1의 인덱스다.

---
