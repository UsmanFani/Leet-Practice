package Strings.Easy

//@author Usman Fani
class RomanToInt {
    //Example 1:
    //Input: s = "III"
    //Output: 3
    //Explanation: III = 3.

    //Example 2:
    //Input: s = "LVIII"
    //Output: 58
    //Explanation: L = 50, V= 5, III = 3.

    //Example 3:
    //Input: s = "MCMXCIV"
    //Output: 1994
    //Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
    fun romanToInt(s: String): Int {
        var prev = 0
        var curr = 0
        var res = 0
        s.forEach {
            curr = when (it) {
                'I' -> 1
                'V' -> 5
                'X' -> 10
                'L' -> 50
                'C' -> 100
                'D' -> 500
                'M' -> 1000
                else -> {
                    0
                }
            }

            res += if (prev < curr) curr - (2 * prev)
            else curr
            prev = curr
        }
        return res
    }
}