package Strings.Easy

//@author Usman Fani
class LongestCommonPrefix {
    //Example 1:
    //Input: strs = ["flower","flow","flight"]
    //Output: "fl"

    //Example 2:
    //Input: strs = ["dog","racecar","car"]
    //Output: ""
    //Explanation: There is no common prefix among the input strings.
    fun longestCommonPrefix(strs: Array<String>): String {
        var rev = ""
        for (i in strs[0].indices) {
            for (j in strs.indices) {
                if (i >= strs[j].length) return rev
                if (strs[j][i] != strs[0][i]) return rev
            }
            rev += strs[0][i]
        }
        return rev
    }
}