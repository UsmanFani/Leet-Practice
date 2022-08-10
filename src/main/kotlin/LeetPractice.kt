import dp.KnapsackProblem
import easy.*
import medium.*

fun main() {
    var h = 1000000000
    var w = 1000000000
    var horizontalCuts = intArrayOf(2)
    var verticalCuts = intArrayOf(2)
    var area = MaxAreaOfCake().maxArea(h, w, horizontalCuts, verticalCuts)
    println(area)
}