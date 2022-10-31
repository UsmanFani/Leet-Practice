package dp.medium

//@author Usman Fani
class LongestIncreasingSubsequence {
    //Example 1:
    //Input: nums = [10,9,2,5,3,7,101,18]
    //Output: 4
    //Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

    //Example 2:
    //Input: nums = [0,1,0,3,2,3]
    //Output: 4

    //Example 3:
    //Input: nums = [7,7,7,7,7,7,7]
    //Output: 1

    //Top-Down Approach (Recursive + Memoization)
    //O(n^2)
    //O(n^2)
    fun lengthOfLIS(nums: IntArray): Int {
        val dp = Array(nums.size) { IntArray(nums.size) { -1 } }
        return lis(0, -1, nums, dp)
    }

    private fun lis(currIndex: Int, prevIndex: Int, nums: IntArray, dp: Array<IntArray>): Int {
        if (currIndex > nums.lastIndex) return 0
        if (dp[currIndex][prevIndex + 1] != -1) return dp[currIndex][prevIndex + 1]
        val len1 = lis(currIndex + 1, prevIndex, nums, dp)

        var len2 = 0
        if (prevIndex == -1 || nums[currIndex] > nums[prevIndex]) {
            len2 = 1 + lis(currIndex + 1, currIndex, nums, dp)
        }
        dp[currIndex][prevIndex + 1] = maxOf(len1, len2)
        return dp[currIndex][prevIndex + 1]
    }

    //Bottom-Up Approach (Tabulation)
    //O(n^2)
    //O(n)
    fun tabLis(nums: IntArray): Int {
        val currRow = IntArray(nums.size + 1)
        var nextRow = IntArray(nums.size + 1)
        for (currIndex in nums.lastIndex downTo 0) {
            for (prevIndex in currIndex - 1 downTo -1) {
                val len1 = nextRow[prevIndex + 1]
                var len2 = 0
                if (prevIndex == -1 || nums[currIndex] > nums[prevIndex]) {
                    len2 = 1 + nextRow[currIndex + 1]
                }
                currRow[prevIndex + 1] = maxOf(len1, len2)
            }
            nextRow = currRow
        }
        return currRow[0]
    }

    //Greedy + Binary Search
    //O(nlogn)
    //O(n)
    fun optimLIS(nums: IntArray): Int {
        val list = mutableListOf<Int>()
        list.add(nums[0])
        for (i in 1..nums.lastIndex) {
            if (list.last() < nums[i]) list.add(nums[i])
            else {
                val index = binarySearch(list, nums[i])
                list[index] = nums[i]
            }
        }
        return list.size
    }

    private fun binarySearch(list: MutableList<Int>, num: Int): Int {
        var start = 0
        var end = list.size
        var mid: Int
        while (start < end) {
            mid = (start + end) / 2
            if (num > list[mid]) {
                start = mid + 1
            } else {
                end = mid
            }
        }
        return if (start > list.lastIndex) list.lastIndex else start
    }
}