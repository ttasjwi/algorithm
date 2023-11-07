class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x == 0) return true
        if (x < 0 || x % 10 == 0) return false
        var tmp = x
        var reversed = 0
        while (tmp > reversed) {
            reversed *= 10
            reversed += (tmp % 10)
            tmp /= 10
        }
        return reversed == tmp || reversed/10 == tmp
    }
}
