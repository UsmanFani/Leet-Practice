package Maths.Medium

//@author Usman Fani

//Leetcode-1492

//Example 1:
//Input: n = 12, k = 3
//Output: 3
//Explanation: Factors list is [1, 2, 3, 4, 6, 12], the 3rd factor is 3.

//Example 2:
//Input: n = 7, k = 2
//Output: 7
//Explanation: Factors list is [1, 7], the 2nd factor is 7.

//Example 3:
//Input: n = 4, k = 4
//Output: -1
//Explanation: Factors list is [1, 2, 4], there is only 3 factors. We should return -1.
class KthFactor {
    fun kthFactor(n: Int, k: Int): Int {
        val aList = mutableListOf<Int>()
        val bList = mutableListOf<Int>()
        val last = Math.sqrt(n.toDouble()).toInt()
        for (i in 1..last) {
            if (n % i == 0) {
                aList.add(i)
                val div = n / i
                if (div != i) bList.add(div)
            }
            if (k == aList.size) return i
        }
        if (k > aList.size + bList.size) return -1

        val index = k - aList.size
        return bList[bList.size - index]
    }
}