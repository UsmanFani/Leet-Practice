package Maths.Medium

//@author Usman Fani

//Example 1:
//Input: s = "42"
//Output: 42
//Explanation: The underlined characters are what is read in, the caret is the current reader position.
//Step 1: "42" (no characters read because there is no leading whitespace)
//         ^
//Step 2: "42" (no characters read because there is neither a '-' nor '+')
//         ^
//Step 3: "42" ("42" is read in)
//           ^
//The parsed integer is 42.
//Since 42 is in the range [-231, 231 - 1], the final result is 42.

//Example 2:
//Input: s = "   -42"
//Output: -42
//Explanation:
//Step 1: "   -42" (leading whitespace is read and ignored)
//            ^
//Step 2: "   -42" ('-' is read, so the result should be negative)
//             ^
//Step 3: "   -42" ("42" is read in)
//               ^
//The parsed integer is -42.
//Since -42 is in the range [-231, 231 - 1], the final result is -42.

//Example 3:
//Input: s = "4193 with words"
//Output: 4193
//Explanation:
//Step 1: "4193 with words" (no characters read because there is no leading whitespace)
//         ^
//Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
//         ^
//Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
//             ^
//The parsed integer is 4193.
//Since 4193 is in the range [-231, 231 - 1], the final result is 4193.

class StringToInt_Atoi {
    fun myAtoi(s: String): Int {
        var isDigit = false
        var res: Double? = null
        var isNegative = false
        var isPositive = false
        for (i in s) {

            val c = i - '0'
            if (c in 0..9) {
                isDigit = true
                val prevDigit = if (isNegative) res?.times(-1) else res
                res = if (res != null) {
                    res * 10 + c
                } else c.toDouble()

                val currDigit = if (isNegative) res.times(-1) else res
                if (currDigit < Int.MIN_VALUE || currDigit > Int.MAX_VALUE) {
                    return if (currDigit < Int.MIN_VALUE) Int.MIN_VALUE
                    else Int.MAX_VALUE
                }
            } else if (i != '+' && i != '-' && i != ' ') break
            else if (isPositive || isNegative || isDigit) break

            if (i == '+') isPositive = true
            if (i == '-') isNegative = true

        }

        if (res == null) return 0
        res = if (isNegative) res.times(-1) else res
        return res.toInt()
    }
}