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
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = nums[0]
        var sum = 0
        for (i in nums.indices) {
            sum += nums[i]
            if (sum < nums[i]) sum = nums[i]
            maxSum = maxOf(maxSum, sum)
        }
        return sum
    }

    //Divide & Conquer Approach
    fun dpMaxSubArray(nums: IntArray):Int{
        return dp(nums,0,nums.lastIndex)
    }

    private fun dp(nums: IntArray,start:Int,end:Int):Int{
        if(end-start==0) return nums[start]
        val mid = (end+start)/2
        val dp1Sum = dp(nums,start,mid)
        val dp2Sum = dp(nums,mid+1,end)
        val sum = dp1Sum+dp2Sum
        val max = maxOf(dp1Sum,dp2Sum)
        return maxOf(max,sum)
    }
}