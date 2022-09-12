package Arrays.easy

class MergeSortedArray {
    //Example 1:
    //
    //Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    //Output: [1,2,2,3,5,6]
    //Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
    //The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

    //Example 2:
    //
    //Input: nums1 = [1], m = 1, nums2 = [], n = 0
    //Output: [1]
    //Explanation: The arrays we are merging are [1] and [].
    //The result of the merge is [1].

    //Example 3:
    //
    //Input: nums1 = [0], m = 0, nums2 = [1], n = 1
    //Output: [1]
    //Explanation: The arrays we are merging are [] and [1].
    //The result of the merge is [1].
    //Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var a = 0
        var b = 0
        var temp = IntArray(m + n)
        if (m == 0) {
            nums1.indices.forEach {
                nums1[it] = nums2[it]
            }
        } else {
            for (i in nums1.indices) {
                if (a >= m && b < n) {
                    temp[i] = nums2[b]
                    b++
                } else if (a < m && b >= n) {
                    temp[i] = nums1[a]
                    a++
                } else {
                    if (nums1[a] <= nums2[b] && a < m) {
                        temp[i] = nums1[a]
                        a++
                    } else {
                        temp[i] = nums2[b]
                        b++
                    }
                }
            }
            nums1.indices.forEach {
                nums1[it] = temp[it]
            }
        }

        println(nums1.asList())
    }
}