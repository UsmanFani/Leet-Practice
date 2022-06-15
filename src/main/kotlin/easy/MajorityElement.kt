package easy

class MajorityElement {
    //Example 1:
    //
    //Input: nums = [3,2,3]
    //Output: 3

    //Example 2:
    //
    //Input: nums = [2,2,1,1,1,2,2]
    //Output: 2

    //Example 3:
    //[-1,1,1,1,2,1]
    //1
    fun majorityElement(nums:IntArray):Int{
        var map = mutableMapOf<Int,Int>()
        for(i in nums){
            if (map.containsKey(i)){
                var inc = map[i]
                map[i] = inc!!+1
            }else map[i] = 1
        }
        val max = map.maxByOrNull { it.value }
        return max!!.key
    }
    //solve with simple trick
    fun majority_Element(nums:IntArray):Int{
        var num = nums[0]
        var count = 1
        for(i in 1..nums.lastIndex){
            if(count == 0){
                count++
                num = nums[i]
            }else if(num != nums[i]) count--
            else count++
        }
        return num
    }
}