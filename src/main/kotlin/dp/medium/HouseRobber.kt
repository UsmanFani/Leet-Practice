package dp.medium

//@author Usman Fani
class HouseRobber {
    //Example 1:
    //Input: nums = [1,2,3,1]
    //Output: 4
    //Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
    //Total amount you can rob = 1 + 3 = 4.

    //Example 2:
    //Input: nums = [2,7,9,3,1]
    //Output: 12
    //Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
    //Total amount you can rob = 2 + 9 + 1 = 12.

    //Top-Down Approach (Recursive + Memoization)
    //O(n)
    //O(n)
    fun rob(nums: IntArray): Int {
        val dp = IntArray(nums.size) { -1 }
        val h1 = house(0, nums, dp)
        val h2 = house(1, nums, dp)
        return maxOf(h1, h2)
    }

    private fun house(index: Int, nums: IntArray, dp: IntArray): Int {
        if (index > nums.lastIndex) return 0
        if (dp[index] != -1) return dp[index]
        val h1 = nums[index] + house(index + 2, nums, dp)
        val h2 = nums[index] + house(index + 3, nums, dp)
        dp[index] = maxOf(h1, h2)
        return dp[index]
    }

    //Bottom-Up Approach (Tabulation)
    //O(n)
    //O(1)
    fun optimHouseRobber(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        for (i in nums.lastIndex - 2 downTo 0) {
            if (i + 2 <= nums.lastIndex) {
                val num1 = nums[i] + nums[i + 2]
                val num2 = if (i + 3 <= nums.lastIndex) nums[i] + nums[i + 3] else 0
                nums[i] = maxOf(num1, num2)
            }
        }
        return maxOf(nums[0], nums[1])
    }
}