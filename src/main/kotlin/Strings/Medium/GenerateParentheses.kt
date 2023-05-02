package Strings.Medium

//@author Usman Fani
class GenerateParentheses {
    //Example 1:
    //Input: n = 3
    //Output: ["((()))","(()())","(())()","()(())","()()()"]

    //Example 2:
    //Input: n = 1
    //Output: ["()"]
    fun generateParenthesis(n: Int): List<String> {
        val str = "("
        val list = mutableListOf<String>()
        generate(n - 1, n, str, list)
        return list
    }

    private fun generate(open: Int, close: Int, str: String, list: MutableList<String>) {
        if (open == 0 && close == 0) list.add(str)

        if (close > open) {
            val str = "$str)"
            generate(open, close - 1, str, list)
        }

        if (open > 0) {
            val str = "$str("
            generate(open - 1, close, str, list)
        }
    }
}