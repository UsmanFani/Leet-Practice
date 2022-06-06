import dp.KnapsackProblem
import easy.MaxSubArray
import easy.SearchInsert
import medium.`Ones&Zeroes`

fun main(){
    val nums = intArrayOf(5,4,-1,7,8)
    val max = MaxSubArray().maxSubArray(nums)
    println(max)
}