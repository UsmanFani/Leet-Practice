package contest.biweekly

//@author Usman Fani
class MinimizeArrayValue {
    //Example 1:
    //Input: nums = [3,7,1,6]
    //Output: 5
    //Explanation:
    //One set of optimal operations is as follows:
    //1. Choose i = 1, and nums becomes [4,6,1,6].
    //2. Choose i = 3, and nums becomes [4,6,2,5].
    //3. Choose i = 1, and nums becomes [5,5,2,5].
    //The maximum integer of nums is 5. It can be shown that the maximum number cannot be less than 5.
    //Therefore, we return 5.

    //Example 2:
    //Input: nums = [10,1]
    //Output: 10
    //Explanation:
    //It is optimal to leave nums as is, and since 10 is the maximum value, we return 10.
    fun minimizeArrayValue(nums: IntArray): Int {
        var max: Long = 0
        var sum: Long = 0
        for (i in 0..nums.lastIndex) {
            sum += nums[i]
            val avg = (sum + i) / (i + 1)
            max = maxOf(max, avg)
        }
        return max.toInt()
    }

}