# 문제
- 플랫폼 : 백준
- 번호 : 01927
- 제목 : 최소 힙
- 난이도 : Silver 2
- 최소 힙을 이용하여 주어진 연산을 수행하는 프로그램 작성
- 문제 : <a href="https://www.acmicpc.net/problem/1927" target="_blank">링크</a>

---

# 필요 지식
- 최소 힙
- 우선순위 큐

---

# 풀이
```kotlin
fun main() {
    var n = i()
    val heap = IntArray(n+1)
    var size = 0

    fun insert(e: Int) {
        heap[++size] = e
        var i = size
        var p = size shr 1
        while (p > 0) {
            if (heap[i] < heap[p]) {
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
        while (true) {
            if (lt <= size && heap[lt] < heap[small]) small = lt
            if (rt <= size && heap[rt] < heap[small]) small = rt
            if (small == i) break
            heap[i] = heap[small].also { heap[small] = heap[i] }
            i = small
            lt = i shl 1
            rt = lt + 1
            small = i
        }
        return e
    }
    var x: Int
    val sb = StringBuilder()
    while (n-- > 0) {
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
- 배열을 이용해 최소 이진힙을 구현하면 제일 빠르다.
- Heap은 내부적으로 배열을 사용하도록 하는데, 이 배열의 길이는 문제에서 주어진 연산횟수 +1로 잡는다.(게산의 편의를 위해 1번 인덱스부터 요소를 두기 위함)
- 삽입연산(O(log n))
    - 트리의 최하단 기준 가장 왼쪽에 삽입한다.(배열 기준 가장 마지막에 삽입)
    - 부모와 비교하면서 더 작은 쪽을 위로 올린다.(계속)
- 추출연산(O(log n))
    1. 트리의 최상단 요소를 추출한다. (실제 반환할 값)
        - 이것만 뽑는걸 놓고보면 O(1)이지만 힙을 유지시켜야 하므로 실제 시간 복잡도는 O(log n)이다.
    2. 트리 최하단 끝요소(size에 위치한 요소)를 1번 인덱스(루트)에 위치시키고 size를 1 감소 시킨다
    3. 1번 노드부터 자식과 비교하며 더 작은 값이 있으면 가장 작은 쪽을 스왑한다.
    4. 1에서 추출한 요소를 반환한다.
---
