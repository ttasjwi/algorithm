class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        val concurrentRoomCnt = IntArray(1450)
        var maxConcurrentRoomCnt = 0

        for (bt in book_time) {
            val start = bt[0].split(":")
            var startMinute = start[0].toInt() * 60
            startMinute += start[1].toInt()

            val end = bt[1].split(":")
            var endMinute = end[0].toInt() * 60
            endMinute += end[1].toInt() + 10

            for (t in startMinute until endMinute) {
                concurrentRoomCnt[t] += 1
                if (concurrentRoomCnt[t] > maxConcurrentRoomCnt) {
                    maxConcurrentRoomCnt = concurrentRoomCnt[t]
                }
            }
        }
        return maxConcurrentRoomCnt
    }
}
