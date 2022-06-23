import dp.KnapsackProblem
import easy.*
import medium.*

fun main() {
    val arr = arrayOf(intArrayOf(2,3), intArrayOf(5, 5), intArrayOf(2,2), intArrayOf(3,4), intArrayOf(3,4))
    val merge = MergeIntervals().mergeIntervals(arr)
    merge.forEach { println(it.asList()) }
}