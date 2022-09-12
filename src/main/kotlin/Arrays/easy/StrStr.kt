package Arrays.easy

class StrStr {
    //haystack = "hello", needle = "ll"
    //2
    fun strStr(haystack: String, needle: String): Int {
        var index = -1
        var temp = 0
        for (i in haystack.indices) {
            if (needle[0] == haystack[i] && (haystack.length - i) >= needle.length) {
                for (j in needle.indices) {
                    if (needle[j] == haystack[i + j]) temp++
                }
            }
            if (temp == needle.length) return i
            else temp = 0
        }
        return index
    }
}