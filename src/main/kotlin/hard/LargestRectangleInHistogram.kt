package hard

import java.util.Stack

class LargestRectangleInHistogram {
    //Example 1:
    //Input: heights = [2,1,5,6,2,3]
    //Output: 10
    //Explanation: The above is a histogram where width of each bar is 1.
    //The largest rectangle is shown in the red area, which has an area = 10 units.

    //Example 2:
    //Input: heights = [2,4]
    //Output: 4
    fun largestRectangleArea(height: IntArray): Int {
        var maxArea = 0
        for (i in height.indices) {
            var min = height[i]
            maxArea = maxOf(maxArea, min)
            for (j in i + 1..height.lastIndex) {
                min = minOf(min, height[j])
                val area = min * (j - i + 1)
                maxArea = maxOf(maxArea, area)
            }
        }
        return maxArea
    }

    fun optimLargestResctangleArea(heights: IntArray): Int {
        var maxArea = 0
        var stack = Stack<IntArray>()
        for (i in 0..heights.lastIndex) {
            if (stack.isEmpty()) {
                stack.push(intArrayOf(i, heights[i]))
                continue
            }
            var element = stack.last()
            if (element[1] == heights[i]) continue
            if (element[1] < heights[i]) stack.push(intArrayOf(i, heights[i]))
            else {
                while (stack.isNotEmpty() && heights[i] < element[1]) {
                    element = stack.last()
                    val area = (i - element[0]) * element[1]
                    maxArea = maxOf(maxArea, area)
                    stack.pop()
                    if(stack.isNotEmpty()){
                        var element1 = stack.last()
                        if(heights[i]<element1[1]){
                            element = element1
                        }else break
                    }
                }
                val arr = intArrayOf(element[0], heights[i])
                stack.push(arr)
            }

        }
        var lastIndex = heights.lastIndex

        stack.forEach {
            var area = (lastIndex - it[0] + 1) * it[1]
            maxArea = maxOf(area, maxArea)
        }
        return maxArea
    }
}