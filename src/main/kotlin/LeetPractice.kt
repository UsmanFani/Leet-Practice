import ProblemOfTheDay.ReverseWordStringIII
import dp.easy.CountingBits
import dp.medium.*

fun main() {

    var nums = intArrayOf(2,-5,-2,-4,3)
    // var mat = arrayOf(charArrayOf('0','1'), charArrayOf('1','0'))
    var max = MaximumProductSubarray().moreOptimMaxProduct(nums)
    println(max)

}

