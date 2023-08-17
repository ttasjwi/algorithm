 # 문제
- 플랫폼 : 백준
- 번호 : 18258
- 제목 : 큐 2
- 난이도 : Silver 4
- 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/18258" target="_blank">링크</a>

---

# 필요 지식
- 큐

---

# 풀이
## 풀이1: 연결리스트 사용
```kotlin
fun main() {
    val q = LinkedList<Int>()
    var n = i()
    val sb = StringBuilder()
    while (n-- > 0) {
        sb.append(when(c()) {
            'o' -> if (q.isEmpty()) -1 else q.poll()
            'i' -> q.size
            'm' -> if (q.isEmpty()) 1 else 0
            'r' -> if (q.isEmpty()) -1 else q.peek()
            'a' -> if (q.isEmpty()) -1 else q.peekLast()
            else -> {q.offer(i()); continue}
        }).append('\n')
    }
    print(sb)
}
```
- `c()` : 명령의 두번째 문자를 읽어온다
- `i()` : 숫자를 읽어온다
- java api를 통해 제공되는 연결 리스트를 통해 기능을 구현했다.
- 실용적 관점에서는 이게 제일 편하다

---

## 풀이2: 배열로 큐 구현
```kotlin
fun main() {
    var n = i()
    val q = IntArray(n+1)
    var f = 0
    var r = 0
    var s = 0
    val sb = StringBuilder()
    while (n-- > 0) {
        sb.append(when (c()) {
            'o' -> if (s==0) -1 else {s--; q[(f++)+1]}
            'i' -> s
            'm' -> if (s==0) 1 else 0
            'r' -> if (s==0) -1 else q[f+1]
            'a' -> if (s==0) -1 else q[r]
            else -> {s++; q[++r] = i(); continue}
        }).append('\n')
    }
    print(sb)
}
```
- f : 제일 앞 요소의 앞 인덱스
- r : 제일 뒤 요소의 인덱스
- s : 사이즈
- (첫 입력값+1)만큼 배열 사이즈를 잡고 배열을 통해 큐를 구현했다.
- primitive 타입 배열을 이용해 기능을 구현했으므로 성능 면에서 더 좋다.

---

# 학습 - 원형 덱 구현하기
```kotlin
import java.util.NoSuchElementException

interface Deque<E> {
    fun enQueueFirst(e: E): Boolean
    fun enQueueLast(e: E): Boolean
    fun deQueueFirst(): E
    fun deQueueLast(): E
    fun peekFirst(): E
    fun peekLast(): E
    fun isEmpty(): Boolean
    fun isFull(): Boolean
}

interface Queue<E> {
    fun enQueue(e: E): Boolean
    fun deQueue(): E
    fun peek(): E
    fun isEmpty(): Boolean
    fun isFull(): Boolean
}

class CircularDeque<E>(val capacity: Int) : Deque<E>, Queue<E> {

    @Suppress("UNCHECKED_CAST")
    private val array: Array<E?> = arrayOfNulls<Any?>(capacity) as Array<E?>
    private var front: Int = 0
    private var rear: Int = 0
    private var size = 0

    override fun enQueueFirst(e: E): Boolean {
        if (isFull()) {
            return false
        }
        array[front] = e
        front = (front - 1 + capacity) % capacity
        size++
        return true
    }

    override fun enQueueLast(e: E): Boolean {
        if (isFull()) {
            return false
        }
        rear = (rear + 1 + capacity) % capacity
        array[rear] = e
        size++
        return true
    }

    override fun deQueueFirst(): E {
        if (isEmpty()) {
            throw NoSuchElementException()
        }
        val itemIdx = (front + 1 + capacity) % capacity
        val item = array[itemIdx]!!

        array[itemIdx] = null
        front = itemIdx
        size --
        return item
    }

    override fun deQueueLast(): E {
        if (isEmpty()) {
            throw NoSuchElementException()
        }
        val item = array[rear]!!

        array[rear] = null
        rear = (rear - 1 + capacity) % capacity
        size --
        return item
    }

    override fun peekFirst(): E {
        if (isEmpty()) {
            throw NoSuchElementException()
        }
        return array[(front + 1 + capacity) % capacity]!!
    }

    override fun peekLast(): E {
        if (isEmpty()) {
            throw NoSuchElementException()
        }
        return array[rear]!!
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun isFull(): Boolean {
        return size == capacity
    }

    override fun enQueue(e: E): Boolean {
        return enQueueLast(e)
    }

    override fun deQueue(): E {
        return deQueueFirst()
    }

    override fun peek(): E {
        return peekFirst()
    }

}

fun main() {
    val q: Queue<Int> = CircularDeque(5)
    q.enQueue(10)
    q.enQueue(20)
    q.enQueue(30)
    q.enQueue(40)

    println(q.deQueue()) // 10
    println(q.deQueue()) // 20
    q.enQueue(50)
    q.enQueue(60)

    println(q.deQueue()) // 30
    println(q.deQueue()) // 40
    println(q.deQueue()) // 50
    println(q.deQueue()) // 60
}
```