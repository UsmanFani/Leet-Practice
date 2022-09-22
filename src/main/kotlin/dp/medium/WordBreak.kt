package dp.medium

class WordBreak {
    //Example 1:
    //Input: s = "leetcode", wordDict = ["leet","code"]
    //Output: true
    //Explanation: Return true because "leetcode" can be segmented as "leet code".

    //Example 2:
    //Input: s = "applepenapple", wordDict = ["apple","pen"]
    //Output: true
    //Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
    //Note that you are allowed to reuse a dictionary word.

    //Example 3:
    //Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
    //Output: false
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val map = mutableMapOf<Char, MutableList<Int>>()
        for (i in wordDict.indices) {
            val firstChar = wordDict[i][0]
            if (map.containsKey(firstChar)) {
                map[firstChar]!!.add(i)
            } else map[firstChar] = mutableListOf(i)
        }
        return word(s, wordDict, map, 0)
    }

    private fun word(s: String, wordDict: List<String>, map: Map<Char, List<Int>>, pos: Int): Boolean {
        if (pos == s.length) return true
        if (map.containsKey(s[pos])) {
            val charIndexInDict = map[s[pos]]!!
            charIndexInDict.forEach {
                if (pos + wordDict[it].lastIndex <= s.lastIndex) {
                    val subString = s.substring(pos, pos + wordDict[it].length)
                    val str = wordDict[it]
                    if (subString == str) {
                        if (word(s, wordDict, map, pos + wordDict[it].length)) return true
                    }
                }
//                for (j in 0..wordDict[it].lastIndex) {
//                    if(pos+j>s.lastIndex)break
//                    if (s[pos + j] != wordDict[it][j]) break
//                    if (j == wordDict[it].lastIndex) {
//                        if (word(s, wordDict, map, pos + j+1))return true
//                    }
//                }
            }
        } else return false
        return false
    }

    fun optimWordBreak(s: String, wordDict: List<String>): Boolean {
        val dp = BooleanArray(s.length + 1) { false }
        dp[0] = true
        for (i in 1..dp.lastIndex) {
            for (str in wordDict) {
                if (str.length > i) continue
                val sub = s.substring(i - str.length, i)
                if (dp[i - str.length] && sub == str) dp[i] = true
            }
        }
        return dp.last()
    }
}