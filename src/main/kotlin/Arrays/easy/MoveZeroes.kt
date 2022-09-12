package Arrays.easy

class MoveZeroes {
    //Example 1:
    //
    //Input: nums = [0,1,0,3,12]
    //Output: [1,3,12,0,0]

    //Example 2:
    //
    //Input: nums = [0]
    //Output: [0]
    fun moveZeroes(nums: IntArray): IntArray {
        var zeroIndex: Int? = null
        for (i in nums.indices) {
            if (nums[i] == 0 && zeroIndex == null) zeroIndex = i
            else if (nums[i] != 0 && zeroIndex != null) {
                nums[zeroIndex] = nums[i]
                nums[i] = 0
                zeroIndex++
            }
        }
        return nums
    }
}