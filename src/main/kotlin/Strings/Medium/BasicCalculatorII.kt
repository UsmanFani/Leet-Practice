package Strings.Medium

//@author Usman Fani
class BasicCalculatorII {
    //Example 1:
    //Input: s = "3+2*2"
    //Output: 7

    //Example 2:
    //Input: s = " 3/2 "
    //Output: 1

    //Example 3:
    //Input: s = " 3+5 / 2 "
    //Output: 5
    fun calculate(s: String): Int {
        var st = ""
        s.forEach {
            if (it != ' ') st += it
        }
        val list = mutableListOf<String>()
        var str = ""
        var index = 0
        for (i in 0..st.lastIndex) {
            if (i + index >= st.lastIndex) break
            if (st[i + index] == '*' || st[i + index] == '/' || st[i + index] == '+' || st[i + index] == '-') {
                if (st[i + index] == '+' || st[i + index] == '-') {
                    list.add(str)
                    list.add(st[i + index].toString())
                    str = ""
                } else {
                    list.add(str)
                    val sym = st[i + index]
                    var strForMultDiv = ""
                    index++
                    while (i + index <= st.lastIndex && (st[i + index] - '0') in 0..9) {
                        strForMultDiv += st[i + index]
                        index++
                    }
                    if (strForMultDiv.isNotEmpty()) {
                        if (sym == '*') {
                            list[list.lastIndex] = (list.last().toInt() * strForMultDiv.toInt()).toString()
                        } else list[list.lastIndex] = (list.last().toInt() / strForMultDiv.toInt()).toString()
                    }
                }
            }
            if (i + index > st.lastIndex) break
            if (str == "+" || str == "-") str = ""
            str += st[i + index]
        }
        if (list.isNotEmpty()) {
            for (i in 2..list.lastIndex step 2) {
                list[i] = if (list[i - 1] == "+") (list[i - 2].toInt() + list[i].toInt()).toString()
                else (list[i - 2].toInt() - list[i].toInt()).toString()
            }
        }
        return list.last().toInt()
    }
}