package Arrays.medium

import kotlin.math.max

class MaxAreaOfCake {
    //Example 1:
    //Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
    //Output: 4
    //Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green piece of cake has the maximum area.

    //Example 2:
    //Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
    //Output: 6
    //Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green and yellow pieces of cake have the maximum area.

    //Example 3:
    //Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
    //Output: 9
    fun maxArea(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {
        horizontalCuts.sort()
        verticalCuts.sort()
        var hDiff = horizontalCuts[0]
        var vDiff = verticalCuts[0]

        for (i in 1..horizontalCuts.size) {
            hDiff = if (horizontalCuts.size == i) maxOf(h - horizontalCuts[i - 1], hDiff)
            else maxOf(horizontalCuts[i] - horizontalCuts[i - 1], hDiff)
        }

        for (i in 1..verticalCuts.size) {
            vDiff = if (verticalCuts.size == i) maxOf(w - verticalCuts[i - 1], vDiff)
            else maxOf(verticalCuts[i] - verticalCuts[i - 1], vDiff)
        }
        val area:Long = vDiff.toLong() * hDiff.toLong()
        if (area > Int.MAX_VALUE) return (area % 1000000007).toInt()
        return vDiff * hDiff
    }
}