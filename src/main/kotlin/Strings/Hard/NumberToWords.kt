package Strings.Hard

//@author Usman Fani

//Example 1:
//Input: num = 123
//Output: "One Hundred Twenty Three"

//Example 2:
//Input: num = 12345
//Output: "Twelve Thousand Three Hundred Forty Five"

//Example 3:
//Input: num = 1234567
//Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
class NumberToWords {
    private val wordMap = mapOf(
        1 to "One",
        2 to "Two",
        3 to "Three",
        4 to "Four",
        5 to "Five",
        6 to "Six",
        7 to "Seven",
        8 to "Eight",
        9 to "Nine",
        10 to "Ten",
        11 to "Eleven",
        12 to "Twelve",
        13 to "Thirteen",
        14 to "Fourteen",
        15 to "Fifteen",
        16 to "Sixteen",
        17 to "Seventeen",
        18 to "Eighteen",
        19 to "Nineteen",
        20 to "Twenty",
        30 to "Thirty",
        40 to "Forty",
        50 to "Fifty",
        60 to "Sixty",
        70 to "Seventy",
        80 to "Eighty",
        90 to "Ninety",
        100 to "Hundred"
    )
    private val unitMap = mapOf(
        1000000000 to "Billion",
        1000000 to "Million",
        1000 to "Thousand",
        100 to "Hundred",
        10 to "Ten",
        1 to "One"
    )

    fun numberToWords(num: Int): String {
        if (num == 0) return "Zero"
        val wordList = mutableListOf<String>()
        var number = num
        var rem = num
        for (i in unitMap) {
            if (rem == 0) break
            val unit = i.key
            if (rem / unit == 0) continue
            if (unit <= 100) {
                val word = numToWord(rem)
                wordList.add(word)
                break
            }
            number = rem / unit
            val word = numToWord(number)
            wordList.add("$word ${i.value}")
            rem %= unit
        }

        val wordString = StringBuilder()
        wordList.forEachIndexed { index, s ->
            if (wordList.lastIndex == index) wordString.append(s)
            else wordString.append("$s ")
        }
        return wordString.toString()
    }

    private fun numToWord(num: Int): String {
        if (num == 0) return ""
        val wordList = mutableListOf<String>()
        if (wordMap.containsKey(num) && num < 100) return wordMap[num]!!
        else {
            var unit = 100
            if (num / unit != 0) {
                val number = num / unit
                val tempNum = numToWord(num % unit)
                if (tempNum.isEmpty()) wordList.add(wordMap[number]!! + " " + wordMap[unit])
                else wordList.add(wordMap[number] + " " + wordMap[unit] + " " + tempNum)
            } else {
                unit = 10
                val tempNum = num / unit
                val rem = num % unit
                while (unit != 1) {
                    wordList.add(wordMap[tempNum * unit]!!)
                    if (wordMap.containsKey(rem)) {
                        wordList.add(wordMap[rem]!!);break
                    }
                    unit /= 10
                }
            }

        }
        val wordString = StringBuilder()
        wordList.forEachIndexed { index, s ->
            if (wordList.lastIndex == index) wordString.append(s)
            else wordString.append("$s ")
        }
        return wordString.toString()
    }
}