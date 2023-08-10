package greedy.medium

import java.util.Stack

//@author Usman Fani

//Example 1:
//Input: num = "1432219", k = 3
//Output: "1219"
//Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

//Example 2:
//Input: num = "10200", k = 1
//Output: "200"
//Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

//Example 3:
//Input: num = "10", k = 2
//Output: "0"
//Explanation: Remove all the digits from the number and it is left with nothing which is 0.
class RemoveKDigits {
    fun removeKDigits(num: String, k: Int): String {
        var k = k
        val numStack = Stack<Char>()
        for (it in num) {
            if (k == 0) {
                if (numStack.isEmpty() && it == '0')
                else numStack.push(it)
                continue
            }
            if (numStack.isEmpty()) {
                if (it != '0') numStack.push(it)
            } else {
                if (numStack.peek() > it) {
                    numStack.pop()
                    k--
                    while (k != 0 && numStack.isNotEmpty() && numStack.peek() > it) {
                        numStack.pop()
                        k--
                    }
                    if (numStack.isEmpty() && it == '0')
                    else numStack.push(it)
                } else numStack.push(it)
            }
        }
        repeat(k) {
            if (numStack.isNotEmpty()) numStack.pop()
        }
        return if (numStack.isEmpty()) "0"
        else String(numStack.toCharArray())
    }
}