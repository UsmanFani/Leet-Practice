package dp.medium

//@author Usman Fani
class PalindromicSubstring {
    // Example 1:
    //
    //Input: s = "abc"
    //Output: 3
    //Explanation: Three palindromic strings: "a", "b", "c".
    //Example 2:
    //
    //Input: s = "aaa"
    //Output: 6
    //Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
    fun countSubstrings(s: String): Int {
        val dp = Array(s.length) { IntArray(s.length) }
        countSub(0, s.lastIndex, s, dp)
        return dp[0][s.lastIndex]
    }

    private fun countSub(start: Int, end: Int, s: String, dp: Array<IntArray>): Int {
        if (dp[start][end] != 0) return 0
        if (start == end) {
            dp[start][end] = 1
            return 1
        }

        val count1 = countSub(start, end - 1, s, dp)
        val count2 = countSub(start + 1, end, s, dp)

        var st = start
        var e = end
        while (st <= e) {
            if (s[st] != s[e]) break
//            if (dp[st][e] != 0) {
//                dp[start][end] = 1
//                break
//            }
            if (st == e - 1 && s[st] == s[e]) {
                dp[start][end] = 1
            }
            if (st == e) {
                dp[start][end] = 1
            }
            st++
            e--
        }
        dp[start][end] = dp[start][end] + count1 + count2
        return dp[start][end]
    }

    //Bottom-Up Approach (Tabulation)
    //Time:O(n^2)
    //Space: O(n^2)
    fun countSub(s: String): Int {
        var count = 0
        val dp = Array(s.length) { BooleanArray(s.length) }
        for (i in s.indices) {
            for (j in s.indices) {
                if (j + i > s.lastIndex) break
                if (s[j] == s[j + i]) {
                    if (i < 2) {
                        dp[j][j + i] = true
                        count++
                    } else {
                        if (dp[j + 1][(j + i) - 1]) {
                            dp[j][j + i] = true
                            count++
                        }
                    }
                }
            }
        }
        return count
    }

    //Time: O(n^2)
    //Space: O(1)
    fun optimCountSub(s: String): Int {
        var count = 0

        for (i in s.indices) {
            var left = i
            var right = i
            while (left >= 0 && right <= s.lastIndex && s[left] == s[right]) {
                count++
                left--
                right++
            }

            left = i
            right = i + 1
            while (left >= 0 && right <= s.lastIndex && s[left] == s[right]) {
                count++
                left--
                right++
            }
        }
        return count
    }
}