# 문제
- 플랫폼 : 백준
- 번호 : 11286
- 제목 : 절댓값 힙
- 난이도 : Silver 1
- 절댓값이 제일 작은(만약 절댓값이 같으면 실제 값이 더 작은) 요소를 최솟값으로 취급하는 최소힙 구현
- 문제 : <a href="https://www.acmicpc.net/problem/11286" target="_blank">링크</a>

---

# 필요지식
- 힙
- 우선순위 큐

---

# 풀이
```kotlin
fun main() {
    var n = i()
    val heap = IntArray(n+1)
    var size = 0
    fun insert(x: Int) {
        heap[++size] = x
        var i = size
        var p = i shr 1
        var diff: Int
        while (p > 0) {
            diff = Math.abs(heap[i]) - Math.abs(heap[p])
            if (diff < 0 || (diff == 0 && heap[i] < heap[p])) {
                heap[p] = heap[i].also { heap[i] = heap[p] }
                i = p
                p = i shr 1
            } else {
                break
            }
        }
    }
    fun extract() : Int {
        if (size == 0) return 0
        val e = heap[1]
        heap[1] = heap[size--]
        var i = 1
        var lt = i shl 1
        var rt = lt +1
        var small = i
        var diff: Int
        while(true) {
            if (lt <= size) {
                diff = Math.abs(heap[lt]) - Math.abs(heap[small])
                if (diff < 0 || (diff == 0 && heap[lt] < heap[small])) {
                    small = lt
                }
            }
            if (rt <= size) {
                diff = Math.abs(heap[rt]) - Math.abs(heap[small])
                if (diff < 0 || (diff == 0 && heap[rt] < heap[small])) {
                    small = rt
                }
            }
            if (small == i) break
            heap[small] = heap[i].also { heap[i] = heap[small] }
            i = small
            lt = i shl 1
            rt = lt + 1
            small = i
        }
        return e
    }
    var x: Int
    val sb = StringBuilder()
    while (n -- > 0) {
        x = i()
        if (x == 0) {
            sb.append(extract()).append('\n')
        } else {
            insert(x)
        }
    }
    print(sb)
}
```
- 배열을 이용해 절댓값 힙을 구현했다.

---
