package dp.medium

//@author Usman Fani
class CountSquareSubmatricesWithAllOne {
    //Example 1:
    //Input: matrix =
    //[
    //  [0,1,1,1],
    //  [1,1,1,1],
    //  [0,1,1,1]
    //]
    //Output: 15
    //Explanation:
    //There are 10 squares of side 1.
    //There are 4 squares of side 2.
    //There is  1 square of side 3.
    //Total number of squares = 10 + 4 + 1 = 15.

    //Example 2:
    //Input: matrix =
    //[
    //  [1,0,1],
    //  [1,1,0],
    //  [1,1,0]
    //]
    //Output: 7
    //Explanation:
    //There are 6 squares of side 1.
    //There is 1 square of side 2.
    //Total number of squares = 6 + 1 = 7.

    //Bottom-Up Approach (Tabulation)
    //O(mn)
    //O(1)
    fun countSquares(matrix: Array<IntArray>): Int {
        var max = 0
        for (m in matrix.lastIndex downTo 0) {
            for (n in matrix[0].lastIndex downTo 0) {
                if (matrix[m][n] != 0) {
                    if (m < matrix.lastIndex && n < matrix[0].lastIndex) {
                        matrix[m][n] = 1 + minOf(minOf(matrix[m + 1][n], matrix[m][n + 1]), matrix[m + 1][n + 1])
                    }
                    max += matrix[m][n]
                }
            }
        }
        return max
    }
}