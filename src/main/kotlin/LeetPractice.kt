import dp.KnapsackProblem
import easy.MaxSubArray
import easy.SearchInsert
import medium.`Ones&Zeroes`

fun main(){
    val nums = intArrayOf(1)
    val max = MaxSubArray().optimMaxSubArray(nums)
    println(max)
}