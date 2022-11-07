package dp.medium

import kotlin.math.max

//@author Usman Fani
class LongestArithmeticSubsequence {
    //Example 1:
    //Input: nums = [3,6,9,12]
    //Output: 4
    //Explanation:
    //The whole array is an arithmetic sequence with steps of length = 3.

    //Example 2:
    //Input: nums = [9,4,7,2,10]
    //Output: 3
    //Explanation:
    //The longest arithmetic subsequence is [4,7,10].

    //Example 3:
    //Input: nums = [20,1,15,3,10,5,8]
    //Output: 4
    //Explanation:
    //The longest arithmetic subsequence is [20,15,10,5].

    //O(n^3)
    fun longestArithSeqLength(nums: IntArray): Int {
        var maxLen = 0
        for (i in nums.indices) {
            for (j in i + 1..nums.lastIndex) {
                var len = 2
                val diff = nums[i] - nums[j]
                var endIndex = j + 1
                var startIndex = j
                while (endIndex <= nums.lastIndex) {
                    val tempDiff = nums[startIndex] - nums[endIndex]
                    if (tempDiff == diff) {
                        startIndex = endIndex
                        len++
                    }
                    endIndex++
                }
                maxLen = maxOf(maxLen, len)
            }
        }
        return maxLen
    }

    //Top-Down Approcah (recursive+memoization)
    //O(n^2)
    //O(nm)
    fun recursiveLongestArithSeqLength(nums: IntArray): Int {
        var maxLen = 0
        val dp = Array(nums.size) { mutableMapOf<Int, Int>() }
        for (i in nums.indices) {
            for (j in i + 1..nums.lastIndex) {
                val diff = nums[i] - nums[j]
                val len = 2 + seq(j, diff, nums, dp)
                maxLen = maxOf(maxLen, len)
            }
        }
        return maxLen
    }

    private fun seq(startIndex: Int, diff: Int, nums: IntArray, dp: Array<MutableMap<Int, Int>>): Int {
        if (startIndex > nums.lastIndex) return 0
        if (dp[startIndex].containsKey(diff)) return dp[startIndex][diff]!!
        var ans = 0
        for (i in startIndex + 1..nums.lastIndex) {
            if (nums[startIndex] - nums[i] == diff) {
                ans = maxOf(ans, 1 + seq(i, diff, nums, dp))
            }
        }
        dp[startIndex][diff] = ans
        return dp[startIndex][diff]!!
    }

    //Bottom-UP Approach (Tabulation)
    //O(n^2)
    //O(nm)
    fun tabLAS(nums: IntArray): Int {
        var maxLen = 0
        val dp = Array(nums.size) { mutableMapOf<Int, Int>() }
        for (i in 1..nums.lastIndex) {
            for (j in 0 until i) {
                val diff = nums[i] - nums[j]
                if (dp[j].containsKey(diff)) {
                    dp[i][diff] = dp[j][diff]!! + 1
                } else dp[i][diff] = 2
                maxLen = maxOf(maxLen, dp[i][diff]!!)
            }
        }
        return maxLen
    }
}