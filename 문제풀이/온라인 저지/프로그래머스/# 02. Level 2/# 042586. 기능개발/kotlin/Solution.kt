import java.util.*

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val queue = LinkedList<Work>()

        for (i in 0 until progresses.size) {
            queue.offer(Work(progresses[i], speeds[i]))
        }
        var size: Int
        var cur: Work
        var isFirst: Boolean
        val deploy = ArrayList<Int>()
        var toDayDeploy: Int
        while(!queue.isEmpty()) {
            size = queue.size
            isFirst = true
            toDayDeploy = 0
            while (size-- > 0) {
                cur = queue.pop()
                cur.progress()
                if (isFirst && cur.isFinished()) toDayDeploy ++
                else {
                    isFirst = false
                    queue.offer(cur)
                }
            }
            if (toDayDeploy > 0) {
                deploy.add(toDayDeploy)
            }
        }
        return deploy.toIntArray()
    }
}

class Work(private var progress:Int, private var speed: Int) {
    fun progress() {
        if (!isFinished()) this.progress += speed
    }
    fun isFinished() = progress >= 100
}
