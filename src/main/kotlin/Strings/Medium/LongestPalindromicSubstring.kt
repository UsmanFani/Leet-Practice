package Strings.Medium

//@author Usman Fani
class LongestPalindromicSubstring {
    fun longestPalindrome(s: String): String {
        var maxPal = ""
        s.indices.forEach {
            val pal = expand(it, s)
            if (pal.length > maxPal.length) maxPal = pal
        }
        for (i in 1..s.lastIndex) {
            if (s[i-1]==s[i]) {
                val pal = expand(i - 1, i, s)
                if (pal.length > maxPal.length) maxPal = pal
            }
        }
        return maxPal
    }

    private fun expand(index: Int, s: String): String {
        var left = index - 1
        var right = index + 1
        var str = s[index].toString()
        while (left >= 0 && right <= s.lastIndex) {
            if (s[left] == s[right]) {
                str = s[left] + str + s[right]
            } else break
            left--
            right++
        }
        return str
    }

    private fun expand(index1: Int, index2: Int, s: String): String {
        var left = index1 - 1
        var right = index2 + 1
        var str = s[index1].toString()
        str += s[index2].toString()
        while (left >= 0 && right <= s.lastIndex) {
            if (s[left] == s[right]) {
                str = s[left] + str + s[right]
            } else break
            left--
                right++
        }
        return str
    }
}