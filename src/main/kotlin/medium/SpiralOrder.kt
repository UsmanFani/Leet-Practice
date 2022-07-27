package medium

class SpiralOrder {
    //Example 1:
    //1 -> 2 -> 3
    //          ↓
    //4 -> 5    6
    //↑         ↓
    //7 <- 8 <- 9
    //Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    //Output: [1,2,3,6,9,8,7,4,5]

    //Example 2:
    //Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
    //Output: [1,2,3,4,8,12,11,10,9,5,6,7]
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var list = mutableListOf<Int>()
        var size = (matrix[0].size) * (matrix.size)
        var col = 0
        var row = 0
        var maxRow = matrix.lastIndex
        var maxCol = matrix[0].lastIndex
        var minRow = 1
        var minCol = 0
        var flagRow = true
        var flagCol = true
        for (i in 0 until size) {
            if (col < maxCol && flagCol) {
                list.add(matrix[row][col])
                col++
            } else if (col == maxCol && row == minRow - 1) {
                list.add(matrix[row][col])
                maxCol--
                row++
                flagCol = false
            } else if (row < maxRow && flagRow) {
                list.add(matrix[row][col])
                row++
            } else if (row == maxRow && col == maxCol + 1) {
                list.add(matrix[row][col])
                maxRow--
                col--
                flagRow = false
            } else if (col > minCol) {
                list.add(matrix[row][col])
                col--
            } else if (col == minCol && row == maxRow + 1) {
                list.add(matrix[row][col])
                minCol++
                row--
            } else if (row > minRow) {
                list.add(matrix[row][col])
                row--
            } else if (row == minRow && col == minCol - 1) {
                list.add(matrix[row][col])
                minRow++
                col++
                flagCol = true
                flagRow = true
            }
        }
        return list
    }

    fun optimSpiralOrder(matrix: Array<IntArray>): List<Int> {
        var list = mutableListOf<Int>()
        var left = 0
        var right = matrix[0].lastIndex
        var top = 0
        var bottom = matrix.lastIndex
        while (left <= right && top <= bottom) {
            if (left <= right && top <= bottom) {
                for (i in left..right) {
                    list.add(matrix[top][i])
                }
                top++
            }
            if (left <= right && top <= bottom) {
                for (i in top..bottom) {
                    list.add(matrix[i][right])
                }
                right--
            }
            if (left <= right && top <= bottom) {
                for (i in right downTo left) {
                    list.add(matrix[bottom][i])
                }
                bottom--
            }

            if (left <= right && top <= bottom) {
                for (i in bottom downTo top) {
                    list.add(matrix[i][left])
                }
                left++
            }
        }
        return list

    }
}