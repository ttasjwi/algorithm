class Solution {
    fun solution(arr: IntArray) = IntArray(arr.size) { i ->
        when {
            (arr[i] >= 50 && arr[i] % 2 == 0) -> arr[i] shr 1
            (arr[i] < 50 && arr[i] % 2 != 0) -> arr[i] shl 1
            else -> arr[i]
        }
    }
}
