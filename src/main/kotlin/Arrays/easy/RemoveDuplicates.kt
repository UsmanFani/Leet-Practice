package Arrays.easy

class RemoveDuplicates {
    //[0,0,1,1,2,3,3,4,5]
    fun removeDuplicates(nums:IntArray):Int{
        var i:Int = 0
        for(element in nums) {
            if(nums[i] != element) {
                i++
                nums[i] = element
            }
        }
        return i + 1
    }
}