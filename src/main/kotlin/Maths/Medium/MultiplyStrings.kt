package Maths.Medium

//@author Usman Fani

//Example 1:
//Input: num1 = "2", num2 = "3"
//Output: "6"

//Example 2:
//Input: num1 = "123", num2 = "456"
//Output: "56088"
class MultiplyStrings {
    fun multiply(num1: String, num2: String): String {
        val res = arrayListOf<Int>()
        for (i in num2.lastIndex downTo 0) {
            val n2 = num2[i] - '0'
            for (j in num1.lastIndex downTo 0) {
                val n1 = num1[j] - '0'
                val mul = n1 * n2
                var carry = mul / 10
                var digit = mul % 10
                var index = (num2.lastIndex - i) + (num1.lastIndex - j)
                if (index > res.lastIndex) {
                    res.add(digit)
                    if (carry != 0) res.add(carry)
                } else {
                    var counter = index
                    var sum = res[counter] + digit
                    digit = sum % 10
                    var carry2 = sum / 10
                    res[counter] = digit
                    counter++
                    while (carry2 != 0) {
                        if (counter > res.lastIndex) {
                            res.add(carry2);break
                        }
                        sum = res[counter] + carry2
                        digit = sum % 10
                        res[counter] = digit
                        carry2 = (sum / 10)
                        counter++
                    }

                    index++

                    if (carry != 0) {
                        if (index > res.lastIndex) {
                            res.add(carry)
                            continue
                        }
                        val carrySum = res[index] + carry
                        digit = carrySum % 10
                        carry = carrySum / 10
                        res[index] = digit
                        index++
                        while (carry != 0) {
                            if (index > res.lastIndex) {
                                res.add(carry);break
                            }
                            sum = res[index] + carry
                            digit = sum % 10
                            res[index] = digit
                            carry = (sum / 10)
                            index++
                        }
                    }

                }

            }
        }

        res.reverse()
        if (res.sum() == 0) return "0"
        return res.joinToString("")
    }

    fun optimMultiply(num1: String, num2: String): String {
        val res = arrayListOf<Int>()
        var counter = 0
        for (num1Index in num1.lastIndex downTo 0) {
            for (num2Index in num2.lastIndex downTo 0) {
                val n1 = num1[num1Index]
                val n2 = num2[num2Index]
                val mul = (n1 - '0') * (n2 - '0')
                if (num2.lastIndex - num2Index + counter <= res.lastIndex) res[num2.lastIndex - num2Index + counter] += mul
                else res.add(mul)
            }
            counter++
        }
        var carry = 0

        res.forEachIndexed { index, i ->
            val sum = carry + i
            carry = sum / 10
            val digit = sum % 10
            res[index] = digit
        }
        if (carry != 0) res.add(carry)
        if (res.sum() == 0) return "0"
        res.reverse()
        return res.joinToString("")
    }
}