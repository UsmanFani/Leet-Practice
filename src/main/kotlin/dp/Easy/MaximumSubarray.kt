package dp.Easy

class MaximumSubarray {
    //Example 1:
    //Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    //Output: 6
    //Explanation: [4,-1,2,1] has the largest sum = 6.

    //Example 2:
    //Input: nums = [1]
    //Output: 1

    //Example 3:
    //Input: nums = [5,4,-1,7,8]
    //Output: 23

    //Kadane's algo (O(n))
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = nums[0]
        var sum = 0
        for (i in nums.indices) {
            sum += nums[i]
            if (sum < nums[i]) sum = nums[i]
            if (sum > maxSum) maxSum = sum
        }
        return maxSum
    }

    //Divide & Conquer Approach (O(nlogn))
    fun dcMaxSubArray(nums: IntArray): Int {
        return dc(nums, 0, nums.lastIndex)
    }

    private fun dc(nums: IntArray, start: Int, end: Int): Int {
        if (start - end == 0) return nums[start]
        val mid = (end + start) / 2
        //maximum subArray Sum
        val leftMSS = dc(nums, start, mid)
        val rightMSS = dc(nums, mid + 1, end)
        var rightSum = Int.MIN_VALUE
        var leftSum = Int.MIN_VALUE
        var sum = 0
        //mid to left
        for (i in mid downTo start) {
            sum += nums[i]
            leftSum = maxOf(leftSum, sum)
        }
        sum = 0
        //mid to right
        for (i in mid + 1..end) {
            sum += nums[i]
            rightSum = maxOf(sum, rightSum)
        }
        val crossSum = leftSum + rightSum
        return maxOf(leftMSS, rightMSS, crossSum)
    }
}