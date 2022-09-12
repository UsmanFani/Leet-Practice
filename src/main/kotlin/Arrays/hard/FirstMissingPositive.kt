package Arrays.hard

class FirstMissingPositive {
    //Example 1:
    //Input: nums = [1,2,0]
    //Output: 3
    //Explanation: The numbers in the range [1,2] are all in the array.

    //Example 2:
    //Input: nums = [3,4,-1,1]
    //Output: 2
    //Explanation: 1 is in the array but 2 is missing.

    //Example 3:
    //Input: nums = [7,8,9,11,12]
    //Output: 1
    //Explanation: The smallest positive integer 1 is missing.
    fun firstMissingPositive(nums: IntArray): Int {
        var num = 1
        var map = mutableMapOf<Int, Int>()
        nums.forEach {
            map[it] = 1
        }
        for (i in nums) {
            if (map.containsKey(num)) num++
            else return num
        }
        return num
    }

    //time = O(n)
    //space = O(1)
    fun optimFirstMissingPositive(nums: IntArray): Int {
        for (i in nums.indices) {
            if (nums[i] < 0) nums[i] = 0
        }
        for (i in nums) {
            var index = Math.abs(i) - 1
            if (index in nums.indices) {
                if (nums[index] == 0) nums[index] = (nums.size + 1) * -1
                else nums[index] = Math.abs(nums[index]) * -1
            }
        }
        for (i in 0..nums.lastIndex) {
            if (nums[i] >= 0) return i + 1
        }
        return if (nums.size == 1) 2 else nums.size + 1
    }
}