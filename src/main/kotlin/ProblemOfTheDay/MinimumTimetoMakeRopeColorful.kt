package ProblemOfTheDay

//@author Usman Fani
class MinimumTimetoMakeRopeColorful {
    //Example 1:
    //Input: colors = "abaac", neededTime = [1,2,3,4,5]
    //Output: 3
    //Explanation: In the above image, 'a' is blue, 'b' is red, and 'c' is green.
    //Bob can remove the blue balloon at index 2. This takes 3 seconds.
    //There are no longer two consecutive balloons of the same color. Total time = 3.

    //Example 2:
    //Input: colors = "abc", neededTime = [1,2,3]
    //Output: 0
    //Explanation: The rope is already colorful. Bob does not need to remove any balloons from the rope.

    //Example 3:
    //Input: colors = "aabaa", neededTime = [1,2,3,4,1]
    //Output: 2
    //Explanation: Bob will remove the ballons at indices 0 and 4. Each ballon takes 1 second to remove.
    //There are no longer two consecutive balloons of the same color. Total time = 1 + 1 = 2.
    fun minCost(colors: String, neededTime: IntArray): Int {
        var maxTime = 0
        var tempMax = neededTime[0]
        var sum = neededTime[0]
        for (i in 1..colors.lastIndex) {
            sum += neededTime[i]
            if (colors[i] != colors[i - 1]) {
                maxTime += tempMax
                tempMax = neededTime[i]
            } else {
                tempMax = maxOf(tempMax, maxOf(neededTime[i], neededTime[i - 1]))
            }

            if (i == colors.lastIndex) {
                maxTime += tempMax
            }
        }
        return sum - maxTime
    }
}