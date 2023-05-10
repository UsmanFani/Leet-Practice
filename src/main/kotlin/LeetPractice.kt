import Strings.Hard.TextJustification
import Strings.Medium.*

fun main() {


    val rev = TextJustification()
    val str = arrayOf(
        "What", "must", "be", "acknowledgment", "shall", "be"
    )
    val res = rev.fullJustify(str, 16)
    println(res)
}

