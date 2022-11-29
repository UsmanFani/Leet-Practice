package dp.hard

//@author Usman Fani
class WordBreakII {
    //Example 1:
    //Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
    //Output: ["cats and dog","cat sand dog"]

    //Example 2:
    //Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
    //Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
    //Explanation: Note that you are allowed to reuse a dictionary word.

    //Example 3:
    //Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
    //Output: []

    val map = mutableMapOf<Int, MutableList<String>>()
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val list = word(0, s.lastIndex, s, wordDict.toHashSet())
        return list
    }

    private fun word(
        start: Int, end: Int, s: String, dict: HashSet<String>
    ): MutableList<String> {
        if (map[end] != null) return map[end]!!
        if (end < 0) return mutableListOf()
        var str = ""
        val ls = mutableListOf<String>()
        for (i in end downTo start) {
            str = s[i] + str
            if (dict.contains(str)) {
                val list = word(start, i - 1, s, dict)
                if (i > 0 && list.isEmpty()) {
                    continue
                } else {
                    if (list.isNotEmpty()) {
                        list.forEach {
                            ls.add("$it $str")
                        }
                    } else ls.add(str)
                }

            }
        }
        map[end] = ls
        return map[end]!!
    }
}