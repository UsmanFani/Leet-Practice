package Maths.Hard

import java.util.Stack

//@author Usman Fani

//Leetcode:224

//Example 1:
//Input: s = "1 + 1"
//Output: 2

//Example 2:
//Input: s = " 2-1 + 2 "
//Output: 3

//Example 3:
//Input: s = "(1+(4+5+2)-3)+(6+8)"
//Output: 23
class BasicCalculator {
    fun calculate(s: String): Int {
        return basic(s.toCharArray())
    }

    private var ind = 0
    private fun basic(expression: CharArray): Int {
        var sum = 0
        var multSign = 1
        var num = 0
        while (ind <= expression.lastIndex) {
            if (expression[ind] == ' ') {
                ind++
                continue
            }
            if (expression[ind] in '0'..'9') {
                num = num * 10 + (expression[ind]-'0')
            } else {
                when (expression[ind]) {
                    '(' -> {
                        sum += multSign * num
                        num = 0
                        ind++
                        sum += (multSign * basic(expression))
                    }
                    ')' -> {
                        sum += multSign * num
                        return sum
                    }
                    '+' -> {
                        sum += multSign * num
                        num = 0
                        multSign = 1
                    }
                    '-' -> {
                        sum += multSign * num
                        num = 0
                        multSign = -1
                    }
                }
            }
            ind++
        }
        if (num != 0) sum += multSign * num
        return sum
    }

}