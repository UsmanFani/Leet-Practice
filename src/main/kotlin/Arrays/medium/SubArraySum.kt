package Arrays.medium

class SubArraySum {
    //Example 1:
    //
    //Input: nums = [1,1,1], k = 2
    //Output: 2

    //Example 2:
    //
    //Input: nums = [1,2,3], k = 3
    //Output: 2

    //[1,2,-1,3], k = 2
    //Output: 3

    fun subArraySum(nums: IntArray, k: Int): Int {
        var subArr = 0
        for (i in 0 until nums.lastIndex) {
            var sum = nums[i]
            if (nums[i] == k) subArr += 1
            for (j in i + 1..nums.lastIndex) {
                sum += nums[j]
                if (sum == k) subArr += 1
            }
        }
        if (nums[nums.lastIndex] == k) subArr += 1
        return subArr
    }

    fun optimSubArray(nums: IntArray, k: Int): Int {
        var res = 0
        var sum = 0
        val map = mutableMapOf<Int, Int>()
        map.putIfAbsent(0, 1)
        for (i in nums.indices) {
            sum += nums[i]
            val diff = sum - k
            if (map.containsKey(diff)) res += map[diff]!!
            if (map.containsKey(sum)) {
                map[sum] = map[sum]!! + 1
            } else {
                map[sum] = 1
            }
        }
        return res
    }
}