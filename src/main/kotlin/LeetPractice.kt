import dp.KnapsackProblem
import easy.*
import medium.*

fun main() {
    var nums = intArrayOf(1,2,3)
    var k = 3
    val subArray = SubArraySum().optimSubArray(nums,k)
    print(subArray)
}