package Arrays.medium

class MergeIntervals {
    //Example 1:
    //
    //Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    //Output: [[1,6],[8,10],[15,18]]
    //Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

    //Example 2:
    //
    //Input: intervals = [[1,4],[4,5]]
    //Output: [[1,5]]
    //Explanation: Intervals [1,4] and [4,5] are considered overlapping.

    fun mergeIntervals(intervals: Array<IntArray>): Array<IntArray> {
        var start = 0
        var end = 0
        intervals.sortBy { it[0] }
        for (i in 0..intervals.lastIndex) {
            if (intervals[end][1] <= intervals[start][1] && intervals[end][1] >= intervals[start][0]) {
                intervals[start] = intArrayOf(
                    minOf(intervals[start][0], intervals[end][0]),
                    maxOf(intervals[start][1], intervals[end][1])
                )
                end++
            } else if (intervals[end][0] <= intervals[start][1] && intervals[end][0] >= intervals[start][0]) {
                intervals[start] = intArrayOf(
                    minOf(intervals[start][0], intervals[end][0]),
                    maxOf(intervals[start][1], intervals[end][1])
                )
                end++
            }
            else {
                ++start
                intervals[start] = intervals[end]
                end++
            }
        }
        var arr = Array(start + 1) { IntArray(2) }
        for (i in 0..start) {
            arr[i] = intervals[i]
        }
        return arr
    }

}