# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042746
- 제목 : 가장 큰 수
- 난이도 : Level 2
- 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42746" target="_blank">링크</a>

---

# 필요 지식
- 정렬

---

# 풀이
```kotlin
class Solution {
    fun solution(numbers: IntArray): String {
        val sb = StringBuilder()
        val heap = Heap(numbers.size)
        for (number in numbers) {
            heap.enQueue(MyNumber(number))
        }
        while (heap.isNotEmpty()) {
            sb.append(heap.deQueue())
        }
        return if (sb[0] == '0') "0" else sb.toString()
    }

}

class Heap(cap: Int) {
    private val arr = arrayOfNulls<MyNumber>(cap + 1)
    private var size = 0

    fun enQueue(e: MyNumber) {
        arr[++size] = e
        var i = size
        var p = i shr 1
        while (p > 0) {
            if (arr[i]!! > arr[p]!!) {
                arr[i] = arr[p].also{ arr[p] = arr[i] }
                i = p
                p = i shr 1
            } else {
                break
            }
        }
    }

    fun deQueue(): MyNumber {
        val e = arr[1]!!
        arr[1] = arr[size]
        arr[size--] = null
        var i = 1
        var lt = i shl 1
        var rt = lt + 1
        var big = i
        while (true) {
            if (lt <=size && arr[lt]!! > arr[big]!!) big = lt
            if (rt <=size && arr[rt]!! > arr[big]!!) big = rt
            if (i == big) break
            arr[big] = arr[i].also{arr[i] = arr[big]}
            i = big
            lt = i shl 1
            rt = lt + 1
        }
        return e
    }

    fun isNotEmpty() = size != 0
}

class MyNumber(private val num: Int): Comparable<MyNumber> {

    private val str = num.toString()
    private val length = str.length
    override fun toString(): String = str

    override fun compareTo(other: MyNumber): Int {
        var a = num
        repeat(other.length) {a *= 10}
        a += other.num
        var b = other.num
        repeat(length) {b *= 10}
        b += num
        return if (a>b) 1 else if (a<b) -1 else 0
    }

}
```
- 정렬 기준이 중요하다.
- compareTo는 앞숫자 뒤에 뒷숫자를 붙인 경우/뒷숫자 뒤에 앞숫자를 붙인 경우의 숫자를 a,b라 할 때
  - a > b 이면 1
  - a < b 이면 -1
  - a == b 이면 0 반환
- 이 기준에 따라 힙에 숫자를 전부 삽입하고 매순간 제일 큰 값을 result에 붙인다.

---
