package medium

class GameOfLife {
    //Example 1:
    //0  1  0         0  0  0
    //0  0  1   =>    1  0  1
    //1  1  1         0  1  1
    //0  0  0         0  1  0
    //
    //Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
    //Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

    //Example 2:
    //1  1  =>  1  1
    //1  0      1  1
    //
    //Input: board = [[1,1],[1,0]]
    //Output: [[1,1],[1,1]]

    //1-alive, 0-died
    //rules (applying Simultaneously)
    //if 1 has <2 1's it dies(1=>0)
    //if 1 has 2-3 1's it lives
    //if 1 has >3 1's it dies
    //if 0 has ==3 1's it 0=>1

    fun gameOfLife(board: Array<IntArray>): Array<IntArray> {
        var matrix = Array(board.size){ IntArray(board[0].size) }
        for (i in board.indices){
            for (j in board[0].indices){
                matrix[i][j] = board[i][j]
            }
        }
        for (i in board.indices) {
            for (j in board[0].indices) {
                val ones = dfs(matrix, intArrayOf(i, j))
                if (board[i][j] == 0) {
                    if (ones == 3) board[i][j] = 1
                } else {
                    if (ones < 2 || ones > 3) board[i][j] = 0
                }
            }
        }
        return board
    }

    //00 01 02
    //10    12
    //20 21 22
    private fun dfs(board: Array<IntArray>, index: IntArray): Int {
        var ones = 0

        for (i in index[0] - 1..index[0] + 1) {
            if (i < 0 || i > board.lastIndex) continue
            for (j in index[1] - 1..index[1] + 1) {
                if (j < 0 || j > board[0].lastIndex) continue
                if (ones > 3) return ones
                if (i == index[0] && j == index[1]) continue
                else {
                    if (board[i][j] == 1) ones++
                }
            }
        }
        return ones
    }
}