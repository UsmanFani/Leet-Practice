package dp.medium

//@author Usman Fani
//Leetcode:304

class RangeSumQueryMatrix(matrix: Array<IntArray>) {

    private var sumMatrix = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) }

    init {
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (j > 0) matrix[i][j] += matrix[i][j - 1]
                sumMatrix[i + 1][j + 1] = matrix[i][j] + sumMatrix[i][j + 1]
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return sumMatrix[row2 + 1][col2 + 1] - (sumMatrix[row2 + 1][col1] + sumMatrix[row1][col2 + 1]) + sumMatrix[row1][col1]
    }
}