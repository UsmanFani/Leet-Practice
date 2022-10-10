package dp.medium

class MaxLengthOfRepeatedSubarray {
    //Example 1:
    //Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
    //Output: 3
    //Explanation: The repeated subarray with maximum length is [3,2,1].

    //Explanation: The repeated subarray with maximum length is [0,0,0,0,0].

    //Example 2:
    //Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
    //Output: 5

    fun findLength(nums1: IntArray, nums2: IntArray): Int {
        var max = 0
        for (i in nums1.indices) {

            var n1Index = 0
            var n2Index = 0
            var tempMax = 0
            for (j in nums2.indices) {
                if (nums1[i] == nums2[j]) {
                    n1Index = i
                    n2Index = j
                    while (n1Index <= nums1.lastIndex && n2Index <= nums2.lastIndex && nums1[n1Index] == nums2[n2Index]) {
                        tempMax++
                        n1Index++
                        n2Index++
                    }
                    max = maxOf(max, tempMax)
                    tempMax = 0
                }
            }
        }
        return max
    }

    //Top-Down approach (Recursive)
    //Time: O(2^n)
    var max = 0
    fun recursiveFindLength(nums1: IntArray, nums2: IntArray): Int {
        val dp = Array(nums1.size) { IntArray(nums2.size) { -1 } }
        find(nums1.lastIndex, nums2.lastIndex, nums1, nums2, dp)
        return max
    }

    private fun find(index1: Int, index2: Int, nums1: IntArray, nums2: IntArray, dp: Array<IntArray>): Int {
        if (index1 < 0 || index2 < 0) return 0
        if (dp[index1][index2] != -1) return dp[index1][index2]
        var len = 0
        if (nums1[index1] == nums2[index2]) {
            len = 1 + find(index1 - 1, index2 - 1, nums1, nums2, dp)
            //dp[index1][index2] = len
            max = maxOf(max, len)
        }
        find(index1 - 1, index2, nums1, nums2, dp)
        find(index1, index2 - 1, nums1, nums2, dp)
        dp[index1][index2] = len
        return len
    }

    //Bottom UP approach (Tabulation)
    // Time: O(n*m)
    // Space: O(n*m)
    fun optimFindLength(nums1: IntArray, nums2: IntArray): Int {

        val dp = Array(nums1.size + 1) { IntArray(nums2.size + 1) }
        var max = 0
        for (i in nums1.indices) {
            for (j in nums2.indices) {
                if (nums1[i] == nums2[j]) {
                    dp[i + 1][j + 1] = 1 + dp[i][j]
                    max = maxOf(max, dp[i + 1][j + 1])
                }
            }
        }
        return max
    }
}