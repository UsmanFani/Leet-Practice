import dp.easy.CountingBits
import dp.medium.DecodeWays
import dp.medium.WordBreak

fun main() {

    var s = "leetcode"
    var wordDict = listOf("leet","code")
    var word = WordBreak().optimWordBreak(s,wordDict)
    println(word)

}

