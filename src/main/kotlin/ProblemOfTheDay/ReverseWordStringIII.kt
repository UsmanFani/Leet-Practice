package ProblemOfTheDay

class ReverseWordStringIII {
    //Example 1:
    //Input: s = "Let's take LeetCode contest"
    //Output: "s'teL ekat edoCteeL tsetnoc"

    //Example 2:
    //Input: s = "God Ding"
    //Output: "doG gniD"
    fun reverseWords(s: String): String {
        var start = 0
        var end: Int
        var str = ""
        for (i in s.indices) {
            if (i == s.lastIndex) {
                end = i
                while (start <= end) {
                    str += s[end]
                    end--
                }
            }
            if (s[i] == ' ') {
                end = i-1
                while (start <= end) {
                    str += s[end]
                    end--
                }
                str += " "
                start = i + 1
            }
        }
        return str
    }

    fun optimReverseWords(s:String):String{
        var str = ""
        var temp = ""
        for (i in s.indices){
            if (i==s.lastIndex){
                temp += s[i]
                str += temp.reversed()
            }
            else if (s[i]==' ') {
                str += temp.reversed()
                str += " "
                temp = ""
            }else temp += s[i]
        }
        return str
    }
}