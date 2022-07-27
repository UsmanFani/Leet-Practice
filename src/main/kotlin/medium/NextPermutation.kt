package medium

class NextPermutation {
    //Example 1:
    //
    //Input: nums = [1,2,3]
    //Output: [1,3,2]

    //Example 2:
    //
    //Input: nums = [3,2,1]
    //Output: [1,2,3]

    //Example 3:
    //
    //Input: nums = [1,1,5]
    //Output: [1,5,1]
    fun nextPermutation(nums: IntArray): IntArray {
        //1,2,3,4,5,6
        //1,2,3,4,6,5
        //1,2,3,5,4,6
        //1,2,3,5,6,4
        //1,2,3,6,4,5
        //1,2,3,6,5,4
        //1,2,4,3,5,6
        //1,2,4,5,3,6
        //1,2,4,6,3,5
        //1,2,4,6,5,3
        //1,2,5,3,4,6
        for (i in nums.lastIndex downTo 1) {
            var prevIndex = i - 1
            if (nums[i] > nums[prevIndex]) {
                var arr = IntArray(nums.size - prevIndex)

                for (j in arr.indices) {
                    arr[j] = nums[prevIndex]
                    prevIndex++
                }
                arr = arr.sortedArray()
                prevIndex = i - 1
                var index = 0
                var flag = true
                var nextGreater = 0
                while (index <= arr.lastIndex) {
                    if (arr[index] > nums[i - 1] && flag) {
                        nextGreater = arr[index]
                        index++
                        flag = false
                    }
                    if (prevIndex < nums.lastIndex && index < arr.size) {
                        nums[prevIndex + 1] = arr[index]
                    }
                    prevIndex++
                    index++
                }
                nums[i - 1] = nextGreater
                return nums
            }
            if (i - 1 == 0) {
                var arr = nums.sortedArray()
                return nums.sortedArray()
            }
        }
        return nums
    }

    fun optimNextPermutation(nums: IntArray): IntArray {
        var index = nums.lastIndex
        var i = nums.lastIndex

        while (index > 0 && nums[index] <= nums[index - 1]) index--
        index--

        if (index >= 0) {
            while (nums[index] >= nums[i]) i--

            if (nums[i] > nums[index]) {
                val temp = nums[i]
                nums[i] = nums[index]
                nums[index] = temp
            }
        }
        return reverse(nums, index + 1, nums.lastIndex)
    }

    private fun reverse(nums: IntArray, left: Int, right: Int): IntArray {
        var left = left
        var right = right
        while (left < right) {
            var temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
            left++
            right--
        }
        return nums
    }
}