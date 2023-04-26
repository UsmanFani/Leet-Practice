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
        val map = hashMapOf<String, MutableList<String>>()
        val resultList = mutableListOf<List<String>>()
        strs.forEach {
            val strToChar = it.toCharArray()
            strToChar.sort()
            val sortedString = String(strToChar)
            if (map.containsKey(sortedString)) {
                val list = map[sortedString]
                list!!.add(it)
                map[sortedString] = list
            } else map[sortedString] = mutableListOf(it)
        }

        map.forEach {
            resultList.add(it.value)
        }
        return resultList
    }


}

