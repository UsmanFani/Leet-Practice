package dp.easy

class CountingBits {
    //Example 1:
    //Input: n = 2
    //Output: [0,1,1]
    //Explanation:
    //0 --> 0
    //1 --> 1
    //2 --> 10

    //Example 2:
    //Input: n = 5
    //Output: [0,1,1,2,1,2]
    //Explanation:
    //0 --> 0
    //1 --> 1
    //2 --> 10
    //3 --> 11
    //4 --> 100
    //5 --> 101
    fun countBits(n: Int): IntArray {
        val countArr = IntArray(n + 1)
        for (i in 0..n) {
            countArr[i] = countOneBits(i)
        }
        return countArr
    }

    private fun countOneBits(n: Int): Int {
        if (n == 0) return 0
        if (n == 1) return 1
        var ones = 0
        ones += n % 2
        var div = n
        while (div != 1) {
            div /= 2
            if (div > 2) ones += div % 2
        }
        ones++

        return ones
    }

//O(n)
    fun optimCountBits(n: Int): IntArray {
        val dp = IntArray(n+1)
        var msb = 1
        for (i in 1..n) {
            if (i == msb * 2) msb *= 2
            dp[i] = 1 + dp[i - msb]
        }
        return dp
    }
}