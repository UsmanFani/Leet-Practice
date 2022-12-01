package Strings.Easy

//@author Usman Fani
class AddStrings {
    //Example 1:
    //Input: num1 = "11", num2 = "123"
    //Output: "134"

    //Example 2:
    //Input: num1 = "456", num2 = "77"
    //Output: "533"

    //Example 3:
    //Input: num1 = "0", num2 = "0"
    //Output: "0"
    fun addStrings(num1: String, num2: String): String {
        var add = ""
        val num1 = num1.reversed()
        val num2 = num2.reversed()
        val maxIndex = maxOf(num1.lastIndex, num2.lastIndex)
        var carry = 0
        var n1 = 0
        var n2 = 0
        for (i in 0..maxIndex + 1) {
            n1 = 0; n2 = 0
            if (i in num1.indices) n1 = num1[i] - '0'
            if (i in num2.indices) n2 = num2[i] - '0'
            val sum = n1 + n2 + carry
            if (i == maxIndex + 1 && carry == 0) {
                continue
            } else add = (sum % 10).toString() + add
            carry = sum / 10

        }
        return add
    }
}