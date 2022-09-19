package dp.easy

class ClimbingStairs {
    //Example 1:
    //Input: n = 2
    //Output: 2
    //Explanation: There are two ways to climb to the top.
    //1. 1 step + 1 step
    //2. 2 steps

    //Example 2:
    //Input: n = 3
    //Output: 3
    //Explanation: There are three ways to climb to the top.
    //1. 1 step + 1 step + 1 step
    //2. 1 step + 2 steps
    //3. 2 steps + 1 step
    private var result = 0
    val map = mutableMapOf<Int, Int>()

    fun climbStairs(n: Int): Int {
        return dp(n)
    }

    //Memoization of DP
    private fun dp(n: Int): Int {
        if (map.containsKey(n)) return map[n]!!
        if (n < 0) return 0
        if (n == 0) return 1
        result += dp(n - 1)
        result += dp(n - 2)
        map[n] = result
        return result
    }

//
    fun dpClimbStairs(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2
        var val1 = 1
        var val2 = 2
        var result = 0
        for (i in 3..n) {
            result = val1 + val2
            val1 = val2
            val2 = result
        }
        return result
    }
}