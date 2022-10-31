package dp.medium

//@author Usman Fani
class ContinuousSubarraySum {
    //Example 1:
    //Input: nums = [23,2,4,6,7], k = 6
    //Output: true
    //Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.

    //Example 2:
    //Input: nums = [23,2,6,4,7], k = 6
    //Output: true
    //Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
    //42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.

    //Example 3:
    //Input: nums = [23,2,6,4,7], k = 13
    //Output: false
    private var bool = false
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val dp = Array(nums.size) { IntArray(nums.size) { -1 } }
        return checkSub(0, nums.lastIndex, nums, k, dp)
    }

    private fun checkSub(s: Int, e: Int, nums: IntArray, k: Int, dp: Array<IntArray>): Boolean {
        if (bool) return true
        if (s == e) return false
        if (e - s == 1) {
            dp[s][e] = nums[s] + nums[e]
            if (dp[s][e] % k == 0) bool = true
            return bool
        }

        if (dp[s][e] != -1) return false
        checkSub(s, e - 1, nums, k, dp)
        checkSub(s + 1, e, nums, k, dp)


        dp[s][e] = nums[s] + dp[s + 1][e]

        if (dp[s][e] % k == 0) bool = true
        return bool
    }

    //O(n)
    //O(n)
    fun optimCheckSubarraySum(nums: IntArray, k: Int): Boolean {
        var sum = 0
        val map = mutableMapOf<Int, Int>()
        map[0] = -1

        for (i in nums.indices) {
            sum += nums[i]
            val rem = sum % k
            if (map.containsKey(rem)) {
                if (i - map[rem]!! >= 2) return true
            } else map[rem] = i
        }
        return false
    }
}