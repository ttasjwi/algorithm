# 문제
- 플랫폼 : 백준
- 번호 : 11279
- 제목 : 최대 힙
- 난이도 : Silver 2
- 최대 힙을 이용하여 문제에서의 연산을 지원하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/11279" target="_blank">링크</a>

---

# 필요 지식
- 힙

---

# 풀이

## 풀이1: 실제 힙 구현
```kotlin
fun main() {
    var n = i()
    val heap = Heap(n)
    val sb = StringBuilder()
    var tmp: Int
    while (n-- > 0) {
        tmp = i()
        if (tmp == 0) sb.append(heap.extract()).append('\n')
        else heap.insert(tmp)
    }
    print(sb)
}

class Heap(cap: Int) {

    private val items = IntArray(cap + 1)
    private var size = 0

    fun insert(e: Int) {
        items[++size] = e
        var i = size
        var p = i shr 1
        while (p > 0) {
            if (items[i] > items[p]) {
                items[p] = items[i].also { items[i] = items[p] }
                i = p
                p = i shr 1
            } else {
                break
            }
        }
    }

    fun extract(): Int {
        if (size == 0) return 0
        val e = items[1]
        items[1] = items[size--]

        var i = 1
        var lt = i shl 1
        var rt = lt + 1
        var big = i

        while (true) {
            if (lt <= size && items[lt] > items[big]) big = lt
            if (rt <= size && items[rt] > items[big]) big = rt

            if (big == i) break

            items[big] = items[i].also { items[i] = items[big] }
            i = big
            lt = i shl 1
            rt = lt + 1
            big = i
        }
        return e
    }
}
```
- 배열을 이용해 최대 이진힙을 구현하면 제일 빠르다.
- Heap은 내부적으로 배열을 사용하도록 하는데, 이 배열의 길이는 문제에서 주어진 연산횟수 +1로 잡는다.(게산의 편의를 위해 1번 인덱스부터 요소를 두기 위함)
- 삽입연산(O(log n))
  - 트리의 최하단 기준 가장 왼쪽에 삽입한다.(배열 기준 가장 마지막에 삽입)
  - 부모와 비교하면서 더 큰 쪽을 위로 올린다.(계속)
- 추출연산(O(log n))
  1. 트리의 최상단 요소를 추출한다. (실제 반환할 값)
     - 이것만 뽑는걸 놓고보면 O(1)이지만 힙을 유지시켜야 하므로 실제 시간 복잡도는 O(log n)이다.
  2. 트리 최하단 끝요소(size에 위치한 요소)를 1번 인덱스(루트)에 위치시키고 size를 1 감소 시킨다 
  3. 1번 노드부터 자식과 비교하며 더 큰 값이 있으면 가장 큰 쪽으로 스왑한다.
  4. 1에서 추출한 요소를 반환한다.

## 풀이2: PriorityQueue 라이브러리 이용
```kotlin
fun main() {
    var n = i()
    val heap = PriorityQueue<Int>()
    val sb = StringBuilder()
    var x: Int
    while (n-- > 0) {
        x = i()
        if (x == 0) {
            sb.append(if (heap.isEmpty()) 0 else -heap.poll()).append('\n')
        }
        else heap.add(-x)
    }
    print(sb)
}
```
- PriorityQueue 라이브러리를 이용한다
- 값을 삽입할 때 음의 부호로 삽입한다.
- 주어진 조건에 따라 출력해 나가면 된다.

---
