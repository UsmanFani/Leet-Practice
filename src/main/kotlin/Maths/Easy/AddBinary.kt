package Maths.Easy

//@author Usman Fani
class AddBinary {
    fun addBinary(a: String, b: String): String {
        var aIndex = a.lastIndex
        var bIndex = b.lastIndex
        var maxIndex = maxOf(aIndex, bIndex)
        var carry = 0
        var res = ""

        while (maxIndex >= 0) {
            val aVal = if (aIndex >= 0) a[aIndex] - '0' else 0
            val bVal = if (bIndex >= 0) b[bIndex] - '0' else 0

            var sum = aVal + bVal + carry
            when (sum) {
                2 -> {
                    sum = 0; carry = 1
                }
                3 -> {
                    sum = 1; carry = 1
                }
                else -> carry = 0
            }

            res = sum.toString() + res

            aIndex--
            bIndex--
            maxIndex--
        }

        if (carry == 1) res = carry.toString() + res
        return res
    }
}