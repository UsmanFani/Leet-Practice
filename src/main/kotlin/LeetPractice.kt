import dp.KnapsackProblem
import easy.MaxSubArray
import easy.MergeSortedArray
import medium.`Ones&Zeroes`
import medium.TwoSum_II

fun main(){
    var numbers = intArrayOf(2,3,4)
    var target = 6
    val twoSum = TwoSum_II().optimTwoSum(numbers, target)
    println(twoSum.asList())
}