package Arrays.easy

class RunningSum {
    fun runningSum(nums:IntArray):IntArray{
        var sum = 0
        for(i in nums.indices){
            sum += nums[i]
            nums[i] = sum
        }
        return nums
    }
}