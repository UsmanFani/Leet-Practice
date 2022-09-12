package Arrays.medium

class ProductExceptSelf {
    /*
    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

     The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

     You must write an algorithm that runs in O(n) time and without using the division operation.
     */

    //Example 1:
    //
    //Input: nums = [1,2,3,4]
    //Output: [24,12,8,6]

    //Example 2:
    //
    //Input: nums = [-1,1,0,-3,3]
    //Output: [0,0,9,0,0]

    fun productExceptSelf(nums: IntArray): IntArray {
        var res = IntArray(nums.size)
        var leftMult = IntArray(nums.size) { nums[0] }
        var rightMult = IntArray(nums.size) { nums[nums.lastIndex] }
        for (i in 1..nums.lastIndex) {
            leftMult[i] = nums[i] * leftMult[i - 1]
        }
        for (i in nums.lastIndex - 1 downTo 0) {
            rightMult[i] = nums[i] * rightMult[i + 1]
        }
        for (i in nums.indices) {
            when (i) {
                0 -> {
                    res[i] = rightMult[1]
                }
                nums.lastIndex -> {
                    res[i] = leftMult[i - 1]
                }
                else -> {
                    res[i] = leftMult[i - 1] * rightMult[i + 1]
                }
            }
        }
        return res
    }
}