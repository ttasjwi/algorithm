import java.util.*

class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        val schedules = arrayOfNulls<Schedule>(book_time.size)
        val rooms = ArrayList<Schedule?>()
        for (i in book_time.indices) {
            schedules[i] = Schedule(Time.from(book_time[i][0]), Time.from(book_time[i][1]) + 10)
        }
        Arrays.sort(schedules)
        loop@ for (schedule in schedules) {
            for (i in rooms.indices) {
                if (rooms[i] !== null && rooms[i]!!.end <= schedule!!.start) {
                    rooms[i] = null
                }
            }
            for (i in rooms.indices) {
                if (rooms[i] === null) {
                    rooms[i] = schedule
                    continue@loop
                }
            }
            rooms += schedule
        }
        return rooms.size
    }
}

data class Time(val hour: Int, val minute: Int) : Comparable<Time> {

    companion object {
        fun from(str: String): Time {
            val list = str.split(":")
            return Time(list[0].toInt(), list[1].toInt())
        }
    }

    operator fun plus(minute: Int): Time {
        var newMinute = this.minute + minute
        if (newMinute >= 60) {
            return Time(hour + 1, newMinute - 60)
        } else {
            return Time(hour, newMinute)
        }
    }

    override fun compareTo(other: Time): Int {
        if (hour == other.hour) return this.minute - other.minute
        else return this.hour - other.hour
    }
}

data class Schedule(val start: Time, val end: Time): Comparable<Schedule> {

    override fun compareTo(other: Schedule): Int {
        return this.start.compareTo(other.start)
    }
}
