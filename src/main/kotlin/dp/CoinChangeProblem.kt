package dp

class CoinChangeProblem {
    //co=18,coins=[1,5,7]
    //4

    fun minCoins(co: Int, coins: IntArray, dp: IntArray): Int {
        if (co == 0) return 0
        var ans = Int.MAX_VALUE
        for (i in coins) {
            if ((co - i) >= 0) {
                var subAns = if (dp[co - i] > -1) {
                    dp[co - i]
                } else {
                    minCoins(co - i, coins, dp)
                }
                if (subAns + 1 < ans) {
                    ans = subAns + 1
                }
            }
        }
        dp[co] = ans
        println("$co , ${dp[co]}")
        return ans
    }
}