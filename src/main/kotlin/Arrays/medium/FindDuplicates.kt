package Arrays.medium

import kotlin.math.abs

class FindDuplicates {
    //Example 1:
    //Input: nums = [4,3,2,7,8,2,3,1]
    //Output: [2,3]

    //Example 2:
    //Input: nums = [1,1,2]
    //Output: [1]

    //Example 3:
    //Input: nums = [1]
    //Output: []
    fun findDuplicates(nums: IntArray): List<Int> {
        var dupliList = mutableSetOf<Int>()
        var map = mutableMapOf<Int, Int>()
        for (i in nums) {
            if (map.containsKey(i)) {
                map[i] = map[i]!! + 1
                if (map[i]!! > 1) dupliList.add(i)
            } else map[i] = 1
        }
        return dupliList.toList()
    }

    fun optimFindDuplicates(nums: IntArray): List<Int> {
        var list = mutableListOf<Int>()
        for (i in nums) {
            val index = if(i<0) -i else i
            if (nums[index-1] < 0) list.add(index)
            else nums[index-1] = -nums[index-1]
        }
        return list
    }
}