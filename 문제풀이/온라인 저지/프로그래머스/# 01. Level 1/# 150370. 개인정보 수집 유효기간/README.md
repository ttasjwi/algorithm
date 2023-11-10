# 문제
- 플랫폼 : 프로그래머스
- 번호 : 150370
- 제목 : 개인정보 수집 유효기간
- 난이도 : Level 1
- 파기해야 할 개인정보의 번호를 오름차순으로 1차원 정수 배열에 담아 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/150370" target="_blank">링크</a>

---

# 필요 지식
- 해시
- 구현
- 문자열 처리

---

# 풀이
```kotlin
class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val todayMyDate = MyDate.from(today)
        val months = HashMap<String, Month>()
        for (term in terms) {
            val split = term.split(' ')
            months[split[0]] = Month(split[1].toInt())
        }

        val answer = ArrayList<Int>()
        for (i in privacies.indices) {
            val split = privacies[i].split(' ')
            val myDate = MyDate.from(split[0])
            val month = months[split[1]]!!
            val expirationDate = myDate + month
            if (todayMyDate >= expirationDate) {
                answer += i + 1
            }
        }
        return answer.toIntArray()
    }
}

data class MyDate(val year:Int, val month: Int, val day: Int) : Comparable<MyDate> {

    companion object {
        fun from(strDate: String) : MyDate {
            val list = strDate.split('.')
            return MyDate(list[0].toInt(), list[1].toInt(), list[2].toInt())
        }
    }

    override fun compareTo(other: MyDate): Int {
        var result = year - other.year
        if (result != 0) return result
        result = month - other.month
        if (result != 0) return result
        return day - other.day
    }

    operator fun plus(month: Month): MyDate {
        var y = this.year
        var m = this.month
        var d = this.day + month.dayCount

        m += ((d-1)/28)
        d = (d-1)%28 + 1

        y += ((m-1)/12)
        m = (m-1)%12 + 1
        return MyDate(y, m, d)
    }
}

data class Month(val value: Int) {
    val dayCount = value * 28
}
```
- Month : 월 정보. 28을 곱한 값이 날짜의 갯수이다.
- MyDate : 연, 월, 일 정보를 가지고 있고, plus를 통해 month를 더하여 해당 달만큼 경과된 날짜를 구할 수 있다.
- 풀이
  - 약관별로, 유효기간 Month를 해싱한다.
  - 개인정보 수집일자에 Month를 더한 날은 더 이상 유효해지지 않는 만료일이다.
  - 현재 날짜가 만료일과 같거나, 만료일 이후일 경우 파기 대상으로 간주한다.
- 반환

---
