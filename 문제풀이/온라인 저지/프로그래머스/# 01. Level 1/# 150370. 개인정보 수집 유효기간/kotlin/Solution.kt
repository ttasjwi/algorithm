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
