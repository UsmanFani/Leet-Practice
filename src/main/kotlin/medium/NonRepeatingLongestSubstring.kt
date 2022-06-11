package medium

class NonRepeatingLongestSubstring {
    //Example 1:
    //
    //Input: s = "abcabcbb"
    //Output: 3
    //Explanation: The answer is "abc", with the length of 3.

    //Example 2:
    //
    //Input: s = "bbbbb"
    //Output: 1
    //Explanation: The answer is "b", with the length of 1.

    //Example 3:
    //
    //Input: s = "pwwkew"
    //Output: 3
    //Explanation: The answer is "wke", with the length of 3.
    //Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
    fun lengthOfLongestSubstring(s: String): Int {
        var length = 0
        var start = 0
        for (i in 0..s.lastIndex) {
            for (j in start until i) {
                if (s[i] == s[j]) {
                    start = j+1
                    break
                }
            }
            length = maxOf(length, (i - start) + 1)
        }
        return length
    }
}