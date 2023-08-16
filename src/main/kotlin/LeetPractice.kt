import Maths.Easy.AddBinary
import Maths.Hard.BasicCalculator
import Maths.Medium.*
import Strings.Hard.NumberToWords
import Strings.Hard.TextJustification
import Strings.Medium.*
import greedy.medium.*
import kotlin.math.pow

fun main() {

    val cal = RestoreArrayFromPairs()
    val arr = cal.restoreArray(arrayOf(intArrayOf(2,1), intArrayOf(3,4), intArrayOf(3,2)))
    println(arr.toList())
}

