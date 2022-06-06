package dp

import kotlin.math.max

class KnapsackProblem {
    //maxWeight = 10
    //weight = [1,3,4,6]
    //cost = [20,30,10,50]
    //maxCost = 100
    fun getMaxWeight(maxWeight: Int, weight: IntArray, cost: IntArray): Int {
        var dp = Array(weight.size + 1) {
            IntArray(maxWeight + 1) { 0 }
        }
        var ans = 0
        for (i in 1..weight.size) {
            for (j in 1..maxWeight) {

                var maxValueWithoutCurrent = dp[i - 1][j]
                var maxValueCurrent = 0

                if (j >= weight[i - 1]) {
                    maxValueCurrent = cost[i - 1] + dp[i - 1][j - weight[i-1]]
                }

                ans = max(maxValueWithoutCurrent, maxValueCurrent)
                dp[i][j] = ans
            }

        }
        return ans
    }
}