package Arrays.medium

class JumpGameII {
    //Example 1:
    //Input: nums = [2,3,1,1,4]
    //Output: 2
    //Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

    //Example 2:
    //Input: nums = [2,3,0,1,4]
    //Output: 2
    fun jump(nums: IntArray): Int {
        var minJump = 0
        var max = nums[0]
        var left = 0
        var right: Int
        if (nums.size == 1) return 0
        if (nums.size == 2 || max >= nums.lastIndex) return 1
        while (max < nums.lastIndex) {
            right = max
            var temp = 0
            for (i in left..right) {
                max = maxOf(max, i + nums[i])
                if(max>right) temp = i
            }
            left = temp
            minJump++
            if (max>=nums.lastIndex)minJump++
        }
        return minJump
    }
}