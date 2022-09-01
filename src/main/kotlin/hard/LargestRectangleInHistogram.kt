package hard

class LargestRectangleInHistogram {
    //Example 1:
    //Input: heights = [2,1,5,6,2,3]
    //Output: 10
    //Explanation: The above is a histogram where width of each bar is 1.
    //The largest rectangle is shown in the red area, which has an area = 10 units.

    //Example 2:
    //Input: heights = [2,4]
    //Output: 4
    fun largestRectangleArea(height:IntArray):Int{
        var maxArea = 0
        for(i in height.indices){
            var min = height[i]
            maxArea = maxOf(maxArea,min)
            for (j in i+1..height.lastIndex){
                min = minOf(min,height[j])
                val area = min * (j-i+1)
                maxArea = maxOf(maxArea,area)
            }
        }
        return maxArea
    }
}