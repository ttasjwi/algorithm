import java.util.*

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val totalTimes = TreeMap<String, Int>()
        val stops = HashMap<String, Int>()

        var triple: Triple<Int, String, Boolean>
        var minute: Int
        var id: String
        var isIn: Boolean

        for (record in records) {
            triple = parse(record)
            minute = triple.first
            id = triple.second
            isIn = triple.third

            if (isIn) {
                stops[id] = minute
            } else {
                if (!totalTimes.containsKey(id)) {
                    totalTimes[id] = minute - stops[id]!!
                } else {
                    totalTimes[id] = totalTimes[id]!! + minute - stops[id]!!
                }
                stops.remove(id)
            }
        }
        for ((i, inMinute) in stops) {
            if (!totalTimes.containsKey(i)) {
                totalTimes[i] = 1439 - inMinute
            } else {
                totalTimes[i] = totalTimes[i]!! + 1439 - inMinute
            }
        }
        fun calculateFee(totalTime: Int): Int {
            val overTime = (totalTime) - fees[0]
            return when {
                (overTime <= 0) -> fees[1]
                (overTime % fees[2] == 0) -> fees[1] + overTime / fees[2] * fees[3]
                else -> fees[1] + (overTime / fees[2] + 1) * fees[3]
            }
        }
        return totalTimes.values.map { calculateFee(it) }.toIntArray()
    }

    fun parse(record: String): Triple<Int, String, Boolean> {
        val split = record.split(" ")
        val time = split[0].split(":")
        return Triple(time[0].toInt() * 60 + time[1].toInt(), split[1], split[2] == "IN")
    }

}
