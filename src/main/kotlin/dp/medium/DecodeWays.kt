package dp.medium

class DecodeWays {
    //Example 1:
    //Input: s = "12"
    //Output: 2
    //Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

    //Example 2:
    //Input: s = "226"
    //Output: 3
    //Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

    //Example 3:
    //Input: s = "06"
    //Output: 0
    //Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
    lateinit var dp: Array<IntArray>
    fun numDecodings(s: String): Int {
        dp = Array(s.length + 1) { IntArray(s.length + 1) { -1 } }
        val d1 = decode(s, 0, 0)
        val d2 = decode(s, 0, 1)
        return d1 + d2
    }

    private fun decode(s: String, firstIndex: Int, secondIndex: Int): Int {
        if (firstIndex == secondIndex) {
            if (dp[firstIndex][secondIndex] != -1) return dp[firstIndex][secondIndex]
            var ones = s[firstIndex].code - 48
            if (ones == 0) return 0
            if (firstIndex == s.lastIndex) return 1
        } else {
            if (dp[firstIndex][secondIndex] != -1) return dp[firstIndex][secondIndex]
            if (secondIndex > s.lastIndex) return 0
            if (s[firstIndex].code - 48 == 0) return 0
            val tens = (s[firstIndex].code - 48) * 10 + (s[secondIndex].code - 48)
            if (tens > 26) return 0
            if (secondIndex == s.lastIndex) return 1
        }
        if (firstIndex == secondIndex) {
            if (dp[firstIndex][secondIndex] != -1) return dp[firstIndex][secondIndex]
            val a1 = decode(s, firstIndex + 1, firstIndex + 1)
            val a2 = decode(s, firstIndex + 1, firstIndex + 2)
            dp[firstIndex][secondIndex] = a1 + a2
            return dp[firstIndex][secondIndex]
        } else {
            if (dp[firstIndex][secondIndex] != -1) return dp[firstIndex][secondIndex]
            val b1 = decode(s, secondIndex + 1, secondIndex + 1)
            val b2 = decode(s, secondIndex + 1, secondIndex + 2)
            dp[firstIndex][secondIndex] = b1 + b2
            return dp[firstIndex][secondIndex]
        }
    }

}