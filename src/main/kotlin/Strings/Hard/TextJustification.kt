package Strings.Hard

//@author Usman Fani
class TextJustification {
    //Example 1:
    //Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
    //Output:
    //[
    //   "This    is    an",
    //   "example  of text",
    //   "justification.  "
    //]

    //Example 2:
    //Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
    //Output:
    //[
    //  "What   must   be",
    //  "acknowledgment  ",
    //  "shall be        "
    //]
    //Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
    //Note that the second line is also left-justified because it contains only one word.

    //Example 3:
    //Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
    //Output:
    //[
    //  "Science  is  what we",
    //  "understand      well",
    //  "enough to explain to",
    //  "a  computer.  Art is",
    //  "everything  else  we",
    //  "do                  "
    //]
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val resList = mutableListOf<String>()
        var tempList = mutableListOf<String>()
        var len = 0
        words.forEach {
            len += it.length
            val currLen = if (tempList.size == 0) len else tempList.size + len
            if (currLen > maxWidth) {
                val str = if (tempList.size == 1) lastJustify(tempList, len-it.length, maxWidth)
                else createJustifyString(tempList, currLen - it.length - 1, maxWidth)
                resList.add(str)
                len = it.length
                tempList = mutableListOf(it)
            } else tempList.add(it)
        }
        val str = lastJustify(tempList, len, maxWidth)
        resList.add(str)
        return resList
    }

    private fun createJustifyString(strList: List<String>, len: Int, maxWidth: Int): String {
        val gaps = if (strList.size == 1) maxWidth - len else ((maxWidth - len) / (strList.size - 1)) + 1
        var rem = if (strList.size == 1) 0 else (maxWidth - len) % (strList.size - 1)
        val gapStr = StringBuilder()
        repeat(gaps) {
            gapStr.append(" ")
        }
        val res = StringBuilder()
        strList.forEachIndexed { index, s ->
            res.append(s)
            if (rem != 0) {
                res.append(" ")
                rem--
            }
            if (index != strList.lastIndex) res.append(gapStr)
        }
        return res.toString()
    }

    private fun lastJustify(list: List<String>, len: Int, maxWidth: Int): String {
        val gaps = maxWidth - len - (list.size - 1)
        val str = StringBuilder()
        list.forEachIndexed { index, s ->
            str.append(s)
            if (index == list.lastIndex) repeat(gaps) {
                str.append(" ")
            } else str.append(" ")
        }
        return str.toString()
    }
}