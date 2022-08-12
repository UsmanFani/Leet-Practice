import dp.KnapsackProblem
import easy.*
import medium.*

fun main() {
    var nums = intArrayOf(6,2,9,3,9,6,7,7,6,4)
    var k = 3
    var find = FindPairs().findPairs(nums, k)
    println(find)
}