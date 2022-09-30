package dp.medium

class MaximumProductSubarray {
    fun maxProduct(nums: IntArray): Int {
        val dp = Array(nums.size) { IntArray(nums.size) { -1 } }
        return product(nums[0], 0, 0, nums, dp)
    }

    private fun product(mult: Int, start: Int, end: Int, nums: IntArray, dp: Array<IntArray>): Int {
        if (dp[start][end] != -1) return dp[start][end]
        if (end == nums.lastIndex) {
            dp[start][end] = mult
            return mult
        }
        val product1 = product(mult * nums[end + 1], start, end + 1, nums, dp)
        val product2 = product(nums[end + 1], end + 1, end + 1, nums, dp)
        dp[start][end] = maxOf(mult, product1, product2)
        return dp[start][end]
    }

    fun optimMaxProduct(nums: IntArray): Int {
        var max = Int.MIN_VALUE
        var product = 1
        for (i in 0..nums.lastIndex) {
            product *= nums[i]
            max = maxOf(max, product, nums[i])
            if (product == 0) product = 1
        }
        product = 1
        for (i in nums.lastIndex downTo 0) {
            product *= nums[i]
            max = maxOf(max, product)
            if (product == 0) product = 1
        }
        return max
    }

    fun moreOptimMaxProduct(nums: IntArray): Int {
        var max = 1
        var min = 1
        var maxPro = Int.MIN_VALUE

        for (i in 0..nums.lastIndex) {
            val tempMax = maxOf(nums[i] * max, nums[i] * min, nums[i])
            val tempMin = minOf(nums[i] * max, nums[i] * min, nums[i])

            max = tempMax
            min = tempMin
            maxPro = maxOf(max, maxPro)
            if (max == 0) max = 1
            if (min == 0) min = 1
        }
        return maxPro
    }
}