package Maths.Medium

//@author Usman Fani
class IntegerBreak {
    fun integerBreak(n: Int): Int {
        val intMap = mutableMapOf<Int, Int>()
        intMap[1] = 1

        for (i in 2..n) {
            var tempMax = 0
            val mid = i / 2
            var j = 1
            while (i - j >= mid) {
                val num1 = i - j
                val num2 = j
                val mult = num1 * num2
                val tempNum1 = if (intMap.containsKey(num1)) maxOf(intMap[num1]!!, num1) else num1
                val tempNum2 = if (intMap.containsKey(num2)) maxOf(intMap[num2]!!, num2) else num2
                val tempMult = tempNum1 * tempNum2
                tempMax = maxOf(tempMax, maxOf(mult, tempMult))
                j++
            }
            intMap[i] = tempMax
        }

        return intMap[n]!!
    }

    fun optimIntBreak(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 1
        if (n == 3) return 2
        if (n == 4) return 4

        var num = n
        var res = 1
        while (num > 0) {
            res *= 3
            num -= 3

            if (num in 0..4) {
                res *= num
                num = 0
            }
        }
        return res
    }
}