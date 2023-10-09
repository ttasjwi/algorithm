# 문제
- 플랫폼 : 백준
- 번호 : 14471
- 제목 : 포인트 카드
- 난이도 : Bronze 2
- M-1개 이상의 경품을 얻기 위해 필요한 비용의 최솟값을 엔 단위로 한 줄로 출력
- 문제 : <a href="https://www.acmicpc.net/problem/14471" target="_blank">링크</a>

---

# 필요 지식
- 그리디 알고리즘
- 정렬
- 우선순위 큐

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val m = i()
    var success = 0
    val heap = Heap(m)
    repeat(m) {
        (n - i()).also { if (it <= 0) success ++ else heap.push(it) }
        i()
    }
    var answer = 0
    while (success < m-1) {
        answer += heap.pop()
        success ++
    }
    writeInt(answer)
    flushBuffer()
}

class Heap(cap: Int) {

    private val arr = IntArray(cap + 1)
    private var size = 0

    fun push(e: Int) {
        arr[++size] = e
        var i = size
        var p = i shr 1
        while (p > 0) {
            if (arr[i] < arr[p]) {
                arr[p] = arr[i].also { arr[i] = arr[p] }
                i = p
                p = i shr 1
            } else {
                break
            }
        }
    }

    fun pop() : Int {
        val e = arr[1]
        arr[1] = arr[size--]
        var i = 1
        var lt = i shl 1
        var rt = lt + 1
        var small = i
        while (true) {
            if (lt <= size && arr[lt] < arr[small]) small = lt
            if (rt <= size && arr[rt] < arr[small]) small = rt
            if (i == small) break
            arr[i] = arr[small].also { arr[small] = arr[i] }
            i = small
            lt = i shl 1
            rt = lt + 1
        }
        return e
    }
}
```
- 당첨인 경우 당첨개수를 누적시키고, 당첨이 아닌 경우 당첨을 만드는데 필요한 비용을 최소힙에 삽입한다.
- 당첨 개수를 충족할 때까지 힙에서 비용을 꺼내서 가산한다.
- 비용을 출력한다.

---
