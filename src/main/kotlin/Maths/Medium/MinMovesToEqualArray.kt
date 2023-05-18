package Maths.Medium

//@author Usman Fani

//Example 1:
//
//Input: nums = [1,2,3]
//Output: 3
//Explanation: Only three moves are needed (remember each move increments two elements):
//[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
//Example 2:
//
//Input: nums = [1,1,1]
//Output: 0
class MinMovesToEqualArray {
    fun minMoves(nums: IntArray): Int {
        val min = nums.minOrNull()

        var res = 0
        for (i in nums) {
            res += (i - min!!)
        }
        return res
    }
}