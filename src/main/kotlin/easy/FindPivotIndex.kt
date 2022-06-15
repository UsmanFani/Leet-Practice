package easy

class FindPivotIndex {
    //Example 1:
    //
    //Input: nums = [1,7,3,6,5,6]
    //Output: 3
    //Explanation:
    //The pivot index is 3.
    //Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
    //Right sum = nums[4] + nums[5] = 5 + 6 = 11

    //Example 2:
    //
    //Input: nums = [1,2,3]
    //Output: -1
    //Explanation:
    //There is no index that satisfies the conditions in the problem statement.

    //Example 3:
    //
    //Input: nums = [2,1,-1]
    //Output: 0
    //Explanation:
    //The pivot index is 0.
    //Left sum = 0 (no elements to the left of index 0)
    //Right sum = nums[1] + nums[2] = 1 + -1 = 0
    fun findPivotIndex(nums: IntArray): Int {
        var leftSum = 0
        var rightSum = 0

       for(i in nums){
          rightSum += i
       }
        for(i in nums.indices){
            if(i>0) leftSum += nums[i-1]
            if(i<=nums.lastIndex) rightSum -= nums[i]
            if(leftSum==rightSum) return i
        }
        return -1
    }
}