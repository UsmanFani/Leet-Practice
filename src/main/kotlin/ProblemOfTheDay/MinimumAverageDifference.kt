package ProblemOfTheDay

//@author Usman Fani
class MinimumAverageDifference {
    //Example 1:
    //Input: nums = [2,5,3,9,5,3]
    //Output: 3
    //Explanation:
    //- The average difference of index 0 is: |2 / 1 - (5 + 3 + 9 + 5 + 3) / 5| = |2 / 1 - 25 / 5| = |2 - 5| = 3.
    //- The average difference of index 1 is: |(2 + 5) / 2 - (3 + 9 + 5 + 3) / 4| = |7 / 2 - 20 / 4| = |3 - 5| = 2.
    //- The average difference of index 2 is: |(2 + 5 + 3) / 3 - (9 + 5 + 3) / 3| = |10 / 3 - 17 / 3| = |3 - 5| = 2.
    //- The average difference of index 3 is: |(2 + 5 + 3 + 9) / 4 - (5 + 3) / 2| = |19 / 4 - 8 / 2| = |4 - 4| = 0.
    //- The average difference of index 4 is: |(2 + 5 + 3 + 9 + 5) / 5 - 3 / 1| = |24 / 5 - 3 / 1| = |4 - 3| = 1.
    //- The average difference of index 5 is: |(2 + 5 + 3 + 9 + 5 + 3) / 6 - 0| = |27 / 6 - 0| = |4 - 0| = 4.
    //The average difference of index 3 is the minimum average difference so return 3.

    //Example 2:
    //Input: nums = [0]
    //Output: 0
    //Explanation:
    //The only index is 0 so return 0.
    //The average difference of index 0 is: |0 / 1 - 0| = |0 - 0| = 0.
    fun minimunAverageDifference(nums: IntArray): Int {
        var maxsum: Long = 0
        nums.forEach {
            maxsum += it
        }
        var min: Long = Long.MAX_VALUE
        var index = 0
        var sum: Long = 0
        nums.indices.forEach {
            sum += nums[it]
            val leftAvg = sum / (it + 1)
            val rightAvg = if (it != nums.lastIndex) (maxsum - sum) / (nums.size - (it + 1)) else 0
            val avgDiff = Math.abs(leftAvg - rightAvg)
            if (avgDiff < min) {
                min = avgDiff
                index = it
            }
        }
        return index
    }
}