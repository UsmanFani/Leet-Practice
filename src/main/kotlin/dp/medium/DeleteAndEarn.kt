package dp.medium

class DeleteAndEarn {
    //Example 1:
    //Input: nums = [3,4,2]
    //Output: 6
    //Explanation: You can perform the following operations:
    //- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
    //- Delete 2 to earn 2 points. nums = [].
    //You earn a total of 6 points.

    //Example 2:
    //Input: nums = [2,2,3,3,3,4]
    //Output: 9
    //Explanation: You can perform the following operations:
    //- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
    //- Delete a 3 again to earn 3 points. nums = [3].
    //- Delete a 3 once more to earn 3 points. nums = [].
    //You earn a total of 9 points.
    fun deleteAndEarn(nums: IntArray): Int {
        val list = mutableListOf<Int>()
        val map = mutableMapOf<Int, Int>()
        for (i in nums) {
            if (map.containsKey(i)) {
                map[i] = map[i]!! + 1
            } else {
                list.add(i)
                map[i] = 1
            }
        }
        list.sort()
        if (list.size == 1) return list[0] * map[list[0]]!!

        var twoBack = list[0] * map[list[0]]!!
        var oneBack = if (list[1] - 1 == list[0]) {
            maxOf(twoBack, list[1] * map[list[1]]!!)
        } else twoBack + (list[1] * map[list[1]]!!)

        for (i in 2..list.lastIndex) {
            if ((list[i] - 1) == list[i - 1]) {
                var sum = (list[i] * map[list[i]]!!) + twoBack
                sum = maxOf(oneBack, sum)
                twoBack = oneBack
                oneBack = sum
            } else {
                twoBack = oneBack
                oneBack += list[i] * map[list[i]]!!
            }
        }
        return oneBack
    }

}