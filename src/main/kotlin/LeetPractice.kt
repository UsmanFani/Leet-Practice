import Maths.Easy.AddBinary
import Maths.Hard.BasicCalculator
import Maths.Medium.*
import Strings.Hard.NumberToWords
import Strings.Hard.TextJustification
import Strings.Medium.*
import greedy.medium.TaskScheduler
import kotlin.math.pow

fun main() {

    val cal = TaskScheduler()
    val tasks = charArrayOf('A','A','A','B','B','B','C','C','C','D','D','E')
    var res  = cal.leastInterval(tasks,2)
    println(res)
}

