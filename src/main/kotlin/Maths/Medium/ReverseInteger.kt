package Maths.Medium

import kotlin.math.pow

//@author Usman Fani

//Example 1:
//Input: x = 123
//Output: 321

//Example 2:
//Input: x = -123
//Output: -321

//Example 3:
//Input: x = 120
//Output: 21

// If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0
class ReverseInteger {

    fun reverse(x: Int): Int {
        val num = if (x < 0) x * -1 else x

        var rem: Int
        var div = num
        var res = 0.0
        div % 10
        while (div != 0) {
            rem = div % 10
            div /= 10
            if (res == 0.0 && rem == 0) continue
            res = res * 10 + rem
        }

        if (res in Math.pow(-2.0, 31.0)..Math.pow(2.0, 31.0) - 1) {
            if (x < 0) res *= -1
        } else res = 0.0

        return res.toInt()
    }

    fun reverseNum(x: Int): Int {
        var num = x
        var res = 0

        while (num != 0) {
            if (res > Int.MAX_VALUE / 10 || res < Int.MIN_VALUE / 10) return 0
            val rem = num % 10
            res = res * 10 + rem
            num /= 10

        }

        return res
    }
}