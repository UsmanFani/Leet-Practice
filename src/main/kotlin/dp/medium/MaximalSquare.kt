package dp.medium

class MaximalSquare {
    //Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
    //Example 1:
    //Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
    //Output: 4

    //Example 2:
    //Input: matrix = [["0","1"],["1","0"]]
    //Output: 1

    //Example 3:
    //Input: matrix = [["0"]]
    //Output: 0
    fun maximalSquare(matrix: Array<CharArray>): Int {
        var max = 0
        val dp = Array(matrix.size) { IntArray(matrix[0].size) }
        for (i in matrix.lastIndex downTo 0) {
            for (j in matrix[0].lastIndex downTo 0) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0
                    continue
                }
                dp[i][j] = square(i, j, matrix, dp) + 1
                max = maxOf(max, dp[i][j])
            }
        }
        return max * max
    }

    private fun square(i: Int, j: Int, matrix: Array<CharArray>, dp: Array<IntArray>): Int {
        if (i >= matrix.lastIndex || j >= matrix[0].lastIndex) return 0

        val m1 = if (dp[i + 1][j] != -1) dp[i + 1][j] else matrix[i + 1][j] - '0'
        val m2 = if (dp[i][j + 1] != -1) dp[i][j + 1] else matrix[i][j + 1] - '0'
        val m3 = if (dp[i + 1][j + 1] != -1) dp[i + 1][j + 1] else matrix[i + 1][j + 1] - '0'

        return minOf(m1, m2, m3)

    }
}