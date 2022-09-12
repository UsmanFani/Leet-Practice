package Arrays.medium

class JumpGame {
    //Example 1:
    //Input: nums = [2,3,1,1,4]
    //Output: true
    //Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

    //Example 2:
    //Input: nums = [3,2,1,0,4]
    //Output: false
    //Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
    fun canJump(nums: IntArray): Boolean {
        if (nums.size == 1) return true
        var left = 0
        var right = nums[0]
        for (i in 0..nums.lastIndex) {
            if (right >= nums.lastIndex) return true
            if (right == 0) return false
            for (j in right downTo left) {
                right = maxOf(right, j + nums[j])
                if (right >= nums.lastIndex) return true
            }
            left = nums[i]
            right += nums[right]
        }
        return false
    }

    //start from last and check previous can reach to last flag
    //if can reach move flag to previous
    //[3,2,1,0,4]
    //[2,3,1,1,4]
    fun optimCanJump(nums: IntArray): Boolean {
        var flag = nums.lastIndex
        for (i in nums.lastIndex - 1 downTo 0) {
            if (i + nums[i] >= flag) flag = i
        }
        return flag == 0
    }
}