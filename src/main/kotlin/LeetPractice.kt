import Arrays.medium.BagOfTokens
import dp.Easy.MaximumSubarray

fun main() {

   var tokens = intArrayOf(100,200,300,400,500)
    var power = 200
    var max = BagOfTokens().bagOfTokensScore(tokens, power)
    println(max)

}

