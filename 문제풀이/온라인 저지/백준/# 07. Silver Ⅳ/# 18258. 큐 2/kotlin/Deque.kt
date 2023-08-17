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