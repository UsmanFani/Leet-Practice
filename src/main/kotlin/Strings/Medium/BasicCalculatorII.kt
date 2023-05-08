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


    //"3"
    //"3+2*5/2"
    //"3  +2 * 5/ 2"

    fun basicCal(s: String): Int {
        val list = mutableListOf<String>()
        var flag = false
        var strToCalculate = ""
        var sign = ""
        for (it in s) {
            if (it == ' ') continue
            if (it == '+' || it == '-' || it == '*' || it == '/') {
                if (sign.isNotEmpty() && strToCalculate.isNotEmpty() && flag) {
                    if (sign == "/") list[list.lastIndex] = (list.last().toInt() / strToCalculate.toInt()).toString()
                    else list[list.lastIndex] = (list.last().toInt() * strToCalculate.toInt()).toString()
                    strToCalculate = ""
                    flag = false
                    sign = ""
                }
                if (it == '+' || it == '-') list.add(it.toString())
                else {
                    sign = it.toString()
                    flag = true
                }
            } else {
                if (flag) strToCalculate += it
                else if (list.isNotEmpty() && (list.last() == "+" || list.last() == "-")) list.add(it.toString())
                else if (list.isEmpty()) list.add(it.toString()) else list[list.lastIndex] = list.last() + it
            }
        }

        if (strToCalculate.isNotEmpty() && sign.isNotEmpty()) {
            if (sign == "/") list[list.lastIndex] = (list.last().toInt() / strToCalculate.toInt()).toString()
            else list[list.lastIndex] = (list.last().toInt() * strToCalculate.toInt()).toString()
        }

        list.forEachIndexed { index, str ->
            if (str == "+") {
                list[index + 1] = (list[index - 1].toInt() + list[index + 1].toInt()).toString()
            } else if (str == "-") {
                list[index + 1] = (list[index - 1].toInt() - list[index + 1].toInt()).toString()
            }
        }
        return list.last().toInt()
    }

    fun basicCalc(s: String): Int {
        var numSum = 0
        var numProd = 0
        var sign = '+'
        var num = 0
        s.forEachIndexed { index, c ->
            val isDigit = c.isDigit()
            if (isDigit) num = num * 10 + (c - '0')
            if (!isDigit && c != ' ' || index == s.lastIndex) {
                when (sign) {
                    '+' -> {
                        numSum += numProd; numProd = num
                    }
                    '-' -> {
                        numSum += numProd; numProd = -num
                    }
                    '*' -> {
                        numProd *= num
                    }
                    '/' -> {
                        numProd /= num
                    }
                }
                sign = c
                num = 0
            }
        }
        return numSum + numProd
    }
}