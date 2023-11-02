import java.util.Arrays

class Solution {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        val table = Array(data.size) { i -> Tuple(data[i], col)}
        Arrays.sort(table)
        val si = IntArray(data.size + 1)

        for (i in table.indices) {
            si[i+1] = table[i].si(i+1)
        }
        var answer = si[row_begin]
        for (i in row_begin until row_end) {
            answer = answer.xor(si[i+1])
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
            si += item%i
        }
        return si
    }

    override fun compareTo(other: Tuple): Int {
        if (arr[col-1] == other.arr[col-1]) {
            return other.id - this.id
        }
        return arr[col-1] - other.arr[col-1]
    }

}
