package Arrays.medium

class FourSum {
    //Example 1:
    //Input: nums = [1,0,-1,0,-2,2], target = 0
    //Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

    //Example 2:
    //Input: nums = [2,2,2,2,2], target = 8
    //Output: [[2,2,2,2]]
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        var result = mutableListOf<List<Int>>()
        var prev: Int? = null
        for (i in 0..nums.size - 4) {
            if (i != 0) {
                if (prev == nums[i]) continue
            }
            prev = nums[i]
            var num = target - nums[i]
            var list = threeSum(nums, num, i + 1)
            list.forEach {
                result.add(listOf(nums[i], it[0], it[1], it[2]))
            }
        }
        return result
    }

    fun threeSum(nums: IntArray, target: Int, start: Int): Set<List<Int>> {
        var set = mutableSetOf<List<Int>>()
        var end = nums.size - 3
        var prev: Int? = null
        for (i in start..end) {
            if (i != start) {
                if (prev == nums[i]) continue
            }
            prev = nums[i]
            var num = target.toLong() - nums[i].toLong()
            var list = twoSum(nums, num, i + 1)
            list.forEach {
                set.add(listOf(nums[i], it[0], it[1]))
            }
        }
        return set
    }

    fun twoSum(nums: IntArray, target: Long, start: Int): Set<List<Int>> {
        var list = mutableSetOf<List<Int>>()
        var left = start
        var right = nums.lastIndex
        while (left < right) {
            var sum = nums[left] + nums[right]
            if (sum.toLong() == target) {
                list.add(listOf(nums[left], nums[right]))
                left++
                right--
            } else if (sum > target) right--
            else left++
        }

        return list
    }
}