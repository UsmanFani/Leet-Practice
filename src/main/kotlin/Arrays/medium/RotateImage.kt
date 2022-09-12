package Arrays.medium

class RotateImage {
    //Example 1:
    // 1  2  3        7  4  1
    // 4  5  6        8  5  2
    // 7  8  9        9  6  3
    //Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    //Output: [[7,4,1],[8,5,2],[9,6,3]]

    //Example 2:
    // 5  1  9  11      15  13  2  5
    // 2  4  8  10      14  3   4  1
    // 13  3  6  7      12  6   8  9
    // 15 14 12 16      16  7  10  11
    //Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
    //Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
    fun rotate(matrix: Array<IntArray>): Array<IntArray> {
        var start = 0
        var last = matrix.lastIndex
        while (start<last){
            rotateImage(matrix,start, last)
            start++
            last--
        }
        return matrix
    }

    fun rotateImage(matrix:Array<IntArray>,start:Int,last:Int):Array<IntArray>{
        var inc = 0
        for (i in start until last) {
            var temp1 = matrix[i][last]
            matrix[i][last] = matrix[start][start + inc]
            var temp2 = matrix[last][last - inc]
            matrix[last][last - inc] = temp1
            temp1 = matrix[last - inc][start]
            matrix[last - inc][start] = temp2
            matrix[start][start + inc] = temp1
            inc++
        }
        return matrix
    }
}