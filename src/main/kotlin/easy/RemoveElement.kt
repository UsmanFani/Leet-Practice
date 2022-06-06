package easy

class RemoveElement {
    //[0,1,1,2,2,3,4,5], 2
    fun removeElement(nums:IntArray, `val`:Int):Int{
        var k = 0
        for(element in nums){
            if(element!=`val`){
                nums[k]=element
                k++
            }
        }
        return k
    }
}