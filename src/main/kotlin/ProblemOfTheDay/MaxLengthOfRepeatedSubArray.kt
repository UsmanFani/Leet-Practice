package ProblemOfTheDay

class MaxLengthOfRepeatedSubArray {
    //Example 1:
    //Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
    //Output: 3
    //Explanation: The repeated subarray with maximum length is [3,2,1].

    //Example 2:
    //Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
    //Output: 5
    fun findLength(nums1: IntArray, nums2: IntArray): Int {
        var maxSub = 0
        for (i in nums1.indices) {
            var max = 0
            var nums1Index = i
            var nums2Index = 0
            var start = 0
            if (maxSub > nums1.lastIndex - i) return maxSub
            while (nums1Index in nums1.indices && nums2Index in nums2.indices) {
                if (nums1[nums1Index] == nums2[nums2Index]) {
                    max++
                    nums1Index++
                    nums2Index++
                } else {
                    maxSub = maxOf(maxSub, max)
                    max = 0
                    nums1Index = i
                    start++
                    nums2Index = start
                }
            }
            maxSub = maxOf(maxSub, max)
        }
        return maxSub
    }
}