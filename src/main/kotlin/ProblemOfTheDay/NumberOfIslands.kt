package ProblemOfTheDay

class NumberOfIslands {
    //Example 1:
    //Input: grid = [
    //  ["1","1","1","1","0"],
    //  ["1","1","0","1","0"],
    //  ["1","1","0","0","0"],
    //  ["0","0","0","0","0"]
    //]
    //Output: 1

    //Example 2:
    //Input: grid = [
    //  ["1","1","0","0","0"],
    //  ["1","1","0","0","0"],
    //  ["0","0","1","0","0"],
    //  ["0","0","0","1","1"]
    //]
    //Output: 3
    fun numIslands(grid: Array<CharArray>): Int {
        var num = 0

        fun dfs(row: Int, col: Int): Boolean {
            if (row < 0 || col < 0 || row > grid.lastIndex || col > grid[0].lastIndex) return false
            if (grid[row][col] == '0') return false
            grid[row][col] = '0'
            dfs(row, col - 1)
            dfs(row, col + 1)
            dfs(row - 1, col)
            dfs(row + 1, col)
            return false
        }

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == '0') continue
                dfs(i, j)
                num++
            }
        }
        return num
    }
}