package dp.medium

//@author Usman Fani
class UniquePaths {
    //Example 1:
    //Input: m = 3, n = 7
    //Output: 28

    //Example 2:
    //Input: m = 3, n = 2
    //Output: 3
    //Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
    //1. Right -> Down -> Down
    //2. Down -> Down -> Right
    //3. Down -> Right -> Down

    //Top-Down Approach (Recursive+Memoization)
    //O(mn)
    //O(mn)
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m) { IntArray(n) { -1 } }
        return recursivePath(0, 0, m, n, dp)
    }

    private fun recursivePath(row: Int, col: Int, m: Int, n: Int, dp: Array<IntArray>): Int {
        if (row > m - 1 || col > n - 1) return 0
        if (dp[row][col] != -1) return dp[row][col]
        if (row == m - 1 && col == n - 1) return 1
        val path1 = recursivePath(row, col + 1, m, n, dp)
        val path2 = recursivePath(row + 1, col, m, n, dp)
        dp[row][col] = path1 + path2
        return dp[row][col]
    }

    //Bottom-Up Approach (Tabulation)
    //Time = O(mn)
    //Space = O(n)
    fun tabPaths(m: Int, n: Int): Int {
        val currRow = IntArray(n + 1)
        var nextRow = IntArray(n + 1)
        for (row in m - 1 downTo 0) {
            for (col in n - 1 downTo 0) {
                if (row == m - 1 && col == n - 1) {
                    currRow[col] = 1
                    continue
                }
                val path1 = currRow[col + 1]
                val path2 = nextRow[col]
                currRow[col] = path1 + path2
            }
            nextRow = currRow
        }
        return currRow[0]
    }
}