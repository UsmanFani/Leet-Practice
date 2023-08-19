import Maths.Easy.AddBinary
import Maths.Hard.BasicCalculator
import Maths.Medium.*
import Strings.Hard.NumberToWords
import Strings.Hard.TextJustification
import Strings.Medium.*
import greedy.medium.*
import kotlin.math.pow

fun main() {

    val cal = EraseOverlapIntervals()
    val arr = cal.eraseOverlapIntervals(
        arrayOf(
            intArrayOf(40, 70),
            intArrayOf(56, 80),
            intArrayOf(63, 87),
            intArrayOf(-51, 39),
            intArrayOf(-74, 59),
            intArrayOf(38, 41),
            intArrayOf(-49, 17),
            intArrayOf(6, 57),
            intArrayOf(36, 85),
            intArrayOf(-73, 26),
            intArrayOf(-6, 70),
            intArrayOf(15, 70),
            intArrayOf(66, 78),
            intArrayOf(37, 87),
            intArrayOf(79, 96),
            intArrayOf(46, 97),
            intArrayOf(36, 49),
            intArrayOf(-58, 40),
            intArrayOf(-58, 52),
            intArrayOf(26, 83),
            intArrayOf(-27, 43),
            intArrayOf(15, 86),
            intArrayOf(11, 56),
            intArrayOf(23, 34),
            intArrayOf(-9, 73),
            intArrayOf(-95, -75),
            intArrayOf(2, 30),
            intArrayOf(-91, 26),
            intArrayOf(88, 89),
            intArrayOf(-83, -43)
        )
    )
    println(arr)
}

