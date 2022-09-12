package Arrays.medium

class FindDuplicate {
    //Example 1:
    //Input: nums = [1,3,4,2,2]
    //Output: 2

    //Example 2:
    //Input: nums = [3,1,3,4,2]
    //Output: 3

    //Constraints:
    //
    //1 <= n <= 10^5
    //nums.length == n + 1
    //1 <= nums[i] <= n
    //All the integers in nums appear only once except for precisely one integer which appears two or more times.
    fun findDuplicate(nums: IntArray): Int {
        var duplicate = 0
        var map = mutableMapOf<Int, Int>()
        for (i in nums) {
            if (map.containsKey(i)) {
                map[i] = map[i]!! + 1
                if (map[i]!! > 1) return i
            } else map[i] = 1
        }
        return duplicate
    }

    fun optimFindDuplicate(nums: IntArray): Int {
        var slow = 0
        var fast = 0
        do {
            slow = nums[slow]
            fast = nums[nums[fast]]
        } while (slow != fast)

        var slow2 = 0
        do {
            slow = nums[slow]
            slow2 = nums[slow2]
        } while (slow != slow2)
        return slow
    }
}