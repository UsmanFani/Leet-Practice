package Arrays.hard

import java.util.PriorityQueue

class MaxValueOfEquation {
    //You are given an array points containing the coordinates of points on a 2D plane
    //Return the maximum value of the equation yi + yj + |xi - xj| where |xi - xj| <= k and 1 <= i < j <= points.length.

    //Example 1:
    //Input: points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
    //Output: 4
    //Explanation: The first two points satisfy the condition |xi - xj| <= 1 and if we calculate the equation we get 3 + 0 + |1 - 2| = 4.
    //Third and fourth points also satisfy the condition and give a value of 10 + -10 + |5 - 6| = 1.
    //No other pairs satisfy the condition, so we return the max of 4 and 1.

    //Example 2:
    //Input: points = [[0,0],[3,0],[9,2]], k = 3
    //Output: 3
    //Explanation: Only the first two points have an absolute difference of 3 or less in the x-values, and give the value of 0 + 0 + |0 - 3| = 3.

    //[[-17,5],[-10,-8],[-5,-13],[-2,7],[8,-14]]
    fun findMaxValueOfEquation(points: Array<IntArray>, k: Int): Int {
        var maxValue = Int.MIN_VALUE
        var left = 0
        var right = 1
        if (points.size == 2) {
            maxValue = points[0][1] + points[1][1] + Math.abs(points[0][0] - points[1][0])
            return maxValue
        }
        while (left < points.lastIndex) {
            val diff = Math.abs(points[left][0] - points[right][0])
            if (left == right) {
                right++
            } else if (diff > k) {
                left++
                right = left + 1
            } else {
                val yi = points[left][1]
                val yj = points[right][1]
                val xi = points[left][0]
                val xj = points[right][0]
                //yi + yj + |xi - xj|
                val tempVal = yi + yj + Math.abs(xi - xj)
                maxValue = maxOf(tempVal, maxValue)
                if (right == points.lastIndex) {
                    left++
                    right = left + 1
                } else right++
            }
        }
        return maxValue
    }

    //yi + yj + |xi - xj| -> |xi - xj| = xj - xi (xj>xi)
    //yi + yj + xj - xi -> (yi-xi)+(yj+xj)
    //we have to found max(yi-xi) at (xj-xi<=k)
    //so we use Priority_Queue. that will prioritize the max value at top
    //PriorityQueue<Pair<(yi-xi),xi>> when (xj-xi<=k)
    fun optimFindMaxValueOfEquation(points: Array<IntArray>, k: Int): Int {
        val pq: PriorityQueue<Pair<Int, Int>> =
            PriorityQueue { pair1, pair2 -> if (pair1.first == pair2.first) pair1.second - pair2.second else pair2.first - pair1.first }
        var maxValue = Int.MIN_VALUE
        for (i in points.indices) {
            while (pq.isNotEmpty() && (points[i][0] - pq.peek().second > k)) pq.remove()
            if (pq.isNotEmpty()) {
                maxValue = maxOf(maxValue, points[i][0] + points[i][1] + pq.peek().first)
            }
            val pair = Pair((points[i][1] - points[i][0]), points[i][0])
            pq.add(pair)
        }
        return maxValue
    }
}