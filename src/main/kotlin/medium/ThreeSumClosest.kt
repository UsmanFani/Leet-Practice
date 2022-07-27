package medium

class ThreeSumClosest {
    //Example 1:
    //Input: nums = [-1,2,1,-4], target = 1
    //Output: 2
    //Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

    //Example 2:
    //Input: nums = [0,0,0], target = 1
    //Output: 0

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var prevSum = nums[0] + nums[1] + nums[2]
        var arr = intArrayOf(prevSum)

        for (i in 0..nums.lastIndex - 2) {
            for (j in i + 1 until nums.lastIndex) {
                for (k in j + 1..nums.lastIndex) {
                    var sum = nums[i] + nums[j] + nums[k]
                    if (sum == target) return sum
                    if (sum > target) {
                        var diff1 = maxOf(sum, target) - minOf(sum, target)
                        var diff2 = maxOf(prevSum, target) - minOf(prevSum, target)
                        var diff3 = maxOf(arr[0], target) - minOf(arr[0], target)
                        if (diff1 <= diff2 && diff1 < diff3) arr[0] = sum
                        else if (diff2 < diff1 && diff2 < diff3) arr[0] = prevSum
                        break
                    } else arr[0] = sum
                    prevSum = sum
                }
                prevSum = nums[0] + nums[1] + nums[2]
            }
        }
        return arr[0]
    }

    //-4,-1,1,2
    //2
    fun optimThreeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var diff = nums[0]+nums[1]+nums[2]
        var sum: Int
        for (i in 0..nums.lastIndex - 2) {
            var start = i+1
            var end = nums.lastIndex

            while (start < end) {
                sum = nums[i] + nums[start] + nums[end]
                if (sum == target) return target

                var diff1 = maxOf(sum, target) - minOf(sum, target)
                var diff2 = maxOf(diff,target) - minOf(diff,target)
                if (diff1 < diff2) diff = sum
                if (sum > target) end--
                else start++
            }
        }
        return diff
    }
}