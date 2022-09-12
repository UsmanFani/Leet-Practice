package Arrays.medium

class FindPairs {
    //Example 1:
    //Input: nums = [3,1,4,1,5], k = 2
    //Output: 2
    //Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
    //Although we have two 1s in the input, we should only return the number of unique pairs.

    //Example 2:
    //Input: nums = [1,2,3,4,5], k = 1
    //Output: 4
    //Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).

    //Example 3:
    //Input: nums = [1,3,1,5,4], k = 0
    //Output: 1
    //Explanation: There is one 0-diff pair in the array, (1, 1).
    fun findPairs(nums: IntArray, k: Int): Int {
        var pairs = 0
        nums.sort()
        var left = 0
        var right = 1
        while (right <= nums.lastIndex) {
            val diff = nums[right] - nums[left]
            if (k == 0) {
                if (left > 0 && nums[left] == nums[left - 1] && nums[right] == nums[right - 1]) {
                    left++
                    right++
                } else if (diff == k) {
                    pairs++
                    left++
                    right++
                } else if (diff > k) {
                    left++
                    right++
                } else {
                    left++
                    right++
                }
            } else {
                if (left > 0) {
                    if (nums[left] == nums[left - 1] && nums[right] == nums[right - 1]) {
                        left++
                        right++
                        continue
                    }
                }
                if (diff == k) {
                    pairs++
                    left++
                    right++
                } else if (diff < k) {
                    right++
                } else {
                    left++
                }
            }
        }
        return pairs
    }
}