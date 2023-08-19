package greedy.medium

//@author Usman Fani

//Leetcode: 435

//Example 1:
//Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
//Output: 1
//Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

//Example 2:
//Input: intervals = [[1,2],[1,2],[1,2]]
//Output: 2
//Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.

//Example 3:
//Input: intervals = [[1,2],[2,3]]
//Output: 0
//Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
class EraseOverlapIntervals {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortWith(compareBy({ it[0] }, { it[1] }))
        var index = 0
        var result = 0
        for (i in 1..intervals.lastIndex) {
            if (intervals[i][0] < intervals[index][1]) {
                if (intervals[i][1] <= intervals[index][1]) index = i
                result++
            } else index = i
        }
        return result
    }
}