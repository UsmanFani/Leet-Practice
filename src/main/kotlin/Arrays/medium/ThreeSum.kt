package Arrays.medium

class ThreeSum {
    //Example 1:
    //
    //Input: nums = [-1,0,1,2,-1,-4]
    //Output: [[-1,-1,2],[-1,0,1]]

    //Example 2:
    //
    //Input: nums = []
    //Output: []

    //Example 3:
    //
    //Input: nums = [0]
    //Output: []
    fun threeSum(nums: IntArray): List<List<Int>> {
        var sumList = mutableListOf<List<Int>>()
        for (i in 0..nums.lastIndex - 2) {
            for (j in i + 1..nums.lastIndex) {
                for (k in j + 1..nums.lastIndex) {
                    var sum = nums[i] + nums[j] + nums[k]
                    if (sum == 0) {
                        val list = listOf(nums[i], nums[j], nums[k])
                        if (isContainList(sumList, list)) break
                        sumList.add(list)
                    }
                }
            }
        }
        return sumList
    }

    private fun isContainList(list: List<List<Int>>, check: List<Int>): Boolean {
        for (i in list) {
            if (i[0] == check[0]) {
                if (i[1] == check[1]) {
                    if (i[2] == check[2]) return true
                }
                if (i[1] == check[2]) {
                    if (i[2] == check[1]) return true
                }
            }
            if (i[0] == check[1]) {
                if (i[1] == check[0]) {
                    if (i[2] == check[2]) return true
                }
                if (i[1] == check[2]) {
                    if (i[2] == check[0]) return true
                }
            }
            if (i[0] == check[2]) {
                if (i[1] == check[0]) {
                    if (i[2] == check[1]) return true
                }
                if (i[1] == check[1]) {
                    if (i[2] == check[0]) return true
                }
            }
        }
        return false
    }

    fun optimThreeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        var sumList = mutableListOf<List<Int>>()
        var index = 0
        while (index < nums.lastIndex - 1) {
            if (index > 0 && nums[index] == nums[index - 1]) index++
            else {
                var target = 0 - nums[index]
                var list = twoSum(nums, index + 1, target)
                if (list.isNotEmpty()) list.forEach {
                    sumList.add(listOf(nums[index], it[0], it[1]))
                }
                index++
            }
        }
        return sumList
    }

    private fun twoSum(nums: IntArray, index: Int, target: Int): MutableSet<List<Int>> {
        var start = index
        var end = nums.lastIndex
        var list = mutableSetOf<List<Int>>()
        while (end - start > 0) {
            var sum = nums[start] + nums[end]
            if (sum == target) {
                list.add(listOf(nums[start], nums[end]))
                end--
            } else if (sum > target) end--
            else start++
        }
        return list
    }
}