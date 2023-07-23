import Maths.Easy.AddBinary
import Maths.Hard.BasicCalculator
import Maths.Medium.*
import Strings.Hard.NumberToWords
import Strings.Hard.TextJustification
import Strings.Medium.*
import greedy.medium.GasStation
import greedy.medium.TaskScheduler
import kotlin.math.pow

fun main() {

    val cal = GasStation()
    val tasks = cal.optimCanCompleteCircuit(intArrayOf(6,1,4,3,5), intArrayOf(3,8,2,4,2))
    println(tasks)
}

