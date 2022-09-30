package dp.medium

class CoinChange {
    //Example 1:
    //Input: coins = [1,2,5], amount = 11
    //Output: 3
    //Explanation: 11 = 5 + 5 + 1

    //Example 2:
    //Input: coins = [2], amount = 3
    //Output: -1

    //Example 3:
    //Input: coins = [1], amount = 0
    //Output: 0
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0) return 0
        coins.sort()
        var dp = Array(coins.size + 1) { IntArray(amount + 1) }
        for (i in 1..dp.lastIndex) {
            for (j in 1..dp[0].lastIndex) {
                if (j == coins[i - 1]) {
                    dp[i][j] = 1
                    continue
                }
                if (j > coins[i - 1]) {
                    val diff = j - coins[i - 1]
                    if (dp[i][diff] == 0) dp[i][j] = 0
                    else dp[i][j] = 1 + dp[i][diff]
                    continue
                }
                dp[i][j] = dp[i - 1][j]
            }
        }
        if (dp[dp.lastIndex][dp[0].lastIndex] == 0) return -1
        return dp[dp.lastIndex][dp[0].lastIndex]
    }

    fun optimCoinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0) return 0
        coins.sort()
        val dp = IntArray(amount + 1) { amount + 1 }
        dp[0] = 0
        for (i in 1..amount) {
            for (j in coins) {
                val diff = i - j
                if (diff < 0) break
                dp[i] = minOf(dp[i], 1 + dp[diff])
            }
        }
        if (dp.last() > amount) return -1
        return dp.last()
    }
}