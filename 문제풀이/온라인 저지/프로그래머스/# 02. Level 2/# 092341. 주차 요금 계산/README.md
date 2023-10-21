# 문제
- 플랫폼 : 프로그래머스
- 번호 : 092341
- 제목 : 주차 요금 계산
- 난이도 : Level 2
- 차량별로 주차 요금을 계산
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/92341" target="_blank">링크</a>

---

# 필요 지식
- 문자열 처리
- 해시
- 정렬
- 구현

---

# 풀이
```kotlin

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
```
- parse : 문자열을 " " 기준으로 분리하고 Triple로 변환하는 함수
  - 첫번째 문자열은 "시간:분"인데 계산의 편의를 위해 분으로 환산했다.
  - 두번째 문자열은 차량 번호
  - 세번째 문자열은 "IN"이면 true "OUT"이면 false
- totalTimes : 머문 시간(id 기준으로 오름차순 정렬되도록 TreeMap을 사용했다.)
- stops : 차량이 입차한 시간을 저장한 해시테이블 (key : 차량번호, value : 입차한 분)
- records를 하나하나 읽어가면서 parse 후 입/출차한다.
  - 출차할 때는 totalTimes에 머문 시간을 누적한다.
- 마지막에 stops에 차량이 남아있으면 1439(23:59)에서 입차시간을 차감하여 머문 시간을 누적한다.
- 요금 계산법에 따라 요금을 계산하고 숫자 배열로 변환해 반환한다.

---
