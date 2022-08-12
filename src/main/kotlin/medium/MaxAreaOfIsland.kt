package medium

class MaxAreaOfIsland {
    //Example 1:
    //Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
    //Output: 6
    //Explanation: The answer is not 11, because the island must be connected 4-directionally.

    //Example 2:
    //Input: grid = [[0,0,0,0,0,0,0,0]]
    //Output: 0
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var maxArea = 0
        var visited = mutableSetOf<List<Int>>()
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (visited.contains(listOf(i, j))) continue
                maxArea = maxOf(maxArea, dfs(grid, i, j, visited))
            }
        }
        return maxArea
    }

    fun dfs(grid: Array<IntArray>, row: Int, col: Int, visited: MutableSet<List<Int>>): Int {
        if (row < 0 || col < 0 || row > grid.lastIndex || col > grid[0].lastIndex) return 0
        if (visited.contains(listOf(row, col))) return 0
        visited.add(listOf(row, col))
        if (grid[row][col] == 0) {
            return 0
        }

        var a = dfs(grid, row + 1, col, visited)
        var b = dfs(grid, row - 1, col, visited)
        var c = dfs(grid, row, col + 1, visited)
        var d = dfs(grid, row, col - 1, visited)
        return a + b + c + d + 1
    }
}