import contest.biweekly.MinimizeArrayValue
import dp.medium.KnightDialer
import dp.medium.LongestIncreasingSubsequence
import dp.medium.RangeSumQueryMatrix
import dp.medium.UniquePaths

fun main() {

    var matrix = arrayOf(
        intArrayOf(3, 0, 1, 4, 2),
        intArrayOf(5, 6, 3, 2, 1),
        intArrayOf(1, 2, 0, 1, 5),
        intArrayOf(4, 1, 0, 1, 7),
        intArrayOf(1, 0, 3, 0, 5)
    )
    var sum = RangeSumQueryMatrix(matrix)
    println(sum.sumRegion(2, 1, 4, 3))
}

