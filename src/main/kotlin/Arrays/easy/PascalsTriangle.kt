package Arrays.easy

class PascalsTriangle {
    //Example 1:
    //
    //Input: numRows = 5
    //Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

    //Example 2:
    //
    //Input: numRows = 1
    //Output: [[1]]
    fun generate(numRows: Int): List<List<Int>> {
        var pascalList = MutableList(numRows) { MutableList(it + 1) { 1 } }

        for (i in 2 until numRows) {
            for (j in 1 until i) {
                pascalList[i][j] = pascalList[i - 1][j - 1] + pascalList[i - 1][j]
            }
        }
        return pascalList
    }
}