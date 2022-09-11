package ProblemOfTheDay

class NumberWithSameConsecutiveDiff {
    //Example 1:
    //Input: n = 3, k = 7
    //Output: [181,292,707,818,929]
    //Explanation: Note that 070 is not a valid number, because it has leading zeroes.

    //Example 2:
    //Input: n = 2, k = 1
    //Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]

    var len = 0
    var diff = 0
    private val result = mutableListOf<Int>()
    fun numsSameConsecDiff(n: Int, k: Int): IntArray {
        len = n
        diff = k
        var i = 1
        while (i <= 9) {
            if (k == 0) {
                getNum(i, i - k, 2)
                i++
            } else if ((i + k) in 0..9 || (i - k) in 0..9) {
                if (i - k in 0..9) {
                    getNum(i, i - k, 2)
                }
                if (i + k in 0..9) {
                    getNum(i, i + k, 2)
                }
                i++
            } else i = k
        }
        return result.toIntArray()
    }

    private fun getNum(nums: Int, lastNum: Int, i: Int) {
        val nums = (nums * 10) + lastNum
        if (i == len) {
            result.add(nums)
        } else {
            if (diff == 0) {
                getNum(nums, lastNum, i + 1)
            } else {
                if (lastNum - diff in 0..9) {
                    getNum(nums, lastNum - diff, i + 1)
                }
                if (lastNum + diff in 0..9) {
                    getNum(nums, lastNum + diff, i + 1)
                }
            }
        }
    }
}