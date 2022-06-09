package medium
//167. Two Sum II - Input Array Is Sorted

class TwoSum_II {
    //Example 1:
    //
    //Input: numbers = [2,7,11,15], target = 9
    //Output: [1,2]
    //Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

    //Example 2:
    //
    //Input: numbers = [2,3,4], target = 6
    //Output: [1,3]
    //Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

    //Example 3:
    //
    //Input: numbers = [-1,0], target = -1
    //Output: [1,2]
    //Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var sumIndex = IntArray(2)

        for (i in 0 until numbers.lastIndex) {
            for (j in i + 1..numbers.lastIndex) {
                if (numbers[i] + numbers[j] == target) {
                    sumIndex[0] = i + 1
                    sumIndex[1] = j + 1
                    return sumIndex
                }
            }
        }
        return sumIndex
    }

    fun optimTwoSum(numbers: IntArray, target: Int): IntArray {
        var start = 0
        var end = numbers.lastIndex
        var sumIndex = IntArray(2)
        while (end - start > 0) {
            var sum = numbers[start] + numbers[end]
            if (sum == target) {
                sumIndex = intArrayOf(start + 1, end + 1)
                return sumIndex
            }
            if (sum > target) {
                end--
            } else start++
        }
        return sumIndex
    }
}