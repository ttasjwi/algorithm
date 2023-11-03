class Solution {
    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        var life = n
        var chance = k
        val heap = Heap(enemy.size)
        for (i in enemy.indices) {
            life -= enemy[i]
            heap.add(enemy[i])
            if (life < 0) {
                if (chance > 0 && heap.isNotEmpty()) {
                    life += heap.poll()
                    chance --
                } else {
                    return i
                }
            }
        }
        return enemy.size
    }
}

class Heap(cap: Int) {

    private val arr = IntArray(cap + 1)

    private var size = 0

    fun add(e: Int) {
        arr[++size] = e
        var i = size
        var p = size shr 1
        var big = i
        while (p > 0) {
            if (arr[i] > arr[p]) {
                arr[p] = arr[i].also { arr[i] = arr[p] }
                i = p
                p = i shr 1
            } else {
                break
            }
        }
    }

    fun poll() : Int {
        val e = arr[1]
        arr[1] = arr[size--]
        var i = 1
        var lt = i shl 1
        var rt = lt + 1
        var big = i
        while(true) {
            if (lt <= size && arr[lt] > arr[big]) big = lt
            if (rt <= size && arr[rt] > arr[big]) big = rt
            if (i == big) break
            arr[i] = arr[big].also{arr[big] = arr[i]}
            i = big
            lt = i shl 1
            rt = lt + 1
        }
        return e
    }

    fun isNotEmpty() = size != 0

}