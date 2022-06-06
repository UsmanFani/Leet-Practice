package medium

import kotlin.math.max

class `Ones&Zeroes` {
    //Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
    //Output: 4
    //Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
    //Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
    //{"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.

    //Input: strs = ["10","0","1"], m = 1, n = 1
    //Output: 2
    //Explanation: The largest subset is {"0", "1"}, so the answer is 2.
    fun findMaxForm(str: Array<String>, m: Int, n: Int, index: Int = 0): Int {
        var size = 0
        var zero = 0
        var one = 0
        if(m<=0&&n<=0) return 0
        for (i in index until str.size) {
            for (j in str[i].indices) {
                if (j == 0) zero++
                else one++
            }
            if (m - zero >= 0 && n - one >= 0) {
                size++
            }
            size = max(findMaxForm(str,m-zero,n-one,i),size)
        }
        return size
    }
}