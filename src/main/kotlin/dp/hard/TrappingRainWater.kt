package dp.hard

import java.util.Stack

//@author Usman Fani
class TrappingRainWater {
    //Example 1:
    //Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    //Output: 6
    //Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

    //Example 2:
    //Input: height = [4,2,0,3,2,5]
    //Output: 9

    //Brute force
    //O(n^2)
    //O(1)
    fun trap(height: IntArray): Int {
        var leftMax = 0
        var count = 0
        for (i in height.indices) {
            leftMax = maxOf(leftMax, height[i])
            var max = 0
            for (j in i..height.lastIndex) {
                val tempCount = minOf(leftMax, height[j]) - height[i]
                max = maxOf(max, tempCount)
            }
            count += max
        }
        return count
    }

    //Time: O(n)
    //Space: O(n)
    fun betterTrap(height: IntArray): Int {
        val maxLeft = IntArray(height.size)
        val maxRight = IntArray(height.size)
        var count = 0
        maxLeft[0] = height[0]
        for (i in 1..height.lastIndex) {
            maxLeft[i] = maxOf(maxLeft[i - 1], height[i])
        }
        maxRight[height.lastIndex] = height.last()
        for (i in height.lastIndex - 1 downTo 0) {
            maxRight[i] = maxOf(maxRight[i + 1], height[i])
        }

        for (i in height.indices) {
            val tempCount = minOf(maxLeft[i], maxRight[i]) - height[i]
            count += tempCount
        }
        return count
    }

    //optim
    //O(n)
    //O(1)
    fun optimTrap(height: IntArray): Int {
        var leftMax = height.first()
        var rightMax = height.last()
        var count = 0
        var left = 0
        var right = height.lastIndex
        while (left < right) {
            if (height[left] <= height[right]) {
                leftMax = maxOf(leftMax, height[left])
                rightMax = maxOf(rightMax, height[right])
                val tempCount = minOf(leftMax, rightMax) - height[left]
                count += tempCount
                left++
            } else {
                leftMax = maxOf(leftMax, height[left])
                rightMax = maxOf(rightMax, height[right])
                val tempCount = minOf(leftMax, rightMax) - height[right]
                count += tempCount
                right--
            }
        }
        return count
    }
}