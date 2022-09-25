import ProblemOfTheDay.ReverseWordStringIII
import dp.easy.CountingBits
import dp.medium.DecodeWays
import dp.medium.DeleteAndEarn
import dp.medium.MaximalSquare
import dp.medium.WordBreak

fun main() {

    var matrix = arrayOf(
        charArrayOf('1','0','1','0','0'),
        charArrayOf('1','0','1','1','1'),
        charArrayOf('1','1','1','1','1'),
        charArrayOf('1','0','0','1','0'))
    var mat = arrayOf(charArrayOf('0','1'), charArrayOf('1','0'))
    var max = MaximalSquare().maximalSquare(mat)
    println(max)

}

