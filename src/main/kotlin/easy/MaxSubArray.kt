package easy

import java.lang.Integer.max

class MaxSubArray {
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
        var max = 0
        for (i in nums.indices) {
            var sum = 0
            var add = 0
            for (j in i..nums.lastIndex) {
                add += nums[j]
                sum = max(add, sum)
            }
            max = max(sum, max)
        }
        return max
    }

}