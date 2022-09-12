package Arrays.medium

import java.lang.Integer.min

class ContainerWithMostWater {
    fun maxWater(height: IntArray): Int {
        var maxArea = 0
        for (i in 0 until height.lastIndex) {
            for (j in i + 1..height.lastIndex) {
                var area = min(height[i], height[j]) * (j - i)
                maxArea = maxOf(area, maxArea)
            }
        }
        return maxArea
    }

    fun optimMaxWater(height: IntArray): Int {
        var maxArea = 0
        var left = 0
        var right = height.lastIndex
        while (left < right) {
            var area = minOf(height[left], height[right]) * (right - left)
            maxArea = maxOf(maxArea, area)
            if (height[left] >= height[right]) {
                right--
            } else left++
        }
        return maxArea
    }
}