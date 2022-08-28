package medium

class SubArrayDivByK {
    //Example 1:
    //Input: nums = [4,5,0,-2,-3,1], k = 5
    //Output: 7
    //Explanation: There are 7 subarrays with a sum divisible by k = 5:
    //[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

    //Example 2:
    //Input: nums = [5], k = 9
    //Output: 0
    fun subarraysDivByK(nums: IntArray, k: Int): Int {
        var count = 0
        for (i in 0..nums.lastIndex) {
            if (nums[i] % k == 0) count++
            var sum = nums[i]
            for (j in i + 1..nums.lastIndex) {
                sum += nums[j]
                if (sum % k == 0) count++
            }
        }
        return count
    }

    fun optimSubArraysDivByK(nums: IntArray, k: Int): Int {
        var count = 0
        val map = mutableMapOf<Int, Int>()
        map[0] = 1
        var sum = 0
        for (i in nums.indices) {
            sum += nums[i]
            var rem = sum % k
            if (rem < 0) rem += k
            if (map.containsKey(rem)) {
                count += map[rem]!!
                map[rem] = map[rem]!! + 1
            } else map[rem] = 1
        }
        return count
    }
}