package Strings.Easy

//@author Usman Fani
class ValidPalindrome2 {
    //Example 1:
    //Input: s = "aba"
    //Output: true

    //Example 2:
    //Input: s = "abca"
    //Output: true
    //Explanation: You could delete the character 'c'.
    fun validPalindrome(s: String): Boolean {
        var start = 0
        var end = s.lastIndex
        while (start < end) {
            if (s[start] != s[end]) {
                return check(start + 1, end, s) || check(start, end - 1, s)
            }
            start++
            end--
        }
        return true
    }

    private fun check(start: Int, end: Int, s: String): Boolean {
        var start = start
        var end = end
        while (start < end) {
            if (s[start] != s[end]) return false
            start++
            end--
        }
        return true
    }
}