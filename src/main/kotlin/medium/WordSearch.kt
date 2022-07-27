package medium

class WordSearch {
    //Example 1:
    //Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    //Output: true

    //Example 2:
    //Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
    //Output: true

    //Example 3:
    //Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
    //Output: false
    fun exist(board: Array<CharArray>, word: String): Boolean {
        var rows = board.lastIndex
        var cols = board[0].lastIndex
        var hash = mutableSetOf<List<Int>>()
        fun dfs(row: Int, col: Int, w: Int): Boolean {
            var arr = listOf(row, col)
            if (w == word.length) return true
            if (row < 0 || row > rows || col < 0 || col > cols || board[row][col] != word[w]
                || hash.contains(arr)
            ) return false

            hash.add(arr)
            var result = (dfs(row, col + 1, w + 1) ||
                    dfs(row, col - 1, w + 1) ||
                    dfs(row + 1, col, w + 1) ||
                    dfs(row - 1, col, w + 1))
            hash.remove(arr)

            return result
        }

        for (i in 0..rows) {
            for (j in 0..cols) {
                if (dfs(i, j, 0)) return true
            }
        }

        return false
    }

    fun optimExist(board: Array<CharArray>, word: String): Boolean {
        var rows = board.lastIndex
        var cols = board[0].lastIndex


        for (i in 0..rows) {
            for (j in 0..cols) {
                if (dfs(board, word, i, j, 0)) return true
            }
        }

        return false
    }

    fun dfs(board: Array<CharArray>, word: String, row: Int, col: Int, w: Int): Boolean {
        var rows = board.lastIndex
        var cols = board[0].lastIndex
        if (w == word.length) return true
        if (row < 0 || row > rows || col < 0 || col > cols || board[row][col] != word[w]
        ) return false


        if(board[row][col]==word[w]){
            board[row][col] = '#'
            var result = (dfs(board, word, row, col + 1, w + 1) ||
                    dfs(board, word, row, col - 1, w + 1) ||
                    dfs(board, word, row + 1, col, w + 1) ||
                    dfs(board, word, row - 1, col, w + 1))
            board[row][col] = word[w]
            return result
        }else return false
    }
}