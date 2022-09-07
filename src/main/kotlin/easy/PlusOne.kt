package easy

class PlusOne {
    //Example 1:
    //Input: digits = [1,2,3]
    //Output: [1,2,4]
    //Explanation: The array represents the integer 123.
    //Incrementing by one gives 123 + 1 = 124.
    //Thus, the result should be [1,2,4].

    //Example 2:
    //Input: digits = [4,3,2,1]
    //Output: [4,3,2,2]
    //Explanation: The array represents the integer 4321.
    //Incrementing by one gives 4321 + 1 = 4322.
    //Thus, the result should be [4,3,2,2].

    //Example 3:
    //Input: digits = [9]
    //Output: [1,0]
    //Explanation: The array represents the integer 9.
    //Incrementing by one gives 9 + 1 = 10.
    //Thus, the result should be [1,0].
    fun plusOne(digits: IntArray): IntArray {
        val list = mutableListOf<Int>()

        for (i in digits.lastIndex downTo 0) {
            if (i == 0) {
                if (digits[0] == 9) {
                    digits[i] = 0
                    list.add(0)
                    list.add(1)
                } else {
                    digits[i]++
                    return digits
                }
            } else {
                if (digits[i] == 9) {
                    digits[i] = 0
                    list.add(digits[i])
                } else {
                    digits[i]++
                    list.add(digits[i])
                    return digits
                }
            }
        }
        list.reverse()
        return list.toIntArray()
    }

    fun optimPlusOne(digits:IntArray):IntArray{
        for(i in digits.lastIndex downTo 0){
            digits[i]++
            if(digits[i]<=9)return digits
            digits[i] = 0
        }
        //array will fill with default value 0
        var arr = IntArray(digits.size+1)
        arr[0] = 1
        return arr
    }
}