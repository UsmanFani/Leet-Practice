package easy

class SortedSquares {
    //Example 1:
    //
    //Input: nums = [-4,-1,0,3,10]
    //Output: [0,1,9,16,100]
    //Explanation: After squaring, the array becomes [16,1,0,9,100].
    //After sorting, it becomes [0,1,9,16,100].

    //Example 2:
    //
    //Input: nums = [-7,-3,2,3,11]
    //Output: [4,9,9,49,121]
    fun sortedSquares(nums:IntArray):IntArray{
        for(i in nums.indices){
            nums[i] = nums[i]*nums[i]
        }
       for(i in 0 until nums.lastIndex){
           if(nums[i]>nums[i+1]){
               val temp = nums[i+1]
               nums[i+1] = nums[i]
               nums[i] = temp
           }
       }
        return nums
    }
}