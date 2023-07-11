import Maths.Easy.AddBinary
import Maths.Hard.BasicCalculator
import Maths.Medium.*
import Strings.Hard.TextJustification
import Strings.Medium.*
import kotlin.math.pow

fun main() {

    val cal = BasicCalculator()
    var res  = cal.calculate("(1+(4+5+2)-3)+(6+8)-1-(-1-4)")
    println(res)
}

