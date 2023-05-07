package Strings.Medium

//@author Usman Fani

//Example 1:
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"

//Example 2:
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//0//P     I    N
//1//A   L S  I G
//2//Y A   H R
//3//P     I

//0//P        H
//1//A      S I
//2//Y    I   R
//3//P  L     I  G
//4//A        N

//1. first or last then (current row) + (numRows-1*2)
//2. for mid rows
// i) (current row) + (numRows-1-row)*2
// ii) (current row) + (numRows-1*2)

class ZigZagConversion() {
    fun convert(s: String, numRows: Int): String {
        if (s.length == numRows || numRows == 1) return s
        val arr = Array(numRows) { CharArray(s.length) { '/' } }
        val res = StringBuilder()
        var row = 0
        var col = 0
        var diag = false
        s.forEach {
            arr[row][col] = it
            if (row == 0) diag = false
            if (row == numRows - 1) diag = true
            if (diag) {
                col++
                row--
            } else {
                row++
            }
        }

        arr.forEach {
            it.forEach {
                if (it != '/') res.append(it)
            }
        }
        return res.toString()
    }

    fun zigzagconvert(s: String, numRows: Int): String {

        if (numRows == 1 || numRows >= s.length) return s

        val res = StringBuilder()
        for (i in 0 until numRows) {
            if (i == 0 || i == numRows - 1) {
                var index = i
                while (index < s.length) {
                    res.append(s[index])
                    index += (numRows - 1) * 2
                }
            } else {
                var index = i
                while (index < s.length) {
                    res.append(s[index])
                    val ind = index + (numRows - 1 - i) * 2
                    if (ind < s.length) res.append(s[ind])
                    index += (numRows - 1) * 2
                }
            }
        }
        return res.toString()
    }

}