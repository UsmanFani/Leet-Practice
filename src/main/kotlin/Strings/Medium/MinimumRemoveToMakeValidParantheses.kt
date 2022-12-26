package Strings.Medium

//@author Usman Fani
class MinimumRemoveToMakeValidParantheses {
    //Example 1:
    //Input: s = "lee(t(c)o)de)"
    //Output: "lee(t(c)o)de"
    //Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

    //Example 2:
    //Input: s = "a)b(c)d"
    //Output: "ab(c)d"

    //Example 3:
    //Input: s = "))(("
    //Output: ""
    //Explanation: An empty string is also valid.
    fun minRemoveToMakeValid(s: String): String {
        var res = ""
        var check = 0
        s.forEach {
            if (it == ')' && check == 0) {

            } else {
                if (it == '(') check++
                else if (it == ')') check--
                res += it
            }
        }
        return if (check != 0) {
            var str = ""
            for (i in res.lastIndex downTo 0) {
                if (check > 0 && res[i] == '(') {
                    check--
                } else str = res[i] + str
            }
            str
        } else res
    }
}