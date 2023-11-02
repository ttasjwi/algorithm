# 문제
- 플랫폼 : 프로그래머스
- 번호 : 147354
- 제목 : 테이블 해시 함수
- 난이도 : Level 2
- 테이블의 해시 값을 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/147354" target="_blank">링크</a>

---

# 필요 지식
- 정렬
- 구현

---

# 풀이

```kotlin
import java.util.Arrays

class Solution {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        val table = Array(data.size) { i -> Tuple(data[i], col) }
        Arrays.sort(table)
        val si = IntArray(data.size + 1)

        for (i in table.indices) {
            si[i + 1] = table[i].si(i + 1)
        }
        var answer = si[row_begin]
        for (i in row_begin until row_end) {
            answer = answer.xor(si[i + 1])
        }
        return answer
    }
}

class Tuple(
    private val arr: IntArray,
    private val col: Int,
) : Comparable<Tuple> {

    private val id: Int = arr[0]

    fun si(i: Int): Int {
        var si = 0
        for (item in arr) {
            si += item % i
        }
        return si
    }

    override fun compareTo(other: Tuple): Int {
        if (arr[col - 1] == other.arr[col - 1]) {
            return other.id - this.id
        }
        return arr[col - 1] - other.arr[col - 1]
    }

}
```
- 문제에서 시키는 대로만 하면 된다.
- 다만 문제에서 말하는 xx번째라는 말이 배열의 인덱스+1 이라는 점에 주의하자.

---
