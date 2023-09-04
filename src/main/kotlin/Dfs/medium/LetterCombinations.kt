package Dfs.medium

//@author Usman Fani

//Leetcode: 17

//Example 1:
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

//Example 2:
//Input: digits = ""
//Output: []

//Example 3:
//Input: digits = "2"
//Output: ["a","b","c"]
class LetterCombinations {
    fun letterCombinations(digits: String): List<String> {
        val keyMap = arrayOf(
            listOf(),
            listOf(),
            listOf("a", "b", "c"),
            listOf("d", "e", "f"),
            listOf("g", "h", "i"),
            listOf("j", "k", "l"),
            listOf("m", "n", "o"),
            listOf("p", "q", "r", "s"),
            listOf("t", "u", "v"),
            listOf("w", "x", "y", "z")
        )

        var tempList = mutableListOf<String>()
        var finalList = mutableListOf<String>()

        val digitChar = digits.toCharArray()
        digitChar.reverse()

        digitChar.forEach {
            if (finalList.isEmpty()) finalList = keyMap[it - '0'].toMutableList()
            else {
                keyMap[it - '0'].forEach { str1 ->
                    finalList.forEach { str2 ->
                        tempList.add(str1 + str2)
                    }
                }
                finalList = tempList
                tempList = mutableListOf()
            }

        }
        return finalList

    }
}