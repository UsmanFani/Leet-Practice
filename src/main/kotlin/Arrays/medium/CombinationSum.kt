package Arrays.medium

import java.util.Stack

class CombinationSum {
    //Example 1:
    //Input: candidates = [2,3,6,7], target = 7
    //Output: [[2,2,3],[7]]
    //Explanation:
    //2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
    //7 is a candidate, and 7 = 7.
    //These are the only two combinations.

    //Example 2:
    //Input: candidates = [2,3,5], target = 8
    //Output: [[2,2,2,2],[2,3,3],[3,5]]

    //Example 3:
    //Input: candidates = [2], target = 1
    //Output: []
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        var combinationList = mutableListOf<List<Int>>()
        fun dfs(index: Int, list: MutableList<Int>, total: Int) {
            if (total == target) {
                var tempList = mutableListOf<Int>()
                list.forEach {
                    tempList.add(it)
                }
                combinationList.add(tempList)
                return
            }
            if (index >= candidates.size || total > target) {
                return
            }
            list.add(candidates[index])
            dfs(index, list, total + candidates[index])
            list.removeAt(list.lastIndex)
            dfs(index + 1, list, total)
        }

        val list = mutableListOf<Int>()
        dfs(0, list, 0)
        return combinationList
    }
}