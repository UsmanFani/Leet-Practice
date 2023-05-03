package Strings.Medium

//@author Usman Fani
class ReverseWords {
    //Example 1:
    //Input: s = "the sky is blue"
    //Output: "blue is sky the"

    //Example 2:
    //Input: s = "  hello world  "
    //Output: "world hello"
    //Explanation: Your reversed string should not contain leading or trailing spaces.

    //Example 3:
    //Input: s = "a good   example"
    //Output: "example good a"
    //Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
    fun reverseWords(s: String): String {
        var res = ""
        var word = ""
        for (i in s.lastIndex downTo 0) {
            if (s[i] == ' ') {
                if (word.isEmpty()) continue
                res = if (res.isEmpty()) word else "$res $word"
                word = ""
                continue
            }
            word = s[i] + word
        }

        if (res.isEmpty()&&word.isNotEmpty()) return word
        res = if (res.last() != ' ' && word.isNotEmpty()) "$res $word" else "$res$word"
        return res
    }
}