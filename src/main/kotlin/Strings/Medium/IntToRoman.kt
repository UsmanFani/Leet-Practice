package Strings.Medium

//@author Usman Fani
class IntToRoman {
    //Example 1:
    //Input: num = 3
    //Output: "III"
    //Explanation: 3 is represented as 3 ones.

    //Example 2:
    //Input: num = 58
    //Output: "LVIII"
    //Explanation: L = 50, V = 5, III = 3.

    //Example 3:
    //Input: num = 1994
    //Output: "MCMXCIV"
    //Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
    fun intToRoman(num: Int): String {
        val romanList = mapOf(
            1000 to "M",
            900 to "CM",
            500 to "D",
            400 to "CD",
            100 to "C",
            90 to "XC",
            50 to "L",
            40 to "XL",
            10 to "X",
            9 to "IX",
            5 to "V",
            4 to "IV",
            1 to "I"
        )

        var rem = num
        var res = ""
        while (rem > 0) {
            for (i in romanList) {
                val div = rem / i.key
                if (div > 0) {
                    repeat(div) {
                        res += i.value
                    }
                    rem %= i.key
                    break
                }
            }
        }
        return res
    }
}