import dp.KnapsackProblem
import easy.*
import medium.*

fun main() {
    var nums = intArrayOf(4,5,0,-2,-3,1)
    var k = 5
    var can = SubArrayDivByK().subarraysDivByK(nums, k)
    println(can)
}