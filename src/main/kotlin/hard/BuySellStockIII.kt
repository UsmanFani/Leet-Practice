package hard

class BuySellStockIII {
    //Example 1:
    //Input: prices = [3,3,5,0,0,3,1,4]
    //Output: 6
    //Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
    //Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

    //Example 2:
    //Input: prices = [1,2,3,4,5]
    //Output: 4
    //Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
    //Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.

    //Example 3:
    //Input: prices = [7,6,4,3,1]
    //Output: 0
    //Explanation: In this case, no transaction is done, i.e. max profit = 0.
    fun maxProfit(prices: IntArray): Int {
        val leftToRight = IntArray(prices.size)
        val rightToLeft = IntArray(prices.size)

        var min = prices[0]
        var max = prices[0]
        var profit = 0
        var maxProfit = 0

        for (i in 1..prices.lastIndex) {
            if (prices[i] > max) max = prices[i]
            if (prices[i] < min) {
                min = prices[i]
                max = prices[i]
            }
            profit = maxOf(profit, max - min)
            leftToRight[i] = profit
        }
        min = prices[prices.lastIndex]
        max = prices[prices.lastIndex]
        profit = 0
        for (i in prices.lastIndex - 1 downTo 0) {
            if (prices[i] < min) min = prices[i]
            if (prices[i] > max) {
                min = prices[i]
                max = prices[i]
            }
            profit = maxOf(profit, max - min)
            rightToLeft[i] = profit
        }

        for (i in prices.indices) {
            maxProfit = maxOf(maxProfit, leftToRight[i] + rightToLeft[i])
        }
        return maxProfit
    }

    fun optimMaxProfit(prices: IntArray): Int {
        var (buy1Balance, sell1Balance, buy2Balance, sell2Balance) = IntArray(4){Int.MIN_VALUE}
        for (price in prices) {
            buy1Balance = maxOf(buy1Balance,-price)
            // how much are you left after buying one? well negative, because you had to spend money

            sell1Balance = maxOf(sell1Balance, buy1Balance+price)
            // let's sell it, we gain price. This is the balance we have to add to the balance after we bought the first

            buy2Balance = maxOf(buy2Balance, sell1Balance-price)
            // how much are you left after buying another one?

            sell2Balance = maxOf(sell2Balance,buy2Balance + price)
            // let's sell it, we gain price. Add to final balance
        }
        return sell2Balance //done, return

    }
}