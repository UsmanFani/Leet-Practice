import ProblemOfTheDay.NumberOfIslands
import ProblemOfTheDay.NumberWithSameConsecutiveDiff
import dp.KnapsackProblem
import easy.*
import hard.*
import medium.*

fun main() {

    var p = arrayOf(
        intArrayOf(-17,-6),
        intArrayOf(-4,0),
        intArrayOf(-2,-16),
        intArrayOf(-1,2),
        intArrayOf(0,11),
        intArrayOf(6,18))
   // var points = arrayOf(intArrayOf(0, 0), intArrayOf(3, 0), intArrayOf(9, 2))
    var k = 13
    var max = MaxValueOfEquation().optimFindMaxValueOfEquation(p, k)
    println(max)

}

