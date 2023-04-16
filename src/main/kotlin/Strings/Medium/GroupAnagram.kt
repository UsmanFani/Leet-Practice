package Strings.Medium

//@author Usman Fani
class GroupAnagram {
    //Example 1:
    //Input: strs = ["eat","tea","tan","ate","nat","bat"]
    //Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    //Example 2:
    //Input: strs = [""]

    //Output: [[""]]

    //Example 3:
    //Input: strs = ["a"]
    //Output: [["a"]]
    fun groupAnagram(strs: Array<String>): List<List<String>> {
        val charCountList = mutableListOf<Map<Char, Int>>()
        val visitedMap = mutableSetOf<Int>()
        val anagramList = mutableListOf<List<String>>()
        strs.forEach {
            charCountList.add(countMap(it))
        }
        charCountList.forEachIndexed { index, map ->
            if (!visitedMap.contains(index)) {
                val list = mutableListOf<String>(strs[index])
                for (i in index + 1..charCountList.lastIndex) {
                    if (visitedMap.contains(i)) continue
                    if (map.equals(charCountList[i])) {
                        list.add(strs[i])
                        visitedMap.add(i)
                    }
                }
                if (list.isNotEmpty()) anagramList.add(list)
            }
        }
        return anagramList
    }

    private fun countMap(s: String): Map<Char, Int> {
        val charMap = mutableMapOf<Char, Int>()
        s.forEach {
            if (charMap.containsKey(it)) {
                charMap[it] = charMap[it]!! + 1
            } else charMap[it] = 1
        }
        return charMap
    }

}

