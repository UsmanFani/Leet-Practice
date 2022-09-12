package Arrays.easy

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
        var arr = IntArray(nums.size)
        var start = 0
        var end = nums.lastIndex
        for(i in nums.lastIndex downTo 0){
            if(nums[start]>=0){
                arr[i] = nums[end]*nums[end]
                start++
                end--
            }else{
                if(nums[start]*-1>nums[end]){
                    arr[i] = nums[start]*nums[start]
                    start++
                }else{
                    arr[i] = nums[end]*nums[end]
                    end--
                }
            }
        }
        return arr
    }
}