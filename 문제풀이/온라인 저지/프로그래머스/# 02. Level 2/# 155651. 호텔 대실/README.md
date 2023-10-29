# 문제
- 플랫폼 : 프로그래머스
- 번호 : 155651
- 제목 : 호텔 대실
- 난이도 : Level 2
- 코니에게 필요한 최소 객실의 수를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/155651" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
## 풀이1 (내 삽질)
```kotlin
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
```
- Time : 시간(정렬 기준 : 시, 분 순으로 오름차순)
- Schedule : 시작~끝 사이의 연속된 기간을 정의(정렬 기준 : 시작시간 오름차순)
- 시간문자열들을 파싱하여 Schedule들로 만든다.
- schedule 배열을 정렬한다.
- 다음을 반복한다.
  - 지금 시작하려는 schedule보다 먼저 끝난 schedule들을 rooms에서 지운다.(해당 인덱스를 null로 만든다.)
  - 빈 방을 찾아서 schedule을 삽입한다. 비어있는 방이 없으면 방을 새로 만들어서 거기에 schedule을 삽입한다.
- 최종적으로 rooms의 size를 반환하면 된다.

## 풀이2 : 동시사용 방의 갯수를 시간별 카운팅
```kotlin
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
```
- 00시 00분부터 24:10까지 분마다 동시에 사용하는 방의 갯수를 카운팅하는 배열을 만든다.
- 시작/종료 시간을 파싱하고 시작시간부터 (종료시간+9)까지, 해당 시점의 동시 사용 방 갯수 카운트를 1 증가시킨다.
- 동시 사용 방 갯수의 최댓값을 매번 갱신시키고 이 값을 반환시키면 된다.

