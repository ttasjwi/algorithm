class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        else if (x == 0) return true
        else {
            val strX = x.toString()
            var lt = 0
            var rt = strX.lastIndex

            while (lt < rt) {
                if (strX[lt] != strX[rt]) {
                    return false
                } else {
                    lt ++
                    rt --
                }
            }
            return true
        }
    }
}
