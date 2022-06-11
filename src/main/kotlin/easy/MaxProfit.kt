package easy

import kotlin.math.max

class MaxProfit {
    //Example 1:
    //
    //Input: prices = [7,1,5,3,6,4]
    //Output: 5
    //Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    //Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

    //Example 2:
    //
    //Input: prices = [7,6,4,3,1]
    //Output: 0
    //Explanation: In this case, no transactions are done and the max profit = 0.
    fun maxProfit(prices:IntArray):Int{
        var max = 0
        for(i in 0 until prices.lastIndex){
            for(j in i+1 .. prices.lastIndex ){
                var value = prices[j]-prices[i]
                max = maxOf(max,value)
            }
        }
        return max
    }

    fun optimMaxProfit(prices:IntArray):Int{
        var profit = 0
        var min = Int.MAX_VALUE
        var start = 0
        var end = 1
        while (end<=prices.lastIndex){
            min = minOf(min,prices[start])
            var diff = prices[end]-min
            profit = max(profit,diff)
            end++
            start++
        }
        return profit
    }
}