package easy

class SearchInsert {
    //Example 1:
    //Input: nums = [1,3,5,6], target = 5
    //Output: 2

    //Example 2:
    //Input: nums = [1,3,5,6], target = 2
    //Output: 1

    //Example 3:
    //Input: nums = [1,3,5,6], target = 7
    //Output: 4
    fun searchInsert(nums: IntArray, target: Int): Int {
        var startIndex = 0
        var endIndex = nums.size
        if (target < nums[0]) return 0
        for (i in startIndex..endIndex) {
            var mid = (startIndex + endIndex) / 2
            if (nums[mid] == target) return mid
            if (endIndex - startIndex == 1) {
                return if (target > nums[startIndex]) startIndex + 1
                else startIndex - 1
            }
            if (target > nums[mid]) startIndex = mid
            else endIndex = mid
        }
        return endIndex
    }
}