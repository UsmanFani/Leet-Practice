import dp.KnapsackProblem
import easy.MaxSubArray
import easy.MergeSortedArray
import medium.`Ones&Zeroes`

fun main(){

    var nums1 = intArrayOf(1,2,3,0,0,0)
    var m = 3
    var nums2 = intArrayOf(2,5,6)
    var n = 3
   MergeSortedArray().merge(nums1, m, nums2, n)
}