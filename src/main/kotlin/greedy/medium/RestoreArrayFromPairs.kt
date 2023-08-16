package greedy.medium

//@author Usman Fani

//Leetcode: 1743

//Example 1:
//Input: adjacentPairs = [[2,1],[3,4],[3,2]]
//Output: [1,2,3,4]
//Explanation: This array has all its adjacent pairs in adjacentPairs.
//Notice that adjacentPairs[i] may not be in left-to-right order.

//Example 2:
//Input: adjacentPairs = [[4,-2],[1,4],[-3,1]]
//Output: [-2,4,1,-3]
//Explanation: There can be negative numbers.
//Another solution is [-3,1,4,-2], which would also be accepted.

//Example 3:
//Input: adjacentPairs = [[100000,-100000]]
//Output: [100000,-100000]
class RestoreArrayFromPairs {
    fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
        val pairMap = mutableMapOf<Int, MutableList<Int>>()
        if (adjacentPairs.size == 1) {
            return intArrayOf(adjacentPairs[0][0], adjacentPairs[0][1])
        }

        val res = IntArray(adjacentPairs.size+1)

        adjacentPairs.forEach {
            if (pairMap.containsKey(it[0])) pairMap[it[0]]!!.add(it[1])
            else pairMap[it[0]] = mutableListOf(it[1])

            if (pairMap.containsKey(it[1])) pairMap[it[1]]!!.add(it[0])
            else pairMap[it[1]] = mutableListOf(it[0])

        }

        for (it in pairMap) {
            if (it.value.size == 1) {
                res[0] = it.key
                res[1] = it.value[0]
                break
            }
        }

        var i = 1
        while (i < res.lastIndex) {
            val pair = pairMap[res[i]]!!
            if (pair[0] != res[i-1]) {
                i++
                res[i] = pair[0]
            } else {
                i++
                res[i] = pair[1]
            }
        }
        return res
    }
}