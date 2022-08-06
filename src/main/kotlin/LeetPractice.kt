import dp.KnapsackProblem
import easy.*
import medium.*

fun main() {
   var nums = intArrayOf(2,3,6,7)
    var target = 7
    var combination = CombinationSum().combinationSum(nums,target)
    println(combination)
}